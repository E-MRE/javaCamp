package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	
	Result add(JobPosition jobPosition);
	
	DataResult<List<JobPosition>> getActiveJobPositions();
	
	DataResult<List<JobPosition>> getActiveJobPositionsByCreationDate(String creationDate);
	
	DataResult<List<JobPosition>> getActiveJobPositionsSorted(boolean isDesc);
	
	DataResult<List<JobPosition>> getActiveJobPositionsByCompanyName(String companyName);
	
	Result updateJobPositionStatus(int positionId, boolean isActive);
}
