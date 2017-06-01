package com.iklimsa.services;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="CreateUpdateOfferResp")
public class CreateUpdateOfferRespObj {
	
	@XmlElement(name = "OfferId"  )
	private  String   OfferId;	
	
	@XmlElement(name = "RegularPrice"  )
	private double RegularPrice;
	
	@XmlElement(name = "DiscountedPrice"  )
	private double DiscountedPrice;
	
	@XmlElement(name = "OfferValidDate"  )
	private Date OfferValidDate;

	public String getOfferId() {
		return OfferId;
	}

	public void setOfferId(String offerId) {
		OfferId = offerId;
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

	public Date getOfferValidDate() {
		return OfferValidDate;
	}

	public void setOfferValidDate(Date offerValidDate) {
		OfferValidDate = offerValidDate;
	}
	
	
	

	
	
}
