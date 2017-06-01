package com.iklimsa.services;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CreateUpdateOfferEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "OfferId" ,required = false)
	private String OfferId;
	
	@XmlElement(name = "DealerCode" ,required = true, nillable = false)
	private String DealerCode;
	
	@XmlElement(name = "CompanyName" ,required = true, nillable = false)
	private String CompanyName;
	
	@XmlElement(name = "Name" ,required = true, nillable = false)
	private String Name;
	
	@XmlElement(name = "Surname" ,required = true, nillable = false)
	private String Surname;
	
	@XmlElement(name = "Email" ,required = true, nillable = false)
	private String Email;
	
	@XmlElement(name = "PhoneNumber" ,required = true, nillable = false)
	private String PhoneNumber;
	
	@XmlElement(name = "Products" ,required = true, nillable = false)
	private List<ShoppingChartProductsEntity> ProductsEntity;	
	
	@XmlElement(name = "RequestedPrice" ,required = false)
	private double RequestedPrice;
	
	@XmlElement(name = "Currency" ,required = true, nillable=false)
	private String Currency;
	
	@XmlElement(name = "CancelOffer" ,required = false)
	private Integer CancelOffer;
	
	@XmlElement(name = "RequestNewDate" ,required = false)
	private Integer RequestNewDate;
	
	@XmlElement(name = "DealerComment" ,required = false)
	private String DealerComment;
	
	

	public List<ShoppingChartProductsEntity> getProductsEntity() {
		return ProductsEntity;
	}

	public void setProductsEntity(List<ShoppingChartProductsEntity> productsEntity) {
		ProductsEntity = productsEntity;
	}

	public String getOfferId() {
		return OfferId;
	}

	public void setOfferId(String offerId) {
		OfferId = offerId;
	}

	public String getDealerCode() {
		return DealerCode;
	}

	public void setDealerCode(String dealerCode) {
		DealerCode = dealerCode;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public double getRequestedPrice() {
		return RequestedPrice;
	}

	public void setRequestedPrice(double requestedPrice) {
		RequestedPrice = requestedPrice;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public Integer getCancelOffer() {
		return CancelOffer;
	}

	public void setCancelOffer(Integer cancelOffer) {
		CancelOffer = cancelOffer;
	}

	public Integer getRequestNewDate() {
		return RequestNewDate;
	}

	public void setRequestNewDate(Integer requestNewDate) {
		RequestNewDate = requestNewDate;
	}

	public String getDealerComment() {
		return DealerComment;
	}

	public void setDealerComment(String dealerComment) {
		DealerComment = dealerComment;
	}
	
	

}
