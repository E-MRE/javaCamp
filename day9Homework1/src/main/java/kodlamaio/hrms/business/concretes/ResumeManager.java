package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.PhotoService;
import kodlamaio.hrms.business.abstracts.ProgrammingSkillService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private JobSeekerService jobSeekerService;
	private JobSeekerLanguageService languageService;
	private EducationService educationService;
	private ExperienceService experienceService;
	private ProgrammingSkillService skillService;
	private CoverLetterService coverLetterService;
	private SocialMediaService socialMediaService;
	private PhotoService photoService;

	@Autowired
	public ResumeManager(ResumeDao resumeDao, JobSeekerService jobSeekerService, JobSeekerLanguageService languageService
			, EducationService educationService, ExperienceService experienceService, ProgrammingSkillService skillService
			, CoverLetterService coverLetterService, SocialMediaService socialMediaService, PhotoService photoService) {
		this.resumeDao = resumeDao;
		this.jobSeekerService = jobSeekerService;
		this.languageService = languageService;
		this.educationService = educationService;
		this.experienceService = experienceService;
		this.skillService = skillService;
		this.coverLetterService = coverLetterService;
		this.socialMediaService = socialMediaService;
		this.photoService = photoService;
	}

	@Override
	public Result add(ResumeDto resumeDto) {
		
		if(resumeDao.existsByResumeIdAndJobSeeker_JobSeekerId(resumeDto.getResumeId(), resumeDto.getJobSeekerId())) {
			return new ErrorResult("Bu özgeçmiş ismi kullanımda. Aynı isimden birden fazla olamaz");
		}
		
		resumeDto.setCreationDate(LocalDateTime.now());
		resumeDao.save(getResumeByDto(resumeDto));
		
		resumeDto.getLanguages().forEach(language -> language.setResume(resumeDao.findByResumeNameAndJobSeeker_JobSeekerId(resumeDto.getResumeName(), resumeDto.getJobSeekerId())));
		languageService.addAll(resumeDto.getLanguages());
		
		resumeDto.getEducations().forEach(education -> education.setResume(resumeDao.findByResumeNameAndJobSeeker_JobSeekerId(resumeDto.getResumeName(), resumeDto.getJobSeekerId())));
		educationService.addAll(resumeDto.getEducations());

		resumeDto.getExperiences().forEach(experience -> experience.setResume(resumeDao.findByResumeNameAndJobSeeker_JobSeekerId(resumeDto.getResumeName(), resumeDto.getJobSeekerId())));
		experienceService.addAll(resumeDto.getExperiences());
		
		resumeDto.getSkills().forEach(skill -> skill.setResume(resumeDao.findByResumeNameAndJobSeeker_JobSeekerId(resumeDto.getResumeName(), resumeDto.getJobSeekerId())));
		skillService.addAll(resumeDto.getSkills());

		resumeDto.getCoverLetters().forEach(coverLetter -> coverLetter.setResume(resumeDao.findByResumeNameAndJobSeeker_JobSeekerId(resumeDto.getResumeName(), resumeDto.getJobSeekerId())));
		coverLetterService.addAll(resumeDto.getCoverLetters());
		
		resumeDto.getSocialMedias().forEach(socialMedia -> socialMedia.setResume(resumeDao.findByResumeNameAndJobSeeker_JobSeekerId(resumeDto.getResumeName(), resumeDto.getJobSeekerId())));
		socialMediaService.addAll(resumeDto.getSocialMedias());
		
		resumeDto.getPhotos().forEach(photo -> photo.setResume(resumeDao.findByResumeNameAndJobSeeker_JobSeekerId(resumeDto.getResumeName(), resumeDto.getJobSeekerId())));
		photoService.addAll(resumeDto.getPhotos());
		
		return new SuccessResult("Özgeçmiş eklendi");
	}

	@Override
	public DataResult<ResumeDto> getResumesById(int resumeId) {
		return new SuccessDataResult<ResumeDto>(getResumeDtoById(resumeId), "Özgeçmiş getirildi");
	}
	
	private Resume getResumeByDto(ResumeDto resumeDto) {
		
		var jobSeeker = jobSeekerService.getJobSeekerById(resumeDto.getJobSeekerId());
		
		return new Resume(resumeDto.getResumeId(), jobSeeker.getData(), resumeDto.getCreationDate(), resumeDto.getUpdatedDate(), true, resumeDto.getResumeName(),
				resumeDto.getLanguages(), resumeDto.getEducations(), resumeDto.getExperiences(), resumeDto.getSkills(), resumeDto.getCoverLetters(), resumeDto.getSocialMedias(), resumeDto.getPhotos());
	}
	
	private ResumeDto getResumeDtoById(int resumeId) {
		var resume = resumeDao.findByResumeId(resumeId);
		
		return new ResumeDto(resume.getResumeId(), resume.getJobSeeker().getJobSeekerId(), resume.getResumeName(), resume.getCreationDate(), resume.getUpdatedDate(),
				resume.getEducations(), resume.getLanguages(), resume.getExperiences(), resume.getSkills(), resume.getSocialMedias(), resume.getPhotos(), resume.getCoverLetters());
	}
}
