package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface IdentityControlService {
	boolean userValid(JobSeeker jobSeeker);
}
