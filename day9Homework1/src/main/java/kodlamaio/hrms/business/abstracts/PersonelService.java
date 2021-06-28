package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Personel;

public interface PersonelService {
	
	DataResult<List<Personel>> getAll();
	
	Result veriftEmployer(int employerId);
}
