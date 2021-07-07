package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;

public interface JobSeekerLanguageService {

	Result add(JobSeekerLanguage jobSeekerLanguage);
	
	Result addAll(List<JobSeekerLanguage> languages);
}
