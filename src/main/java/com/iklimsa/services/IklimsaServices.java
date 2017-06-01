package com.iklimsa.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


import com.iklimsa.exceptions.BusinessException;
import com.sun.xml.ws.developer.SchemaValidation;

@WebService
@SchemaValidation
public interface IklimsaServices  {

	@WebMethod
	public UserInfoReturn GetUserInfo();
	
	@WebMethod
	public CategoryStructureResponse GetCategoryStructure();
	
	@WebMethod
	public CatalogStructureResponse GetCatalogStructure();
	
	@WebMethod
	public ItemInfoResponse GetItemInfo();
	
	@WebMethod
	public ShoppingCartResponse CalculateShoppingCart(@WebParam(name="ChartInfo" ,targetNamespace="http://services.iklimsa.com/")ShoppingChartInEntity entity);
	
	@WebMethod
	public CreateUpdateOfferResponse CreateUpdateOffer(@WebParam(name="Offer" ,targetNamespace="http://services.iklimsa.com/")CreateUpdateOfferEntity entity) throws BusinessException;
	
	@WebMethod
	public CreateOrderResponse CreateOrder(@WebParam(name="Order" ,targetNamespace="http://services.iklimsa.com/") CreateOrderEntity entity) throws BusinessException;
	
}
