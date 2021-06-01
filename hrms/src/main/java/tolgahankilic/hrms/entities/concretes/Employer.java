package tolgahankilic.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tolgahankilic.hrms.core.entities.concretes.User;

@Data
@Entity
@Table(name = "employers")
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdverts" })
public class Employer extends User {
	@Column(name = "company_name", nullable = false)
	private String companyName;

	@Column(name = "website", nullable = false)
	private String website;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;

	public Employer(int id, String email, String password, boolean status, String companyName, String website,
			String phoneNumber) {
		super(id, email, password, status);
		this.companyName = companyName;
		this.website = website;
		this.phoneNumber = phoneNumber;
	}
}
