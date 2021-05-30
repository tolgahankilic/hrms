package tolgahankilic.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tolgahankilic.hrms.business.abstracts.UserService;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/getall")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}
}
