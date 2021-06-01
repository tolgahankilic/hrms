package tolgahankilic.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tolgahankilic.hrms.core.entities.concretes.User;

@Data
@Entity
@Table(name = "system_users")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class SystemUser extends User {
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "nationality_id", nullable = false)
	private String nationalityId;

	public SystemUser(int id, String email, String password, boolean status, String firstName, String lastName,
			String nationalityId) {
		super(id, email, password, status);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
	}
}
