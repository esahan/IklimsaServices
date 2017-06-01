
package com.iklimsa.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetUserInfoResponse", namespace = "http://services.iklimsa.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUserInfoResponse", namespace = "http://services.iklimsa.com/")
public class GetUserInfoResponse {

    @XmlElement(name = "return", namespace = "")
    private com.iklimsa.services.UserInfoReturn _return;

    /**
     * 
     * @return
     *     returns UserInfoReturn
     */
    public com.iklimsa.services.UserInfoReturn getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.iklimsa.services.UserInfoReturn _return) {
        this._return = _return;
    }

}
