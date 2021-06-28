package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer>{

	Photo findByJobSeeker_JobSeekerId(int jobSeekerId);
	
	Photo findByPhotoId(int photoId);
}
