package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_positions")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_position_id")
	private int positionId;
	
	@Column(name="position_name")	
	private String positionName;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="active_position_quantity")
	private int activePositionQuantity;
	
	@Column(name="application_deadline")
	private String applicationDeadline;
	
	@Column(name="creation_date")
	private LocalDateTime creationDate;

	@Column(name="position_active")
	private boolean positionActive;

	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="job_id")
	private Job job;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
}
