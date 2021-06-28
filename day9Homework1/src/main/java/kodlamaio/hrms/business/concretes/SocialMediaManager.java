package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediaDao;
import kodlamaio.hrms.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService {

	private SocialMediaDao socialMediaDao;
	
	@Autowired
	public SocialMediaManager(SocialMediaDao socialMediaDao) {
		this.socialMediaDao = socialMediaDao;
	}


	@Override
	public Result add(SocialMedia socialMedia) {
		socialMediaDao.save(socialMedia);
		return new SuccessResult("Sosyal medya hesabı eklendi");
	}


	@Override
	public Result addAll(List<SocialMedia> socialMedias) {
		socialMediaDao.saveAll(socialMedias);
		return new SuccessResult("Sosyal medya hesapları eklendi");
	}

}
