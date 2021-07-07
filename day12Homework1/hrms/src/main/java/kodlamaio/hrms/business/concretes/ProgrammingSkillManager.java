package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ProgrammingSkillService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgramminSkillDao;
import kodlamaio.hrms.entities.concretes.ProgrammingSkill;

@Service
public class ProgrammingSkillManager implements ProgrammingSkillService {
	
	private ProgramminSkillDao skillDao;

	@Autowired
	public ProgrammingSkillManager(ProgramminSkillDao skillDao) {
		this.skillDao = skillDao;
	}

	@Override
	public Result add(ProgrammingSkill skill) {
		
		if(skill.getLevel() < 1 || skill.getLevel() > 5) {
			return new ErrorResult("Aralık dışı");
		}
		
		skillDao.save(skill);
		return new SuccessResult("Yetenek eklendi");
	}

	@Override
	public Result addAll(List<ProgrammingSkill> skills) {
		skillDao.saveAll(skills);
		return new SuccessResult("Yetenekler eklendi");
	}
	

}
