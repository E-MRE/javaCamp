package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.core.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService {

	private PhotoDao photoDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao, CloudinaryService cloudinaryService) {
		this.photoDao = photoDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(Photo photo) {
		
		var result = cloudinaryService.upload(photo.getPhotoLink());
		if(!result.isSuccess()) {
			return result;
		}
		
		photo.setPhotoLink(result.getData().get("url"));
		photo.setUploadedDate(result.getData().get("created_at"));
		photoDao.save(photo);
		return new SuccessResult("Resim eklendi");
	}

	@Override
	public DataResult<Photo> getJobSeekerPhotoById(int jobSeekerId) {
		return new SuccessDataResult<Photo>(photoDao.findByJobSeeker_JobSeekerId(jobSeekerId), "Aday resmi getirildi");
	}

	@Override
	public DataResult<Photo> getPhotoById(int photoId) {
		return new SuccessDataResult<Photo>(photoDao.findByPhotoId(photoId), "Resim getirildi");
	}

	@Override
	public Result addAll(List<Photo> photos) {
		photoDao.saveAll(photos);
		return new SuccessResult("Resimler eklendi");
	}

}
