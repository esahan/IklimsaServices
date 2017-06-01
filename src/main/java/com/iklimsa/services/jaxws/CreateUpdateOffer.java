
package com.iklimsa.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CreateUpdateOffer", namespace = "http://services.iklimsa.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateUpdateOffer", namespace = "http://services.iklimsa.com/")
public class CreateUpdateOffer {

    @XmlElement(name = "Offer", namespace = "http://services.iklimsa.com/")
    private com.iklimsa.services.CreateUpdateOfferEntity offer;

    /**
     * 
     * @return
     *     returns CreateUpdateOfferEntity
     */
    public com.iklimsa.services.CreateUpdateOfferEntity getOffer() {
        return this.offer;
    }

    /**
     * 
     * @param offer
     *     the value for the offer property
     */
    public void setOffer(com.iklimsa.services.CreateUpdateOfferEntity offer) {
        this.offer = offer;
    }

}
