
package com.iklimsa.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CreateOrderResponse", namespace = "http://services.iklimsa.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateOrderResponse", namespace = "http://services.iklimsa.com/")
public class CreateOrderResponse {

    @XmlElement(name = "return", namespace = "")
    private com.iklimsa.services.CreateOrderResponse _return;

    /**
     * 
     * @return
     *     returns CreateOrderResponse
     */
    public com.iklimsa.services.CreateOrderResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.iklimsa.services.CreateOrderResponse _return) {
        this._return = _return;
    }

}
