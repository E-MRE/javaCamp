package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {

	Result add(CoverLetter coverLetter);
	
	Result addAll(List<CoverLetter> coverLetters);
}
