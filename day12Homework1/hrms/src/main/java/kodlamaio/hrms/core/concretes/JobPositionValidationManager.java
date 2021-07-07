package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.JobPositionValidationService;
import kodlamaio.hrms.core.utilities.Validation;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionValidationManager implements JobPositionValidationService {

	@Override
	public Result jobPositionIsValid(JobPosition jobPosition) {
		boolean checkNullOrEmpty = Validation.stringsIsNullOrEmpty(jobPosition.getPositionName());
		if(checkNullOrEmpty) {
			return new ErrorResult("Tüm alanlar doldurulmalıdır!");
		}
		else if(jobPosition.getCity().getCityId() <= 0) {
			return new ErrorResult("Lütfen şehir seçiniz");
		}
		else if(jobPosition.getEmployer().getEmployerId() <= 0) {
			return new ErrorResult("İş veren bulunamadı");
		}
		else if(jobPosition.getJob().getJobId() <= 0) {
			return new ErrorResult("Lütfen iş tanımı giriniz");
		}
		else if(jobPosition.getActivePositionQuantity() <= 0) {
			return new ErrorResult("Lütfen açık pozisyon adedi giriniz");
		}
		
		return new SuccessResult("İş ilanı eklenebilir");
	}

}
