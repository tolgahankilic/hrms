package tolgahankilic.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tolgahankilic.hrms.business.abstracts.JobPositionService;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll() {
		return this.jobPositionService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosition position) {
		return this.jobPositionService.add(position);
	}

	@GetMapping("/getByPositionName")
	public DataResult<JobPosition> getByJobName(@RequestParam String positionName) {
		return this.jobPositionService.getByPositionName(positionName);
	}
}
