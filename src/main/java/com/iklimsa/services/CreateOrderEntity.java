package com.iklimsa.services;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CreateOrderEntity implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "OfferId", required = true, nillable = false)
	private String OfferId;
	@XmlElement(name = "CustomerType", required = true, nillable = false)
	private String CustomerType;
	@XmlElement(name = "CompanyName", required = true, nillable = false)
	private String CompanyName;
	@XmlElement(name = "CustomerName", required = true, nillable = false)
	private String CustomerName;
	@XmlElement(name = "CustomerSurname", required = true, nillable = false)
	private String CustomerSurname;
	@XmlElement(name = "TaxOffice", required = true, nillable = false)
	private String TaxOffice;
	@XmlElement(name = "TaxNumber", required = true, nillable = false)
	private String TaxNumber;
	@XmlElement(name = "Address", required = true, nillable = false)
	private String Address;
	@XmlElement(name = "Province", required = true, nillable = false)
	private String Province;
	@XmlElement(name = "District", required = true, nillable = false)
	private String District;
	@XmlElement(name = "County", required = true, nillable = false)
	private String County;
	@XmlElement(name = "Country", required = true, nillable = false)
	private String Country;
	@XmlElement(name = "PhoneNumber", required = true, nillable = false)
	private String PhoneNumber;
	@XmlElement(name = "GSMNumber", required = true, nillable = false)
	private String GSMNumber;
	@XmlElement(name = "MailAdress", required = true, nillable = false)
	private String MailAdress;
	@XmlElement(name = "PaymentMethod", required = true, nillable = false)
	private String PaymentMethod;

	public String getOfferId() {
		return OfferId;
	}

	public void setOfferId(String offerId) {
		OfferId = offerId;
	}

	public String getCustomerType() {
		return CustomerType;
	}

	public void setCustomerType(String customerType) {
		CustomerType = customerType;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerSurname() {
		return CustomerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		CustomerSurname = customerSurname;
	}

	public String getTaxOffice() {
		return TaxOffice;
	}

	public void setTaxOffice(String taxOffice) {
		TaxOffice = taxOffice;
	}

	public String getTaxNumber() {
		return TaxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		TaxNumber = taxNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getCounty() {
		return County;
	}

	public void setCounty(String county) {
		County = county;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getGSMNumber() {
		return GSMNumber;
	}

	public void setGSMNumber(String gSMNumber) {
		GSMNumber = gSMNumber;
	}

	public String getMailAdress() {
		return MailAdress;
	}

	public void setMailAdress(String mailAdress) {
		MailAdress = mailAdress;
	}

	public String getPaymentMethod() {
		return PaymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}

}
