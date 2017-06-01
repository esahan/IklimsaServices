package com.iklimsa.services;



import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ShoppingChartResp")
public class ShoppingChartRespObj {
	
	
	@XmlElement(name = "RegularPrice"  )
	private double RegularPrice;
	
	@XmlElement(name = "DiscountedPrice"  )
	private double DiscountedPrice;
	
	@XmlElement(name = "Currency"  )
	private String Currency;
	
	@XmlElement(name="OfferValidDate")
	private Date OfferValidDate;

	

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public Date getOfferValidDate() {
		return OfferValidDate;
	}

	public void setOfferValidDate(Date offerValidDate) {
		OfferValidDate = offerValidDate;
	}

	public double getRegularPrice() {
		return RegularPrice;
	}

	public void setRegularPrice(double regularPrice) {
		RegularPrice = regularPrice;
	}

	public double getDiscountedPrice() {
		return DiscountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		DiscountedPrice = discountedPrice;
	}

	

}
