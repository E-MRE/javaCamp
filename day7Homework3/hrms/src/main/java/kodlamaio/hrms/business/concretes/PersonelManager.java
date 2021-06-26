package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PersonelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonelDao;
import kodlamaio.hrms.entities.concretes.Personel;

@Service
public class PersonelManager implements PersonelService {

	private PersonelDao personelDao;
	private EmployerDao employerDao;
	
	@Autowired
	public PersonelManager(PersonelDao personelDao, EmployerDao employerDao) {
		this.personelDao = personelDao;
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Personel>> getAll() {
		return new SuccessDataResult<List<Personel>>(personelDao.findAll(), "Data listelendi");
	}

	@Override
	public Result veriftEmployer(String email) {
		
		if(email == "" || email == null) {
			return new ErrorResult("Hatalı e-posta girdiniz");
		}
		
		var employer = employerDao.getByEmail(email);
		
		if(employer == null) {
			return new ErrorResult("Girilin e-posta ile eşleyen kayıt bulunamadı");
		}
		else if(employer.isEmployerVerified()) {
			return new ErrorResult("Kayıt zaten onaylı!");
		}
		else {
			var response = employerDao.setVerifyEmployerByEmail(email, true);
			if(response <= 0) {
				return new ErrorResult("İşlem sırasında bir hata meydana geldi");
			}
		}
		
		return new SuccessResult(employer.getCompanyName() + " çalışanı onaylandı");
	}

}
