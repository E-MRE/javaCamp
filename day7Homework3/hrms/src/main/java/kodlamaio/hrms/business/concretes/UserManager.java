package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.abstracts.IdentityControlService;
import kodlamaio.hrms.core.abstracts.UserValidationService;
import kodlamaio.hrms.core.senders.VerificationCodeSender;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private IdentityControlService mernisControl;
	private UserValidationService validationService;
	private VerificationCodeSender codeSender = new VerificationCodeSender();

	@Autowired
	public UserManager(UserDao userDao, IdentityControlService mernisControl, UserValidationService validationService) {
		this.userDao = userDao;
		this.mernisControl = mernisControl;
		this.validationService = validationService;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll(),"Kullanıcılar listelendi");
	}

	@Override
	public Result add(User user) {
		if(!validationService.userInfoValid(user)) {
			return new ErrorResult("Eksik bilgi girildi");
		}
		else if(!validationService.emailFormatValid(user.getEmail())) {
			return new ErrorResult("Hatalı e-posta girdiniz");
		}
		else if(!mernisControl.userValid(user)) {
			return new ErrorResult("Kullanıcı T.C. numarası hatalı");
		}
		else if(userDao.findByEmail(user.getEmail()).size() != 0) {
			return new ErrorResult("Bu e-posta ile kayıtlı bir kullanıcı mevcut");
		}
		else if(userDao.findByNationalIdentity(user.getNationalIdentity()).size() != 0) {
			return new ErrorResult("Böyle bir kayıt zaten sistemde mevcut");
		}
		else {
			codeSender.sendVerificationCode(user.getEmail(), user.getUserId() + "HRMS");
			userDao.save(user);
			
			return new SuccessResult("Kayıt başarılı! E-posta adresine gönderilen onay kodunu girdikten sonra sisteme giriş yapabilirsin");
		}
	}
	
}
