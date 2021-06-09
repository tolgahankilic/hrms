package tolgahankilic.hrms.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tolgahankilic.hrms.business.abstracts.CurriculumVitaeService;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/cvs")
public class CurriculumVitaesController {

	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		this.curriculumVitaeService = curriculumVitaeService;
	}

	@GetMapping("/getByJobSeekerId")
	public DataResult<CurriculumVitae> getByJobSeekerId(int jobSeekerId) {
		return this.curriculumVitaeService.getByJobSeekerId(jobSeekerId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitae curriculumVitae) {
		return this.curriculumVitaeService.add(curriculumVitae);
	}

	@PostMapping("/uploadPicture")
	public Result uploadPicture(int cvId, MultipartFile file) throws IOException {
		return this.curriculumVitaeService.uploadPicture(cvId, file);
	}

}
