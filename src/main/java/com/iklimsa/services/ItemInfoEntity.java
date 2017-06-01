package com.iklimsa.services;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ItemInfoEntity {

	@XmlElement(name = "CategoryID")
	private Integer CategoryID;
	
	@XmlElement(name = "ProductID")
	private String ProductID;
	
	@XmlElement(name = "ProductCode")
	private String ProductCode;
	
	@XmlElement(name = "ProductName")
	private String ProductName;
	
	@XmlElement(name = "DetailDescription")
	private String DetailDescription;

	@XmlElement(name = "Price")
	private Double Price;

	@XmlElement(name = "CategoryPicture")
	private String CategoryPicture;

	@XmlElement(name = "DeliveryInformation")
	private String DeliveryInformation;

	@XmlElement(name = "Currency")
	private String Currency;

	@XmlElement(name = "ProductStatus")
	private String ProductStatus;
	
	@XmlElement(name = "DetailPictures")
	private List<ItemInfoDetailPictures> DetailPicturesList;
	
	@XmlElement(name = "ProductCatalogs")
	private List<ItemInfoProductCatalogs> ProductCatalogsList;

	public Integer getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(Integer categoryID) {
		CategoryID = categoryID;
	}

	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getDetailDescription() {
		return DetailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		DetailDescription = detailDescription;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public String getCategoryPicture() {
		return CategoryPicture;
	}

	public void setCategoryPicture(String categoryPicture) {
		CategoryPicture = categoryPicture;
	}

	public String getDeliveryInformation() {
		return DeliveryInformation;
	}

	public void setDeliveryInformation(String deliveryInformation) {
		DeliveryInformation = deliveryInformation;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getProductStatus() {
		return ProductStatus;
	}

	public void setProductStatus(String productStatus) {
		ProductStatus = productStatus;
	}

	public List<ItemInfoDetailPictures> getDetailPicturesList() {
		return DetailPicturesList;
	}

	public void setDetailPicturesList(List<ItemInfoDetailPictures> detailPicturesList) {
		DetailPicturesList = detailPicturesList;
	}

	public List<ItemInfoProductCatalogs> getProductCatalogsList() {
		return ProductCatalogsList;
	}

	public void setProductCatalogsList(List<ItemInfoProductCatalogs> productCatalogsList) {
		ProductCatalogsList = productCatalogsList;
	}

	

}
