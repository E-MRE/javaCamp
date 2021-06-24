package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.EmployerValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager extends UserManager implements EmployerService  {
	
	private EmployerValidationService validationService;
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao, EmployerValidationService validationService) {
		super(userDao);
		this.employerDao = employerDao;
		this.validationService = validationService;
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
		else if(!validationService.emailFormatValid(employer.getEmail())) {
			return new ErrorResult("Hatalı e-posta girdiniz");
		}
		else if(!validationService.checkCompanyEmail(employer.getEmail(), employer.getWebsite())){
			return new ErrorResult("Kayıt için şirket e-postanızı kullanmalısınız");
		}
		
		var emailExistResult = checkEmailAlreadyExist(employer.getEmail());
		if(emailExistResult.isSuccess()) {
			return emailExistResult;
		}
		
		System.out.println(employer.getUserId());
		employerDao.save(employer);
		sendVerificationCode(employer.getEmail(), "EMPLYR" + employer.getUserId());
		
		return new SuccessResult("Kayıt başarılı! E-posta adresine gönderilen onay kodunu girdikten sonra sisteme giriş yapabilirsin");
	}
}
