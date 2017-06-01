package com.iklimsa.services;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ShoppingChartInEntity implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@XmlElement(name = "DealerCode" ,required = true, nillable = false)
	private Integer DealerCode;
	
	@XmlElement(name = "ShoppingChartProducts" ,required = true, nillable = false)
	private List<ShoppingChartProductsEntity> ShoppingChartProductsEntity;

	public Integer getDealerCode() {
		return DealerCode;
	}

	public void setDealerCode(Integer dealerCode) {
		DealerCode = dealerCode;
	}

	public List<ShoppingChartProductsEntity> getShoppingChartProductsEntity() {
		return ShoppingChartProductsEntity;
	}

	public void setShoppingChartProductsEntity(List<ShoppingChartProductsEntity> shoppingChartProductsEntity) {
		ShoppingChartProductsEntity = shoppingChartProductsEntity;
	}



	

	
	


}
