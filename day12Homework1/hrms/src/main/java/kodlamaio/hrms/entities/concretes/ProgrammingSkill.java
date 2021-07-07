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
@Table(name="programming_skills")
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="programming_skill_id")
	private int programmingSkillId;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;

	@Column(name="skill_name")
	@NotBlank
	@NotNull
	private String skillName;
	
	@Column(name="level")
	private int level;
}
