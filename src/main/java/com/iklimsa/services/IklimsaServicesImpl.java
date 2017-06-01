package com.iklimsa.services;



import javax.jws.HandlerChain;
import javax.jws.WebService;

import com.iklimsa.db.DbOperation;
import com.iklimsa.exceptions.BusinessException;
import com.iklimsa.exceptions.BusinessExceptionDetail;
import com.iklimsa.util.ValidationClass;

@WebService(endpointInterface="com.iklimsa.services.IklimsaServices" , serviceName="Ege")    
@HandlerChain(file="handler-chain.xml")
public class IklimsaServicesImpl implements IklimsaServices {

	@Override
	public UserInfoReturn GetUserInfo() {
		// TODO Auto-generated method stub	
		return DbOperation.dbGetUserInfo();
	}

	@Override
	public CategoryStructureResponse GetCategoryStructure() {
		// TODO Auto-generated method stub
		return DbOperation.dbGetCategoryStructure();
	}

	@Override
	public CatalogStructureResponse GetCatalogStructure() {
		// TODO Auto-generated method stub
		return DbOperation.dbGetCatalogStructure();
	}

	@Override
	public ItemInfoResponse GetItemInfo() {
		// TODO Auto-generated method stub
		return DbOperation.dbGetItemInfo();
	}

	@Override
	public ShoppingCartResponse CalculateShoppingCart(ShoppingChartInEntity entity) {
		// TODO Auto-generated method stub
		
		System.out.println("dealercode "+entity.getDealerCode());
		for(ShoppingChartProductsEntity asdf : entity.getShoppingChartProductsEntity()) {
			
			System.out.println("id "+asdf.getID());
			System.out.println("quantity "+asdf.getQuantity());

		}
		return DbOperation.dbCalculateShoppingCart(entity);
	}

	@Override
	public CreateUpdateOfferResponse CreateUpdateOffer(CreateUpdateOfferEntity entity) throws BusinessException {
		System.out.println("email "+entity.getEmail());
		for(ShoppingChartProductsEntity asdf : entity.getProductsEntity()) {
			
			System.out.println("id "+asdf.getID());
			System.out.println("quantity "+asdf.getQuantity());

		}
		
	if (!	ValidationClass.isValidEmailAddress(entity.getEmail()) ){
		
		BusinessExceptionDetail faultDetail= new BusinessExceptionDetail();
		faultDetail.setFaultCode("100");
		faultDetail.setFaultMessage("Geçerli Bir Email Adresi Girmelisiniz!");
		
		throw new BusinessException("Alan Validasyonu Hatasý", faultDetail);
	}
	if(entity.getOfferId()!=null){
	if (!	ValidationClass.isValidIfOnlyContainsNumber(entity.getOfferId())){
		
		BusinessExceptionDetail faultDetail= new BusinessExceptionDetail();
		faultDetail.setFaultCode("100");
		faultDetail.setFaultMessage("OfferId Alaný Sadece Rakamlardan Olumalýdýr!");
		
		throw new BusinessException("Alan Validasyonu Hatasý", faultDetail);
	}}
		    
		
		return DbOperation.dbCreateUpdateOffer(entity);
	}

	@Override
	public CreateOrderResponse CreateOrder(CreateOrderEntity entity) throws BusinessException {
		if (!	ValidationClass.isValidEmailAddress(entity.getMailAdress()) ){
			
			BusinessExceptionDetail faultDetail= new BusinessExceptionDetail();
			faultDetail.setFaultCode("100");
			faultDetail.setFaultMessage("Geçerli Bir Email Adresi Girmelisiniz!");
			
			throw new BusinessException("Alan Validasyonu Hatasý", faultDetail);
		}
		if(entity.getOfferId() != null){
		if (!	ValidationClass.isValidIfOnlyContainsNumber(entity.getOfferId())){
			
			BusinessExceptionDetail faultDetail= new BusinessExceptionDetail();
			faultDetail.setFaultCode("100");
			faultDetail.setFaultMessage("OfferId Alaný Sadece Rakamlardan Olumalýdýr!");
			
			throw new BusinessException("Alan Validasyonu Hatasý", faultDetail);
		}}
		return DbOperation.dbCreateOrder(entity);
	}

}
	

