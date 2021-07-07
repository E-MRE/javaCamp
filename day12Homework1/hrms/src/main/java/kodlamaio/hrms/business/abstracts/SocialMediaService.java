package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {

	Result add(SocialMedia socialMedia);
	
	Result addAll(List<SocialMedia> socialMedias);
}
