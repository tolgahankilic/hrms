package tolgahankilic.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerForRegisterDto {
	private String firstName;
	
	private String lastName;
	
	private String nationalityId;
	
	private LocalDate birthDate;
	
	private String email;
	
	private String password;
	
	private String rePassword;
	
	//private boolean status;
}
