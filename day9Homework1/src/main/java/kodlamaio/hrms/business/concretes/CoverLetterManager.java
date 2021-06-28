package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService {

	private CoverLetterDao letterDao;

	@Autowired
	public CoverLetterManager(CoverLetterDao letterDao) {
		this.letterDao = letterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		letterDao.save(coverLetter);
		return new SuccessResult("Ön yazı eklendi");
	}

	@Override
	public Result addAll(List<CoverLetter> coverLetters) {
		letterDao.saveAll(coverLetters);
		return new SuccessResult("Ön yazılar eklendi");
	}
	
}
