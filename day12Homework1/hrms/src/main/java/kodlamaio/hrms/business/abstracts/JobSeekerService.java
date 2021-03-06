package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	DataResult<List<JobSeeker>> getAll();
	
	DataResult<JobSeeker> getJobSeekerById(int jobSeekerId);
	
	Result add(JobSeeker jobSeeker);
	
	Result checkAlreadyExistIdentity(String nationalIdentity);
}
