package com.iklimsa.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class UserInfoEntity {
	
	    @XmlElement(name = "DealerCode" )
		private String DealerCode;
		  @XmlElement(name = "DealerName" )
		private String DealerName;
		  @XmlElement(name = "DealerEmail" )
		private String DealerEmail;
		  @XmlElement(name = "DealerStatus" )
		private String DealerStatus;
		  @XmlElement(name = "DealerRegion" )
		private String DealerRegion;
		public String getDealerCode() {
			return DealerCode;
		}
		public void setDealerCode(String dealerCode) {
			DealerCode = dealerCode;
		}
		public String getDealerName() {
			return DealerName;
		}
		public void setDealerName(String dealerName) {
			DealerName = dealerName;
		}
		public String getDealerEmail() {
			return DealerEmail;
		}
		public void setDealerEmail(String dealerEmail) {
			DealerEmail = dealerEmail;
		}
		public String getDealerStatus() {
			return DealerStatus;
		}
		public void setDealerStatus(String dealerStatus) {
			DealerStatus = dealerStatus;
		}
		public String getDealerRegion() {
			return DealerRegion;
		}
		public void setDealerRegion(String dealerRegion) {
			DealerRegion = dealerRegion;
		}

		  
		  
}
