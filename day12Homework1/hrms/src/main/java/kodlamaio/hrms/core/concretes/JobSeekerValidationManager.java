package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.JobSeekerValidationService;
import kodlamaio.hrms.core.utilities.Validation;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerValidationManager implements JobSeekerValidationService {
	
	@Override
	public boolean userInfoValid(JobSeeker jobSeeker) {
		
		return !(Validation.stringsIsNullOrEmpty(jobSeeker.getName(), jobSeeker.getNationalIdentity(), jobSeeker.getSurname(), jobSeeker.getBirthDate(),
				jobSeeker.getUser().getEmail(), jobSeeker.getUser().getPassword(), jobSeeker.getUser().getUserType().getUserType()));
	}
}
