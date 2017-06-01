package com.iklimsa.services;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ItemInfoResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5358658620384895173L;

	@XmlElement(name = "ResponseCode" )
	private String ResponseCode;
	
	@XmlElement(name = "Message" )
	private String Message;
	
	@XmlElement(name = "ItemInfoEntity" )
	private List<ItemInfoEntity> ItemInfoEntityList;

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

	public List<ItemInfoEntity> getItemInfoEntityList() {
		return ItemInfoEntityList;
	}

	public void setItemInfoEntityList(List<ItemInfoEntity> itemInfoEntityList) {
		ItemInfoEntityList = itemInfoEntityList;
	}
	
	
	
	

}
