package com.iklimsa.services;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="CreateOrderResp")
public class CreateOrderRespObj implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "OrderId" )
	private String OrderId;
	
	@XmlElement(name = "PaymentLink" )
	private String PaymentLink;

	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	public String getPaymentLink() {
		return PaymentLink;
	}

	public void setPaymentLink(String paymentLink) {
		PaymentLink = paymentLink;
	}
	
	


}
