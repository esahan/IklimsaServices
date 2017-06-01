
package com.iklimsa.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CreateOrder", namespace = "http://services.iklimsa.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateOrder", namespace = "http://services.iklimsa.com/")
public class CreateOrder {

    @XmlElement(name = "Order", namespace = "http://services.iklimsa.com/")
    private com.iklimsa.services.CreateOrderEntity order;

    /**
     * 
     * @return
     *     returns CreateOrderEntity
     */
    public com.iklimsa.services.CreateOrderEntity getOrder() {
        return this.order;
    }

    /**
     * 
     * @param order
     *     the value for the order property
     */
    public void setOrder(com.iklimsa.services.CreateOrderEntity order) {
        this.order = order;
    }

}
