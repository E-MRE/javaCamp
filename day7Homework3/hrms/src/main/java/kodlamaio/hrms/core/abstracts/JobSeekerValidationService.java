package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerValidationService extends UserValidationService {
	boolean userInfoValid(JobSeeker jobSeeker);
}
