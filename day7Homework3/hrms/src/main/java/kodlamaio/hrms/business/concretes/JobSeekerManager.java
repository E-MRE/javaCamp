package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.abstracts.IdentityControlService;
import kodlamaio.hrms.core.abstracts.JobSeekerValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager extends UserManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private JobSeekerValidationService validationService;
	private IdentityControlService mernisControl;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserDao userDao, JobSeekerValidationService validationService, IdentityControlService mernisControl) {
		super(userDao);
		this.jobSeekerDao = jobSeekerDao;
		this.validationService = validationService;
		this.mernisControl = mernisControl;
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
		else if(!validationService.emailFormatValid(jobSeeker.getEmail())) {
			return new ErrorResult("Hatalı e-posta girdiniz");
		}
		else if(!mernisControl.userValid(jobSeeker)) {
			return new ErrorResult("Kullanıcı kimlik numarası hatalı");
		}
		
		var emailExistResult = checkEmailAlreadyExist(jobSeeker.getEmail());
		if(emailExistResult.isSuccess()) {
			return emailExistResult;
		}
		
		var identityExistResult = checkAlreadyExistIdentity(jobSeeker.getNationalIdentity());
		if(identityExistResult.isSuccess()) {
			return identityExistResult;
		}
		
		System.out.println(jobSeeker.getUserId());
		sendVerificationCode(jobSeeker.getEmail(), "JBSK" + jobSeeker.getUserId());
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
	
	

}
