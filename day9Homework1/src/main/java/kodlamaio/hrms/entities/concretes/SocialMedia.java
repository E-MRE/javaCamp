package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="social_medias")
@NoArgsConstructor
@AllArgsConstructor
public class SocialMedia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="social_media_id")
	private int socialMediaId;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	@Column(name="github")
	private String github;
	
	@Column(name="linkedin")
	private String linkedin;
}
