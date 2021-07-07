package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer> {

}
