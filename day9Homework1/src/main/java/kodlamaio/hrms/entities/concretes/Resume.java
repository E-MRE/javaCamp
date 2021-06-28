package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resumes")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_id")
	private int resumeId;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
	
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	
	@Column(name = "is_active")
	private boolean isActive = true;
	
	@Column(name="resume_name")
	private String resumeName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<JobSeekerLanguage> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Education> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Experience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<ProgrammingSkill> skills;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<CoverLetter> coverLetters;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<SocialMedia> socialMedias;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Photo> photos;
}
