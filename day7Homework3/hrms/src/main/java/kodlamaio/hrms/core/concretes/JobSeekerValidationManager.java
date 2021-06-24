package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.JobSeekerValidationService;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerValidationManager extends UserValidationManager implements JobSeekerValidationService {
	
	@Override
	public boolean userInfoValid(JobSeeker jobSeeker) {
		boolean checkInfoFirst = jobSeeker.getName() != "" && jobSeeker.getNationalIdentity() != "" && jobSeeker.getSurname() != "" && jobSeeker.getBirthDate() != "" && jobSeeker.getEmail() != "" && jobSeeker.getPassword() != "" && jobSeeker.getUserType().getUserType() != "";
		boolean checkInfoSecond = jobSeeker.getName() != null && jobSeeker.getNationalIdentity() != null && jobSeeker.getSurname() != null && jobSeeker.getBirthDate() != null && jobSeeker.getEmail() != null && jobSeeker.getPassword() != null && jobSeeker.getUserType().getUserType() != null;
		
		return checkInfoFirst && checkInfoSecond;
	}
}
