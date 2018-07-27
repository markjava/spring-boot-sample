package com.boot.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.boot.sample.entity.SecretUser;


public interface SecretUserMapper {

	public List<SecretUser> select();
	
	public void save(SecretUser secretUser);
	
	public void updateByUserCode(@Param("userName") String userName,  @Param("userCode") String userCode);
}
