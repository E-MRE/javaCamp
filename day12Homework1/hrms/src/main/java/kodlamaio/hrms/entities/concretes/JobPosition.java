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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name="job_positions")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_position_id")
	private int positionId;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name="job_id")
	private Job job;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name="work_type_id")
	private WorkType workType;

	@NotNull
	@ManyToOne()
	@JoinColumn(name="work_time_id")
	private WorkTime workTime;
	
	@Column(name="position_name")
	@NotBlank
	@Size(max=50, min = 3)
	private String positionName;
	
	@PositiveOrZero
	@Column(name="min_salary")
	private double minSalary;
	
	@PositiveOrZero
	@Column(name="max_salary")
	private double maxSalary;
	
	@Positive
	@Column(name="active_position_quantity")
	private int activePositionQuantity;
	
	@Future
	@Column(name="application_deadline")
	private LocalDateTime applicationDeadline;
	
	@Column(name="creation_date")
	private LocalDateTime creationDate = LocalDateTime.now();

	@Column(name="position_active")
	private boolean positionActive = false;
	
	@NotBlank
	@Size(max=50, min = 3)
	@Column(name="description")
	private String description;
}
