package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeDto;

public interface ResumeService {

	Result add(ResumeDto resumeDto);
	DataResult<ResumeDto> getResumesById(int resumeId);
}
