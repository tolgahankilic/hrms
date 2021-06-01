package tolgahankilic.hrms.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.business.abstracts.AuthService;
import tolgahankilic.hrms.business.abstracts.EmployerService;
import tolgahankilic.hrms.business.abstracts.JobSeekerService;
import tolgahankilic.hrms.business.abstracts.SystemUserService;
import tolgahankilic.hrms.business.abstracts.UserService;
import tolgahankilic.hrms.core.utilities.adapters.EmailService;
import tolgahankilic.hrms.core.utilities.adapters.MernisService;
import tolgahankilic.hrms.core.utilities.business.BusinessRules;
import tolgahankilic.hrms.core.utilities.results.ErrorResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.utilities.results.SuccessResult;
import tolgahankilic.hrms.entities.concretes.Employer;
import tolgahankilic.hrms.entities.concretes.JobSeeker;
import tolgahankilic.hrms.entities.dtos.EmployerForRegisterDto;
import tolgahankilic.hrms.entities.dtos.JobSeekerForRegisterDto;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private JobSeekerService jobSeekerService;
	private EmailService emailService;
	private EmployerService employerService;
	private MernisService mernisService;
	private ModelMapper modelMapper;
	private SystemUserService systemUserService;

	@Autowired
	public AuthManager(UserService userService, JobSeekerService jobSeekerService, EmailService emailService,
			EmployerService employerService, MernisService mernisService, ModelMapper modelMapper,
			SystemUserService systemUserService) {
		super();
		this.userService = userService;
		this.jobSeekerService = jobSeekerService;
		this.emailService = emailService;
		this.employerService = employerService;
		this.mernisService = mernisService;
		this.modelMapper = modelMapper;
		this.systemUserService = systemUserService;

	}

	@Override
	public Result employerRegister(EmployerForRegisterDto employer) {
		var result = BusinessRules.run(checkEmployerRegisterForm(employer), checkDomain(employer),
				checkEmailVerification(employer.getEmail()), checkHrmsConfirm(),
				checkIfEmailExists(employer.getEmail()),
				checkPasswordSame(employer.getPassword(), employer.getRePassword()));
		if (result != null) {
			return result;
		}

		Employer createEmployer = modelMapper.map(employer, Employer.class);
		this.employerService.add(createEmployer);
		return new SuccessResult("Your registration is completed.");
	}

	@Override
	public Result jobSeekerRegister(JobSeekerForRegisterDto jobSeeker) {
		Result result = BusinessRules.run(checkJobSeekerRegisterForm(jobSeeker), checkMernis(jobSeeker),
				checkIfEmailExists(jobSeeker.getEmail()), checkNationalityId(jobSeeker.getNationalityId()),
				checkPasswordSame(jobSeeker.getPassword(), jobSeeker.getRePassword()),
				checkEmailVerification(jobSeeker.getEmail()));

		if (result != null) {
			return result;
		}

		JobSeeker creteJobSeeker = modelMapper.map(jobSeeker, JobSeeker.class);
		this.jobSeekerService.add(creteJobSeeker);
		return new SuccessResult("Your registration is completed.");
	}

	private Result checkIfEmailExists(String email) {

		Result result = this.userService.getByEmail(email);

		if (result.getMessage() != null) {
			return new ErrorResult("e-mail already registered");
		}
		return new SuccessResult();
	}

	private Result checkEmailVerification(String email) {
		if (!this.emailService.validate(email).isSuccess()) {
			return new ErrorResult("Email could not be verified");
		}
		return new SuccessResult();
	}

	private Result checkPasswordSame(String password, String rePassword) {

		if (!password.equals(rePassword)) {
			return new ErrorResult("Passwords are not the same");
		}

		return new SuccessResult();
	}

	//For jobSeekers

	private Result checkJobSeekerRegisterForm(JobSeekerForRegisterDto jobSeeker) {
		if (jobSeeker.getFirstName().isBlank() == true || jobSeeker.getLastName().isBlank() == true
				|| jobSeeker.getNationalityId().isBlank() == true || jobSeeker.getEmail().isBlank() == true
				|| jobSeeker.getPassword().isBlank() == true || jobSeeker.getRePassword().isBlank() == true) {
			return new ErrorResult("Please fill out the form, there is missing information.");
		}
		return new SuccessResult();
	}

	private Result checkMernis(JobSeekerForRegisterDto jobSeeker) {

		if (!mernisService.validate(jobSeeker.getNationalityId(), jobSeeker.getBirthDate().getYear()).isSuccess()) {
			return new ErrorResult("Identity not verified.");
		}
		return new SuccessResult();
	}

	private Result checkNationalityId(String nationalityId) {

		Result result = this.jobSeekerService.getByNationalityId(nationalityId);

		if (result.getMessage() != null) {
			return new ErrorResult("User already registered.");
		}
		return new SuccessResult();
	}

	//For Employer

	private Result checkDomain(EmployerForRegisterDto employerForRegisterDto) {

		String domain = employerForRegisterDto.getEmail().split("@")[0];

		if (domain.equals(employerForRegisterDto.getWebsite())) {
			return new SuccessResult();
		}

		return new ErrorResult("Company Email mismatch.");
	}

	private Result checkHrmsConfirm() {
		if (this.systemUserService.confirm() == null) {
			return new ErrorResult("Your registration has not been approved by our institution.");
		}
		return new SuccessResult();
	}

	private Result checkEmployerRegisterForm(EmployerForRegisterDto employer) {
		if (employer.getCompanyName().isBlank() == true || employer.getWebsite().isBlank() == true
				|| employer.getPhoneNumber().isBlank() == true || employer.getEmail().isBlank() == true
				|| employer.getPassword().isBlank() == true || employer.getRePassword().isBlank() == true) {
			return new ErrorResult("Please fill out the form, there is missing information.");
		}
		return new SuccessResult();
	}

}