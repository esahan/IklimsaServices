
package com.iklimsa.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CalculateShoppingCart", namespace = "http://services.iklimsa.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalculateShoppingCart", namespace = "http://services.iklimsa.com/")
public class CalculateShoppingCart {

    @XmlElement(name = "ChartInfo", namespace = "http://services.iklimsa.com/")
    private com.iklimsa.services.ShoppingChartInEntity chartInfo;

    /**
     * 
     * @return
     *     returns ShoppingChartInEntity
     */
    public com.iklimsa.services.ShoppingChartInEntity getChartInfo() {
        return this.chartInfo;
    }

    /**
     * 
     * @param chartInfo
     *     the value for the chartInfo property
     */
    public void setChartInfo(com.iklimsa.services.ShoppingChartInEntity chartInfo) {
        this.chartInfo = chartInfo;
    }

}
