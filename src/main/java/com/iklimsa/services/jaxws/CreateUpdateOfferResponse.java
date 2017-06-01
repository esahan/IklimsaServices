
package com.iklimsa.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CreateUpdateOfferResponse", namespace = "http://services.iklimsa.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateUpdateOfferResponse", namespace = "http://services.iklimsa.com/")
public class CreateUpdateOfferResponse {

    @XmlElement(name = "return", namespace = "")
    private com.iklimsa.services.CreateUpdateOfferResponse _return;

    /**
     * 
     * @return
     *     returns CreateUpdateOfferResponse
     */
    public com.iklimsa.services.CreateUpdateOfferResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.iklimsa.services.CreateUpdateOfferResponse _return) {
        this._return = _return;
    }

}
