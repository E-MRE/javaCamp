package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerValidationService {
	boolean userInfoValid(JobSeeker jobSeeker);
}
