package com.iklimsa.services;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CategoryStructureResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2887407777466352876L;

	@XmlElement(name = "ResponseCode" )
	private String ResponseCode;
	
	@XmlElement(name = "Message" )
	private String Message;
	
	@XmlElement(name = "CategoryStructureList" )
	private List<CategoryStructureEntity> CategoryList;

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

	public List<CategoryStructureEntity> getCategoryList() {
		return CategoryList;
	}

	public void setCategoryList(List<CategoryStructureEntity> categoryList) {
		CategoryList = categoryList;
	}
	
	
}
