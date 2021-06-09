package tolgahankilic.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tolgahankilic.hrms.business.abstracts.SchoolDepartmentService;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.SchoolDepartment;

@RestController
@RequestMapping("/api/schooldepartments")
public class SchoolDepartmentsController {

	private SchoolDepartmentService schoolDepartmentService;

	@Autowired
	public SchoolDepartmentsController(SchoolDepartmentService schoolDepartmentService) {
		this.schoolDepartmentService = schoolDepartmentService;
	}

	@GetMapping("/getall")
	public DataResult<List<SchoolDepartment>> getAll() {
		return this.schoolDepartmentService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody SchoolDepartment schoolDepartment) {
		return this.schoolDepartmentService.add(schoolDepartment);
	}

}
