
package com.iklimsa.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetCatalogStructureResponse", namespace = "http://services.iklimsa.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCatalogStructureResponse", namespace = "http://services.iklimsa.com/")
public class GetCatalogStructureResponse {

    @XmlElement(name = "return", namespace = "")
    private com.iklimsa.services.CatalogStructureResponse _return;

    /**
     * 
     * @return
     *     returns CatalogStructureResponse
     */
    public com.iklimsa.services.CatalogStructureResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.iklimsa.services.CatalogStructureResponse _return) {
        this._return = _return;
    }

}
