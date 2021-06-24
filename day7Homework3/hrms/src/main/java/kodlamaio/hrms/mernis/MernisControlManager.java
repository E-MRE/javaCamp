package kodlamaio.hrms.mernis;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public class MernisControlManager {
	
	public boolean userVerified(JobSeeker jobSeeker) {
		if(jobSeeker.getNationalIdentity().length() < 11)
			return false;
		
		return true;
	}
}
