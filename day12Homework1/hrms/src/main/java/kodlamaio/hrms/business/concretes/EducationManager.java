package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		educationDao.save(education);
		return new SuccessResult("Eğitim bilgisi eklendi");
	}

	@Override
	public DataResult<List<Education>> getSchoolsDescById(int jobSeekerId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "finishDate");
		return new SuccessDataResult<List<Education>>(educationDao.findByJobSeeker_JobSeekerId(jobSeekerId, sort));
	}

	@Override
	public Result addAll(List<Education> educations) {
		educationDao.saveAll(educations);
		return new SuccessResult("Eğitim bilgileri eklendi");
	}

}
