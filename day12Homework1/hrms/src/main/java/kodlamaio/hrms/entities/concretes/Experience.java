package kodlamaio.hrms.entities.concretes;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "experiences")
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="experience_id")
	private int experienceId;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	@Column(name ="job_title")
	@NotBlank
	@NotNull
	private String jobTitle;
	
	@Column(name ="workplace_name")
	@NotBlank
	@NotNull
	private String workplaceName;
	
	@Column(name ="start_date")
	@NotBlank
	@NotNull
	private String startDate;
	
	@Column(name ="finish_date")
	private String finishDate;
	
	@ManyToOne()
	@JoinColumn(name="job_id")
	private Job job;
}
