package com.boot.sample.entity;

/**
 * 使用方实体
 * 
 * @author xu.yong
 *
 */
public class SecretUser extends BaseEntity {

	private Integer id;

	private String userCode;

	private String userName;

	private String userType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
