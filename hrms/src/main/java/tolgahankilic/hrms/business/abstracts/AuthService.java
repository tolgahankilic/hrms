package tolgahankilic.hrms.business.abstracts;

import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.dtos.EmployerForRegisterDto;
import tolgahankilic.hrms.entities.dtos.JobSeekerForRegisterDto;

public interface AuthService {
	Result employerRegister(EmployerForRegisterDto employer);

	Result jobSeekerRegister(JobSeekerForRegisterDto jobSeeker);
}
