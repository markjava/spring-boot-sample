package com.boot.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.sample.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService messageService;

	/**
	 * 信息加密
	 * 
	 * @param mid
	 * @param data
	 * @param idnex
	 * @param sign
	 * @return
	 */
	@GetMapping("/encrypt")
	public String encrypt(@RequestParam(name="mid", required = true) String mid,
			@RequestParam(name="data", required=true) String data,
			@RequestParam(name="index", required=false, defaultValue = "-1") Integer idnex, 
			@RequestParam(name="sign", required=false) String sign) {
		
		return null;
	}
	
}