package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ProgrammingSkill;

public interface ProgramminSkillDao extends JpaRepository<ProgrammingSkill, Integer> {

}
