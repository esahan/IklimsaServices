
package com.iklimsa.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CalculateShoppingCartResponse", namespace = "http://services.iklimsa.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalculateShoppingCartResponse", namespace = "http://services.iklimsa.com/")
public class CalculateShoppingCartResponse {

    @XmlElement(name = "return", namespace = "")
    private com.iklimsa.services.ShoppingCartResponse _return;

    /**
     * 
     * @return
     *     returns ShoppingCartResponse
     */
    public com.iklimsa.services.ShoppingCartResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.iklimsa.services.ShoppingCartResponse _return) {
        this._return = _return;
    }

}
