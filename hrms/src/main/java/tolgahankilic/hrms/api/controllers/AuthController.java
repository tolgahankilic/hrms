package tolgahankilic.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tolgahankilic.hrms.business.abstracts.AuthService;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.dtos.EmployerForRegisterDto;
import tolgahankilic.hrms.entities.dtos.JobSeekerForRegisterDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/employerRegister")
	public Result registerForEmployer(@RequestBody EmployerForRegisterDto employer) {
		return authService.employerRegister(employer);
	}

	@PostMapping("/jobSeekerRegister")
	public Result registerForJobSeeker(@RequestBody JobSeekerForRegisterDto jobSeeker) {
		return authService.jobSeekerRegister(jobSeeker);
	}
}
