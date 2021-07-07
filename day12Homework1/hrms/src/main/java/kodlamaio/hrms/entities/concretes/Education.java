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

@Entity
@Data
@Table(name="educations")
@AllArgsConstructor
@NoArgsConstructor
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="education_id")
	private int educationId;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	@Column(name="education_type")
	private String educationType;
	
	@Column(name="school_name")
	@NotBlank
	@NotNull
	private String schoolName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="start_date")
	@NotBlank
	@NotNull
	private String startDate;
	
	@Column(name="finish_date")
	private String finishDate;
}
