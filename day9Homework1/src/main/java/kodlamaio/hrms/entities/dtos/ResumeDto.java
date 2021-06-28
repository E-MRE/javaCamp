package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;
import kodlamaio.hrms.entities.concretes.Photo;
import kodlamaio.hrms.entities.concretes.ProgrammingSkill;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {

	private int resumeId;
	
	private int jobSeekerId;
	
	private String resumeName;
	
	@JsonIgnore
	private LocalDateTime creationDate;
	
	@JsonIgnore
	private LocalDateTime updatedDate;
	
	private List<Education> educations;
	
	private List<JobSeekerLanguage> languages;
	
	private List<Experience> experiences;
	
	private List<ProgrammingSkill> skills;
	
	private List<SocialMedia> socialMedias;
	
	private List<Photo> photos;
	
	private List<CoverLetter> coverLetters;
}
