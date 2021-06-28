package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

	private JobSeekerLanguageDao languageDao;

	@Autowired
	public JobSeekerLanguageManager(JobSeekerLanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public Result add(JobSeekerLanguage jobSeekerLanguage) {
		
		if(jobSeekerLanguage.getLanguageLevel() < 1 || jobSeekerLanguage.getLanguageLevel() > 5) {
			return new ErrorResult("Aralık dışı");
		}
		
		languageDao.save(jobSeekerLanguage);
		return new SuccessResult("Yabancı dil eklendi");
	}

	@Override
	public Result addAll(List<JobSeekerLanguage> languages) {
		languageDao.saveAll(languages);
		return new SuccessResult("Yabancı diller eklendi");
	}
	
}
