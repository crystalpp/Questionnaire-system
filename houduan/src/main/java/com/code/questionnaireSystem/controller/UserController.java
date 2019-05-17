package com.code.questionnaireSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.code.questionnaireSystem.pojo.User;
import com.code.questionnaireSystem.service.UserService;
import com.code.questionnaireSystem.utils.Result;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public Result login(@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "password", required = false) String password) {

		return userService.login(userName, password);
	}

	@PostMapping("/addUser")
	@ResponseBody
	public Result addUser(String userName, String userPassword, String userPhone, String userEmail) {
		return userService.addUser(userName, userPassword, userPhone, userEmail);
	}

	@GetMapping("/valiate")
	public Result validate(String type, String value) {
		return userService.valiate(type, value);
	}

	@PostMapping("/update")
	public Result update(User user) {
		return userService.update(user);
	}
}
