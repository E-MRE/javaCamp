package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Data
@Table(name="photos")
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="photo_id")
	private int photoId;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	@Column(name="photo_link")
	@NotBlank
	@NotNull
	private String photoLink;
	
	@Column(name="uploaded_date")
	private String uploadedDate;
}
