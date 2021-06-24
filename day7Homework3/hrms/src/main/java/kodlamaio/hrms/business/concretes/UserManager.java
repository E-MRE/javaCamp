package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.senders.VerificationCodeSender;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	private VerificationCodeSender sender;

	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
		sender = new VerificationCodeSender();
	}

	@Override
	public Result checkEmailVerified(String email) {
		var user = userDao.getByEmail(email);
		if(user == null) {
			return new ErrorResult("Böyle bir kayıt yok");
		}
		else if(!user.isVerified()) {
			return new ErrorResult("E-posta onaylı değil");
		}
		else {
			return new SuccessResult("E-posta onaylı");
		}
	}

	@Override
	public Result sendVerificationCode(String email, String verificationCode) {
		sender.sendVerificationCode(email, verificationCode);
		return new SuccessResult("Doğrulama kodu gönderildi");
	}

	@Override
	public Result checkEmailAlreadyExist(String email) {
		var user = userDao.getByEmail(email);
		
		if(user != null) {
			return new SuccessResult("Bu e-posta zaten kullanılıyor");
		}
		else {
			return new ErrorResult("Bu e-posta kullanılabilir");
		}
	}
	
}
