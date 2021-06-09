package tolgahankilic.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tolgahankilic.hrms.business.abstracts.JobSeekerLanguageService;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.JobSeekerLanguage;

@RestController
@RequestMapping("/api/jobseekerLanguages")
public class JobSeekerLanguagesController {

	private JobSeekerLanguageService jobSeekerLanguageService;

	@Autowired
	public JobSeekerLanguagesController(JobSeekerLanguageService jobSeekerLanguageService) {
		this.jobSeekerLanguageService = jobSeekerLanguageService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerLanguage jobSeekerLanguage) {
		return this.jobSeekerLanguageService.add(jobSeekerLanguage);
	}

}
