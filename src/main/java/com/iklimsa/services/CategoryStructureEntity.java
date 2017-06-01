package com.iklimsa.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CategoryStructureEntity {

	@XmlElement(name = "CategoryId")
	private String CategoryId;
	@XmlElement(name = "MainCategoryName")
	private String MainCategoryName;
	@XmlElement(name = "SubCategoryName")
	private String SubCategoryName;
	@XmlElement(name = "CategoryName")
	private String CategoryName;
	@XmlElement(name = "BrandName")
	private String BrandName;
	public String getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(String categoryId) {
		CategoryId = categoryId;
	}
	public String getMainCategoryName() {
		return MainCategoryName;
	}
	public void setMainCategoryName(String mainCategoryName) {
		MainCategoryName = mainCategoryName;
	}
	public String getSubCategoryName() {
		return SubCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		SubCategoryName = subCategoryName;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getBrandName() {
		return BrandName;
	}
	public void setBrandName(String brandName) {
		BrandName = brandName;
	}

	
}
