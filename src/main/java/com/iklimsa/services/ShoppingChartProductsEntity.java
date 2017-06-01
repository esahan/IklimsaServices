package com.iklimsa.services;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ShoppingChartProducts" )
public class ShoppingChartProductsEntity  {


	@XmlElement(name = "ID" ,required = true, nillable = false , type=Integer.class)
	private Integer ID;
	
	@XmlElement(name = "Quantity" ,required = true, nillable = false , type=Integer.class)
	private Integer Quantity;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	
	
}
