package tolgahankilic.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tolgahankilic.hrms.core.entities.concretes.User;

@Data
@Entity
@Table(name = "job_seekers", uniqueConstraints = {@UniqueConstraint(columnNames = {"nationality_id"})})
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitaes"})
@EqualsAndHashCode(callSuper = false)
public class JobSeeker extends User {

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;

	@Column(name = "nationality_id", nullable = false)
	private String nationalityId;
	
	@JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<CurriculumVitae> curriculumVitaes;

//	public JobSeeker(int id, String email, String password, boolean status, String firstName, String lastName,
//			String nationalityId, LocalDate birthDate) {
//		super(id, email, password, status);
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.nationalityId = nationalityId;
//		this.birthDate = birthDate;
//	}

}
