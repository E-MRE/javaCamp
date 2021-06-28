package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	List<JobPosition> findByPositionActiveTrue();
	
	List<JobPosition> findByPositionActiveTrue(Sort sort);
	
	List<JobPosition> findByPositionActiveTrueAndCreationDate(LocalDateTime creationDate);
	
	List<JobPosition> findByPositionActiveTrueAndEmployer_CompanyName(String companyName);
	
	@Transactional
	@Modifying
	@Query("update JobPosition j set j.positionActive = ?2 where j.positionId = ?1")
	int setJobPositionActiveByPositionId(int positionId, boolean positionActive);
}
