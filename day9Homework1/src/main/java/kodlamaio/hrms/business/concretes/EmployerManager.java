package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.EmployerValidationService;
import kodlamaio.hrms.core.senders.VerificationCodeSender;
import kodlamaio.hrms.core.utilities.Validation;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService  {
	
	private EmployerValidationService validationService;
	private VerificationCodeSender sender;
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerValidationService validationService) {
		this.employerDao = employerDao;
		this.validationService = validationService;
		sender = new VerificationCodeSender();
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"İş verenler listelendi");
	}

	@Override
	public Result add(Employer employer) {
		if(!validationService.employerValid(employer)) {
			return new ErrorResult("Eksik bilgi girildi");
		}
		else if(!Validation.emailFormatValid(employer.getUser().getEmail())) {
			return new ErrorResult("Hatalı e-posta girdiniz");
		}
		else if(!validationService.checkCompanyEmail(employer.getUser().getEmail(), employer.getWebsite())){
			return new ErrorResult("Kayıt için şirket e-postanızı kullanmalısınız");
		}
		
		var emailExistResult = employerDao.findByUser_Email(employer.getUser().getEmail());
		if(emailExistResult != null) {
			return new ErrorResult("Bu e-posta başkası tarafından kullanılıyor");
		}
		
		employerDao.save(employer);
		sender.sendVerificationCode(employer.getUser().getEmail(), "EMPLYR" + employer.getUser().getUserId());
		
		return new SuccessResult("Kayıt başarılı! E-posta adresine gönderilen onay kodunu girdikten sonra sisteme giriş yapabilirsin");
	}
}
