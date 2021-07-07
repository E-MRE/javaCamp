package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.abstracts.JobPositionValidationService;
import kodlamaio.hrms.core.utilities.Validation;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	private JobPositionValidationService validationService;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao, JobPositionValidationService validationService) {
		this.jobPositionDao = jobPositionDao;
		this.validationService = validationService;
	}


	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(), "Pozisyonlar listelendi");
	}


	@Override
	public Result add(JobPosition jobPosition) {
		
		var result = validationService.jobPositionIsValid(jobPosition);
		if(!result.isSuccess()) {
			return result;
		}

		jobPosition.setPositionActive(false);
		jobPositionDao.save(jobPosition);
		return new SuccessResult("İş ilanı başarıyla eklendi");
	}


	@Override
	public DataResult<List<JobPosition>> getActiveJobPositions() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findByPositionActiveTrue(),"Aktif pozisyonlar listelendi");
	}


	@Override
	public DataResult<List<JobPosition>> getActiveJobPositionsByCreationDate(String creationDate) {
		var localDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		var dateTime = LocalDateTime.parse(creationDate, localDate);
		
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findByPositionActiveTrueAndCreationDate(dateTime),"Aktif pozisyonlar listelendi");
		
	}


	@Override
	public DataResult<List<JobPosition>> getActiveJobPositionsSorted(boolean isDesc) {
		
		Sort sort;
		if(isDesc)
			sort = Sort.by(Sort.Direction.DESC,"creationDate");
		else
			sort = Sort.by(Sort.Direction.ASC,"creationDate");
		
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findByPositionActiveTrue(sort),"Aktif pozisyonlar listelendi");
	}


	@Override
	public DataResult<List<JobPosition>> getActiveJobPositionsByCompanyName(String companyName) {
		if(Validation.stringsIsNullOrEmpty(companyName)) {
			return new ErrorDataResult<List<JobPosition>>("Lütfen bir firma giriniz");
		}
		else {
			return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findByPositionActiveTrueAndEmployer_CompanyName(companyName), "Firmanın aktif iş ilanları listelendi");
		}
	}


	@Override
	public Result updateJobPositionStatus(int positionId, boolean isActive) {
		
		var result = jobPositionDao.setJobPositionActiveByPositionId(positionId, isActive);
		if(result <= 0) {
			return new ErrorDataResult<List<JobPosition>>("İş ilanı durumu güncellenirken hata meydana geldi");
		}
		
		return new SuccessResult("İş ilanı durumu başarıyla güncellendi");
	}


	@Override
	public DataResult<List<JobPosition>> getActivePositionsByEmployerId(int employerId) {
		return new SuccessDataResult<>(jobPositionDao.findByEmployer_EmployerIdAndPositionActiveTrue(employerId), "Data listelendi");
	}


	@Override
	public DataResult<List<JobPosition>> getAllPositionsByEmployerId(int employerId) {
		return new SuccessDataResult<>(jobPositionDao.findByEmployer_EmployerId(employerId), "Data listelendi");
	}

}
