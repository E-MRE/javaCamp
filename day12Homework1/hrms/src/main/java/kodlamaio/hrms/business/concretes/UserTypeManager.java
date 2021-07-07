package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserTypeDao;
import kodlamaio.hrms.entities.concretes.UserType;

@Service
public class UserTypeManager implements UserTypeService {

	private UserTypeDao userTypeDao;

	@Autowired
	public UserTypeManager(UserTypeDao userTypeDa) {
		this.userTypeDao = userTypeDa;
	}

	@Override
	public DataResult<List<UserType>> getAll() {
		return new SuccessDataResult<List<UserType>>(userTypeDao.findAll());
	}

	@Override
	public Result add(UserType userType) {
		if(userType.getUserType() == "")
			return new ErrorResult("Lütfen tüm alanları doldurun!");
		
		userTypeDao.save(userType);
		return new SuccessResult("İşlem başarılı");
	}
	
}
