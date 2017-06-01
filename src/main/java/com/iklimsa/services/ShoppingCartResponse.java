package com.iklimsa.services;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ShoppingCartResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8244659733426373606L;
	
	@XmlElement(name = "ResponseCode" )
	private String ResponseCode;
	
	@XmlElement(name = "Message" )
	private String Message;	
	
	@XmlElement(name = "Output" )
	private ShoppingChartRespObj Output;

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

	public ShoppingChartRespObj getOutput() {
		return Output;
	}

	public void setOutput(ShoppingChartRespObj output) {
		Output = output;
	}
	
	

}
