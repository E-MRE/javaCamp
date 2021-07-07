package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {
		experienceDao.save(experience);
		return new SuccessResult("İş tecrübesi eklendi");
	}

	@Override
	public DataResult<List<Experience>> getExperiencesDescById(int jobSeekerId) {
		Sort sort = Sort.by(Direction.DESC,"finishDate");
		return new SuccessDataResult<List<Experience>>(experienceDao.findByJobSeeker_JobSeekerId(jobSeekerId, sort));
	}

	@Override
	public Result addAll(List<Experience> experiences) {
		experienceDao.saveAll(experiences);
		return new SuccessResult("İş tecrübeleri eklendi");
	}

}
