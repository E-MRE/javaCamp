package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.abstracts.IdentityControlService;
import kodlamaio.hrms.core.abstracts.JobSeekerValidationService;
import kodlamaio.hrms.core.senders.VerificationCodeSender;
import kodlamaio.hrms.core.utilities.Validation;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private JobSeekerValidationService validationService;
	private VerificationCodeSender sender;
	private IdentityControlService mernisControl;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, JobSeekerValidationService validationService, IdentityControlService mernisControl) {
		this.jobSeekerDao = jobSeekerDao;
		this.validationService = validationService;
		this.mernisControl = mernisControl;
		sender = new VerificationCodeSender();
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if(!validationService.userInfoValid(jobSeeker)) {
			return new ErrorResult("Eksik bilgi girildi");
		}
		else if(!Validation.emailFormatValid(jobSeeker.getUser().getEmail())) {
			return new ErrorResult("Hatalı e-posta girdiniz");
		}
		else if(!mernisControl.userValid(jobSeeker)) {
			return new ErrorResult("Kullanıcı kimlik numarası hatalı");
		}
		
		var emailExistResult = jobSeekerDao.findByUser_Email(jobSeeker.getUser().getEmail());
		if(emailExistResult != null) {
			return new ErrorResult("Bu e-posta başkası tarafından kullanılıyor");
		}
		
		var identityExistResult = checkAlreadyExistIdentity(jobSeeker.getNationalIdentity());
		if(identityExistResult.isSuccess()) {
			return identityExistResult;
		}
		
		sender.sendVerificationCode(jobSeeker.getUser().getEmail(), "JBSK" + jobSeeker.getUser().getUserId());
		jobSeekerDao.save(jobSeeker);
		
		return new SuccessResult("Kayıt başarılı! E-posta adresine gönderilen onay kodunu girdikten sonra sisteme giriş yapabilirsin");
	}

	@Override
	public Result checkAlreadyExistIdentity(String nationalIdentity) {
		var jobSeeker = jobSeekerDao.getByNationalIdentity(nationalIdentity);
		
		if(jobSeeker != null) {
			return new SuccessResult("Kimlik numarası zaten kullanımda");
		}
		
		return new ErrorResult("Kimlik numarası kullanılabilir");
	}

	@Override
	public DataResult<JobSeeker> getJobSeekerById(int jobSeekerId) {
		return new SuccessDataResult<JobSeeker>(jobSeekerDao.findByJobSeekerId(jobSeekerId),"Aday getirildi");
	}
}
