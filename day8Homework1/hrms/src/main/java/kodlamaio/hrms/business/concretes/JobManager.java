package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(jobDao.findAll(),"İşler listelendi");
	}

}
