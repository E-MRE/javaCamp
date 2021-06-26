package kodlamaio.hrms.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	
	Employer getByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("update Employer e set e.isEmployerVerified = ?2 where e.email = ?1")
	int setVerifyEmployerByEmail(String email, boolean isVerified);
}
