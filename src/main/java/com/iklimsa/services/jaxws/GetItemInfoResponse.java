
package com.iklimsa.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetItemInfoResponse", namespace = "http://services.iklimsa.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetItemInfoResponse", namespace = "http://services.iklimsa.com/")
public class GetItemInfoResponse {

    @XmlElement(name = "return", namespace = "")
    private com.iklimsa.services.ItemInfoResponse _return;

    /**
     * 
     * @return
     *     returns ItemInfoResponse
     */
    public com.iklimsa.services.ItemInfoResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.iklimsa.services.ItemInfoResponse _return) {
        this._return = _return;
    }

}
