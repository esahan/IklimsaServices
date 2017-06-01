package com.iklimsa.services;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CatalogStructureEntity {
	
	@XmlElement(name = "CatalogGroupId")
	private Integer CatalogGroupId;
	@XmlElement(name = "CatalogGroupName")
	private String CatalogGroupName;
	
	@XmlElement(name = "TechDetails")
	private List<CatalogStructureTechDetailsEntity> CatalogTechList;

	public List<CatalogStructureTechDetailsEntity> getCatalogTechList() {
		return CatalogTechList;
	}

	public void setCatalogTechList(List<CatalogStructureTechDetailsEntity> catalogTechList) {
		CatalogTechList = catalogTechList;
	}

	public Integer getCatalogGroupId() {
		return CatalogGroupId;
	}

	public void setCatalogGroupId(Integer catalogGroupId) {
		CatalogGroupId = catalogGroupId;
	}

	public String getCatalogGroupName() {
		return CatalogGroupName;
	}

	public void setCatalogGroupName(String catalogGroupName) {
		CatalogGroupName = catalogGroupName;
	}

	
	
	

}
