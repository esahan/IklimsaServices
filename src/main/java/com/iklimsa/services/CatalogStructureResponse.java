package com.iklimsa.services;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CatalogStructureResponse  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "ResponseCode" )
	private String ResponseCode;
	
	@XmlElement(name = "Message" )
	private String Message;
	
	@XmlElement(name = "CatalogStructureEntity" )
	private List<CatalogStructureEntity> CatalogList;

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

	public List<CatalogStructureEntity> getCatalogList() {
		return CatalogList;
	}

	public void setCatalogList(List<CatalogStructureEntity> catalogList) {
		CatalogList = catalogList;
	}
	
	

}
