package com.iklimsa.services;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class UserInfoReturn implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3661455083555167606L;

	@XmlElement(name = "ResponseCode" )
	private String ResponseCode;
	
	@XmlElement(name = "Message" )
	private String Message;
	
	@XmlElement(name = "UserList" )
	private List<UserInfoEntity> userList;

	public String getResponseCode() {
		return ResponseCode;
	}

	public void setResponseCode(String responseCode) {
		ResponseCode = responseCode;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public List<UserInfoEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UserInfoEntity> userList) {
		this.userList = userList;
	}
	
	
	
	

}
