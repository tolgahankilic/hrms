package tolgahankilic.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tolgahankilic.hrms.business.abstracts.SystemUserService;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.SystemUser;

@RestController
@RequestMapping("/api/system_users")
public class SystemUsersController {

	private SystemUserService systemUserService;

	@Autowired
	public SystemUsersController(SystemUserService systemUserService) {
		this.systemUserService = systemUserService;
	}

	@GetMapping("/getall")
	public DataResult<List<SystemUser>> getAll() {
		return this.systemUserService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody SystemUser systemUser) {
		return this.systemUserService.add(systemUser);
	}
}
