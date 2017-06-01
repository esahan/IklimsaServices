
package com.iklimsa.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetCategoryStructureResponse", namespace = "http://services.iklimsa.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCategoryStructureResponse", namespace = "http://services.iklimsa.com/")
public class GetCategoryStructureResponse {

    @XmlElement(name = "return", namespace = "")
    private com.iklimsa.services.CategoryStructureResponse _return;

    /**
     * 
     * @return
     *     returns CategoryStructureResponse
     */
    public com.iklimsa.services.CategoryStructureResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.iklimsa.services.CategoryStructureResponse _return) {
        this._return = _return;
    }

}
