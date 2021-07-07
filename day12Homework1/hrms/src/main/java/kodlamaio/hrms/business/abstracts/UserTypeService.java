package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UserType;

public interface UserTypeService {

	DataResult<List<UserType>> getAll();
	
	Result add(UserType userType);
}
