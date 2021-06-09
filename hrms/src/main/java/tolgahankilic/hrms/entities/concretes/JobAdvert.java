package tolgahankilic.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_adverts")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "min_salary")
	private double minSalary;
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	@Column(name = "number_of_hires", nullable = false)
	@NotNull
	private int numberOfHires;
	
	@Column(name = "created_date")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name = "status")
	private boolean status;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "city_id", nullable = false)
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "job_position_id", nullable = false)
	private JobPosition jobPosition;
}
