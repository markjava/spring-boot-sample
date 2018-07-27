package com.boot.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.sample.entity.SecretUser;
import com.boot.sample.service.SecretUserService;

@RestController
@RequestMapping("/secretUser")
public class SecretUserController {
	
	@Autowired
	SecretUserService secretUserService;
	
	@GetMapping("/findAll")
	public List<SecretUser> findAll() {
		return secretUserService.findAll();
	}
	
	@PostMapping("/save")
	public String save(@RequestBody SecretUser secretUser) {
		secretUserService.save(secretUser);
		return "success";
	}
	
	@PutMapping("/update")
	public String updateByUserCode(@RequestParam(name="userCode") String userCode, 
			@RequestParam(name="userName") String userName) {
		secretUserService.updateByUserCode(userCode, userName);
		return "success";
	}

}
