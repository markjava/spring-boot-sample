package com.boot.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.sample.entity.SecretUser;
import com.boot.sample.mapper.SecretUserMapper;

@Service
public class SecretUserService {
	
	@Autowired
	SecretUserMapper secretUserMapper;
	
	public List<SecretUser> findAll() {
		return secretUserMapper.select();
	}
	
	public void save(SecretUser secretUser) {
		secretUserMapper.save(secretUser);
	}
	
	public void updateByUserCode(String userCode, String userName) {
		secretUserMapper.updateByUserCode(userName, userCode);
	}

}
