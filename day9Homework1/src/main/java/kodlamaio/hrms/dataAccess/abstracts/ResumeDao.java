package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {

	Resume findByResumeId(int resumeId);
	
	Resume findByResumeNameAndJobSeeker_JobSeekerId(String resumeName, int jobSeekerId);
	
	boolean existsByResumeIdAndJobSeeker_JobSeekerId(int resumeId, int jobSeekerId);
}
