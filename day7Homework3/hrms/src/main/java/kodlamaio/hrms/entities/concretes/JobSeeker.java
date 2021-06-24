package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="user_id")
@EqualsAndHashCode(callSuper = false)
@Table(name="job_seekers")
public class JobSeeker extends User {
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@Column(name="birth_date")
	private String birthDate;
}
