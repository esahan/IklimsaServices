package com.iklimsa.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ItemInfoProductCatalogs {
	
	
	@XmlElement(name = "Id")
	private String Id;
	
	@XmlElement(name = "Value")
	private String Value;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	
	
	

}
