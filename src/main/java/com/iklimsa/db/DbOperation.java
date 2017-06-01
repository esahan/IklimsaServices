package com.iklimsa.db;


import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.iklimsa.db.connection.AppsConnection;
import com.iklimsa.log.ServiceLog;
import com.iklimsa.services.CatalogStructureEntity;
import com.iklimsa.services.CatalogStructureResponse;
import com.iklimsa.services.CatalogStructureTechDetailsEntity;
import com.iklimsa.services.CategoryStructureEntity;
import com.iklimsa.services.CategoryStructureResponse;
import com.iklimsa.services.CreateOrderEntity;
import com.iklimsa.services.CreateOrderRespObj;
import com.iklimsa.services.CreateOrderResponse;
import com.iklimsa.services.CreateUpdateOfferEntity;
import com.iklimsa.services.CreateUpdateOfferRespObj;
import com.iklimsa.services.CreateUpdateOfferResponse;
import com.iklimsa.services.ItemInfoEntity;
import com.iklimsa.services.ItemInfoProductCatalogs;
import com.iklimsa.services.ItemInfoResponse;
import com.iklimsa.services.ShoppingCartResponse;
import com.iklimsa.services.ShoppingChartInEntity;
import com.iklimsa.services.ShoppingChartProductsEntity;
import com.iklimsa.services.ShoppingChartRespObj;
import com.iklimsa.services.UserInfoEntity;
import com.iklimsa.services.UserInfoReturn;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleStatement;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.CLOB;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class DbOperation {

	static Logger LOG = Logger.getLogger(DbOperation.class);

	public static void writeRequestLog(ServiceLog logRecord) {
		LOG.info("writeRequestLog methodu");
		OracleConnection c = AppsConnection.getOracleConnection();
		OraclePreparedStatement psInsert = null;
		OraclePreparedStatement psSelect = null;
		OracleResultSet rsSelect = null;
		CLOB requestXml = null;
		try {
			c.setAutoCommit(false);
			if (c != null) {
				String insertSql = SqlConstant.LOG_INSERT_DML;

				psInsert = (OraclePreparedStatement) c.prepareStatement(insertSql);

				psInsert.setString(1, logRecord.getMessageId());
				psInsert.setString(2, logRecord.getEndpoint());
				psInsert.setString(3, logRecord.getContentType());
				psInsert.setInt(4, logRecord.getContentLength().intValue());
				psInsert.setString(5, logRecord.getCharset());
				psInsert.setString(6, logRecord.getOperation());
				psInsert.setString(7, logRecord.getRequestMethod());
				psInsert.setString(8, logRecord.getNamespace());
				psInsert.executeUpdate();

				String selectSql = SqlConstant.LOG_REQUEST_SELECT;
				psSelect = (OraclePreparedStatement) c.prepareStatement(selectSql);
				psSelect.setString(1, logRecord.getMessageId());
				rsSelect = (OracleResultSet) psSelect.executeQuery();
				rsSelect.next();

				Object myCLOB = rsSelect.getObject(1);
	//			if (myCLOB instanceof weblogic.jdbc.wrapper.Clob)
	//				requestXml = (oracle.sql.CLOB) (((weblogic.jdbc.wrapper.Clob) myCLOB)
	//						.unwrap(Class.forName("oracle.sql.CLOB")));
	//			else
					requestXml = (oracle.sql.CLOB) myCLOB;

				String requestXmlStr = logRecord.getRequestXml().toString("UTF-8");
				requestXml.setString(1, requestXmlStr);
				c.commit();

				/*
				 * requestXml = rsSelect.getCLOB(1); String requestXmlStr =
				 * logRecord.getRequestXml().toString("UTF-8");
				 * requestXml.setString(1, requestXmlStr); c.commit();
				 */
			}

		} catch (Exception e) {
			LOG.error("Error during SQLException", e);
		}  finally {
			try {
				if (rsSelect != null)
					rsSelect.close();

				if (psInsert != null)
					psInsert.close();

				if (psSelect != null)
					psSelect.close();

				if (c != null && !c.isClosed())
					c.close();

			} catch (SQLException e) {
				LOG.error("Error during SQLException", e);
			}
		}
	}

	public static void writeResponseLog(ServiceLog logRecord) {
		LOG.info("writeResponseLog methodu");
		OracleConnection c = AppsConnection.getOracleConnection();
		OraclePreparedStatement psInsert = null;
		OraclePreparedStatement psSelect = null;
		OraclePreparedStatement psUpdate = null;
		OracleResultSet rsSelect = null;
		CLOB responseXml = null;
		try {
			c.setAutoCommit(false);
			if (c != null) {

				String selectSql = SqlConstant.LOG_RESPONSE_SELECT;
				psSelect = (OraclePreparedStatement) c.prepareStatement(selectSql);
				psSelect.setString(1, logRecord.getMessageId());
				rsSelect = (OracleResultSet) psSelect.executeQuery();
				rsSelect.next();

				Object myCLOB = rsSelect.getObject(1);
	//			if (myCLOB instanceof weblogic.jdbc.wrapper.Clob)
	//				responseXml = (oracle.sql.CLOB) (((weblogic.jdbc.wrapper.Clob) myCLOB)
	//						.unwrap(Class.forName("oracle.sql.CLOB")));
	//			else
					responseXml = (oracle.sql.CLOB) myCLOB;

				String responseXmlStr = logRecord.getResponseXml().toString("UTF-8");
				responseXml.setString(1, responseXmlStr);

				/*
				 * responseXml = rsSelect.getCLOB(1); String responseXmlStr =
				 * logRecord.getResponseXml().toString("UTF-8");
				 * 
				 * responseXml.setString(1, responseXmlStr);
				 */

				String updateSql = SqlConstant.LOG_UPDATE_DML;
				psUpdate = (OraclePreparedStatement) c.prepareStatement(updateSql);
				psUpdate.setString(1, logRecord.getHasFault().booleanValue() ? "Y" : "N");
				psUpdate.setString(2, logRecord.getMessageId());
				psUpdate.executeUpdate();
				c.commit();
			}

		} catch (Exception e) {
			System.out.println("Error during SQLException " + e);
			LOG.error("Error during SQLException", e);
		}  finally {
			try {
				if (rsSelect != null)
					rsSelect.close();

				if (psInsert != null)
					psInsert.close();

				if (psSelect != null)
					psSelect.close();

				if (c != null && !c.isClosed())
					c.close();

			} catch (SQLException e) {
				System.out.println("Error during SQLException " + e);
				LOG.error("Error during SQLException", e);
			}
		}
	}

	public static UserInfoReturn dbGetUserInfo() {

		UserInfoReturn userReturn = new UserInfoReturn();
		List<UserInfoEntity> userInfoList = new ArrayList<UserInfoEntity>();

		OracleConnection con = null;
		OracleStatement oracleStatement = null;
		OracleResultSet rsSelect = null;

		try {
			con = AppsConnection.getOracleConnection();
			oracleStatement = (OracleStatement) con.createStatement();
			rsSelect = (OracleResultSet) oracleStatement.executeQuery(SqlConstant.GET_USER_INFO_SELECT);

			while (rsSelect.next()) {
				UserInfoEntity user = new UserInfoEntity();

				user.setDealerName(rsSelect.getString("BAYI_ISMI"));
				user.setDealerCode(rsSelect.getString("BAYI_NO"));
				user.setDealerEmail(rsSelect.getString("MAIL"));
				user.setDealerRegion(rsSelect.getString("BOLGE"));
				user.setDealerStatus(rsSelect.getString("STATUS"));

				userInfoList.add(user);
			}

			userReturn.setResponseCode("1");
			userReturn.setMessage("Success");
			userReturn.setUserList(userInfoList);

		} catch (Exception e) {

			userReturn.setResponseCode("0");
			userReturn.setMessage("Fail During Database Connection  :" + e);

		} finally {

			try {

				if (oracleStatement != null) {
					oracleStatement.close();
				}

				if (con != null) {
					con.close();
				}

				if (rsSelect != null)
					rsSelect.close();
			} catch (Exception e) {

				System.out.println("Error during SQLException" + e);
				LOG.error("Error during SQLException", e);

			}

		}

		return userReturn;

	}

	public static CategoryStructureResponse dbGetCategoryStructure() {

		CategoryStructureResponse categoryResponse = new CategoryStructureResponse();
		List<CategoryStructureEntity> categoryStructList = new ArrayList<CategoryStructureEntity>();

		OracleConnection con = null;
		OracleStatement oracleStatement = null;
		OracleResultSet rsSelect = null;

		try {
			con = AppsConnection.getOracleConnection();
			oracleStatement = (OracleStatement) con.createStatement();
			rsSelect = (OracleResultSet) oracleStatement.executeQuery(SqlConstant.GET_CATEGORY_STRUCTURE);

			while (rsSelect.next()) {
				CategoryStructureEntity category = new CategoryStructureEntity();

				category.setCategoryId(rsSelect.getString("KATEGORI_ID"));
				category.setBrandName(rsSelect.getString("BRANDNAME"));
				category.setCategoryName(rsSelect.getString("CATEGORYNAME"));
				category.setMainCategoryName(rsSelect.getString("MAINCATEGORYNAME"));
				category.setSubCategoryName(rsSelect.getString("SUBCATEGORYNAME"));

				categoryStructList.add(category);
			}

			categoryResponse.setResponseCode("1");
			categoryResponse.setMessage("Success");
			categoryResponse.setCategoryList(categoryStructList);

		} catch (Exception e) {

			categoryResponse.setResponseCode("0");
			categoryResponse.setMessage("Fail During Database Connection  :" + e);

		} finally {

			try {

				if (oracleStatement != null) {
					oracleStatement.close();
				}

				if (con != null) {
					con.close();
				}

				if (rsSelect != null)
					rsSelect.close();
			} catch (Exception e) {

				System.out.println("Error during SQLException" + e);
				LOG.error("Error during SQLException", e);

			}

		}

		return categoryResponse;

	}

	public static CatalogStructureResponse dbGetCatalogStructure() {
		CatalogStructureResponse response = new CatalogStructureResponse();
		List<CatalogStructureEntity> catalogEntityList = new ArrayList<CatalogStructureEntity>();

		OracleConnection con = null;
		OracleStatement oracleStatement = null;
		OracleResultSet rsSelect = null;
		OracleResultSet preRsSelect = null;
		OraclePreparedStatement preparedStatement = null;

		try {
			con = AppsConnection.getOracleConnection();
			oracleStatement = (OracleStatement) con.createStatement();
			rsSelect = (OracleResultSet) oracleStatement.executeQuery(SqlConstant.GET_CATALOG_STRUCTURE);

			while (rsSelect.next()) {
				CatalogStructureEntity catalog = new CatalogStructureEntity();

				catalog.setCatalogGroupId(rsSelect.getInt("CATALOG_GROUP_ID"));
				catalog.setCatalogGroupName(rsSelect.getString("CATALOG_GROUP_NAME"));

				catalogEntityList.add(catalog);
			}

			for (CatalogStructureEntity obj : catalogEntityList) {

				Integer groupId = obj.getCatalogGroupId();
				String cataGroupName = obj.getCatalogGroupName();

				preparedStatement = (OraclePreparedStatement) con
						.prepareStatement(SqlConstant.GET_CATALOG_STRUCTURE_TECH_DETAILS);

				preparedStatement.setInt(1, groupId);
				preparedStatement.setString(2, cataGroupName);

				preRsSelect = (OracleResultSet) preparedStatement.executeQuery();
				List<CatalogStructureTechDetailsEntity> techDetailList = new ArrayList<CatalogStructureTechDetailsEntity>();
				while (preRsSelect.next()) {
					CatalogStructureTechDetailsEntity techDetailEntity = new CatalogStructureTechDetailsEntity();

					techDetailEntity.setSequence(preRsSelect.getString("ELEMENT_SEQUENCE"));
					techDetailEntity.setName(preRsSelect.getString("ELEMENT_NAME"));
					techDetailList.add(techDetailEntity);

				}
				obj.setCatalogTechList(techDetailList);
			}

			response.setResponseCode("1");
			response.setMessage("Success");
			response.setCatalogList(catalogEntityList);

		} catch (Exception e) {

			response.setResponseCode("0");
			response.setMessage("Fail During Database Connection  :" + e);
			System.out.println("Fail During Database Connection  :" + e);
			e.printStackTrace();

		} finally {

			try {

				if (oracleStatement != null) {
					oracleStatement.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (con != null) {
					con.close();
				}

				if (rsSelect != null)
					rsSelect.close();

				if (preRsSelect != null)
					preRsSelect.close();
			} catch (Exception e) {

				System.out.println("Error during SQLException" + e);
				LOG.error("Error during SQLException", e);

			}

		}

		return response;

	}

	public static ItemInfoResponse dbGetItemInfo() {
		ItemInfoResponse response = new ItemInfoResponse();
		List<ItemInfoEntity> ItemInfoEntitylist = new ArrayList<ItemInfoEntity>();

		OracleConnection con = null;
		OracleStatement oracleStatement = null;
		OracleResultSet rsSelect = null;
		OracleResultSet preRsSelect = null;
		OraclePreparedStatement preparedStatement = null;

		try {
			con = AppsConnection.getOracleConnection();
			oracleStatement = (OracleStatement) con.createStatement();
			rsSelect = (OracleResultSet) oracleStatement.executeQuery(SqlConstant.GET_ITEM_INFO_MAIN);

			while (rsSelect.next()) {
				ItemInfoEntity itemInfo = new ItemInfoEntity();

				itemInfo.setCategoryID(rsSelect.getInt("CATEGORY_ID")); // integer
				itemInfo.setProductID(rsSelect.getString("INVENTORY_ITEM_ID"));
				itemInfo.setProductCode(rsSelect.getString("PRODUCT_CODE"));
				itemInfo.setProductName(rsSelect.getString("DESCRIPTION"));
				itemInfo.setCurrency(rsSelect.getString("CURRENCY_CODE"));
				itemInfo.setPrice(rsSelect.getDouble("UNIT_PRICE")); // double
				itemInfo.setDeliveryInformation(rsSelect.getString("ATTRIBUTE13"));
				itemInfo.setProductStatus(rsSelect.getString("STATUS"));

				ItemInfoEntitylist.add(itemInfo);
			}

			for (ItemInfoEntity obj : ItemInfoEntitylist) {

				Integer catID = obj.getCategoryID();
				String invItemId = obj.getProductID();

				preparedStatement = (OraclePreparedStatement) con
						.prepareStatement(SqlConstant.GET_ITEM_INFO_PRODUCT_CATALOG);

				preparedStatement.setInt(1, catID);
				preparedStatement.setString(2, invItemId);

				preRsSelect = (OracleResultSet) preparedStatement.executeQuery();
				List<ItemInfoProductCatalogs> ItemInfoProductCatalogsList = new ArrayList<ItemInfoProductCatalogs>();
				while (preRsSelect.next()) {
					ItemInfoProductCatalogs catalogObj = new ItemInfoProductCatalogs();

					catalogObj.setId(preRsSelect.getString("ELEMENT_NAME"));
					catalogObj.setValue(preRsSelect.getString("ELEMENT_VALUE"));
					ItemInfoProductCatalogsList.add(catalogObj);

				}
				obj.setProductCatalogsList(ItemInfoProductCatalogsList);
			}

			response.setResponseCode("1");
			response.setMessage("Success");
			response.setItemInfoEntityList(ItemInfoEntitylist);

		} catch (Exception e) {

			response.setResponseCode("0");
			response.setMessage("Fail During Database Connection  :" + e);
			System.out.println("Fail During Database Connection  :" + e);
			e.printStackTrace();

		} finally {

			try {

				if (oracleStatement != null) {
					oracleStatement.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (con != null) {
					con.close();
				}

				if (rsSelect != null)
					rsSelect.close();

				if (preRsSelect != null)
					preRsSelect.close();
			} catch (Exception e) {

				System.out.println("Error during SQLException" + e);
				LOG.error("Error during SQLException", e);

			}

		}

		return response;

	}

	public static ShoppingCartResponse dbCalculateShoppingCart(ShoppingChartInEntity entity) {
		ShoppingCartResponse response = new ShoppingCartResponse();
		ShoppingChartRespObj responseObj = new ShoppingChartRespObj();
		List<ShoppingChartProductsEntity> productsEntities = entity.getShoppingChartProductsEntity();
		Integer dealerCode = entity.getDealerCode();

		OracleConnection con = null;
		OracleCallableStatement callableStatement = null;
		OracleCallableStatement callableStatement2 = null;

		try {
			con = AppsConnection.getOracleConnection();
			StructDescriptor productsDescriptor = StructDescriptor.createDescriptor("XXTSA_CHART_PRODUCTS", con);
			StructDescriptor chartDescriptor = StructDescriptor.createDescriptor("XXTSA_CHART_OBJ", con);

			ArrayDescriptor productsArrayDescriptor = ArrayDescriptor.createDescriptor("XXTSA_CHART_PRODUCTS_TBL", con);

			STRUCT[] productDescStructs = new STRUCT[productsEntities.size()];
			int lineCount = 0;
			Iterator<ShoppingChartProductsEntity> productIterator = productsEntities.iterator();

			while (productIterator.hasNext()) {

				ShoppingChartProductsEntity newProduct = productIterator.next();

				Object[] productObj = new Object[2];

				productObj[0] = newProduct.getID();
				productObj[1] = newProduct.getQuantity();

				STRUCT prodStruct = new STRUCT(productsDescriptor, con, productObj);
				productDescStructs[lineCount] = prodStruct;
				lineCount = lineCount + 1;

			}

			Object[] chartObj = new Object[2];
			chartObj[0] = dealerCode;
			chartObj[1] = new ARRAY(productsArrayDescriptor, con, productDescStructs);
			STRUCT chartStruct = new STRUCT(chartDescriptor, con, chartObj);

			callableStatement = (OracleCallableStatement) con.prepareCall(SqlConstant.WRITE_SHOPPING_CHART);

			callableStatement.setSTRUCT(1, chartStruct);

			callableStatement.registerOutParameter(2, Types.INTEGER);
			callableStatement.registerOutParameter(3, Types.VARCHAR);

			callableStatement.execute();

			int chartId = callableStatement.getInt(2);
			String status = callableStatement.getString(3);

			System.out.println("chartId " + chartId);
			System.out.println("status " + status);

			callableStatement2 = (OracleCallableStatement) con.prepareCall(SqlConstant.CALCULATE_CHART_AMOUNT);
			callableStatement2.setInt(1, chartId);
			callableStatement2.registerOutParameter(2, Types.DOUBLE);
			callableStatement2.registerOutParameter(3, Types.DOUBLE);
			callableStatement2.registerOutParameter(4, Types.VARCHAR);
			callableStatement2.registerOutParameter(5, Types.DATE);

			callableStatement2.execute();

			/*
			 * callableStatement2.getDouble(2); callableStatement2.getDouble(3);
			 * callableStatement2.getString(3); callableStatement2.getDate(4);
			 */

			responseObj.setRegularPrice(callableStatement2.getDouble(2));
			responseObj.setDiscountedPrice(callableStatement2.getDouble(3));
			responseObj.setCurrency(callableStatement2.getString(4));
			responseObj.setOfferValidDate(callableStatement2.getDate(5));

			response.setResponseCode("1");
			response.setMessage("Success");
			response.setOutput(responseObj);

		} catch (Exception e) {
			System.out.println("dbCalculateShoppingCart'da hata loglar� inceleyiniz" + e);
			response.setResponseCode("0");
			response.setMessage("Fail During Database Connection  :" + e);
			e.printStackTrace(System.out);

		} finally {

			try {
				
				if (callableStatement != null) {
					callableStatement.close();
				}
				
				if (callableStatement2 != null) {
					callableStatement2.close();
				}

				if (con != null) {
					con.close();
				}

			} catch (Exception e) {

				System.out.println("Error during SQLException" + e);
				LOG.error("Error during SQLException", e);

			}

		}
		return response;

	}
	
	public static CreateUpdateOfferResponse dbCreateUpdateOffer(CreateUpdateOfferEntity entity){
		
		CreateUpdateOfferResponse response = new CreateUpdateOfferResponse();
		CreateUpdateOfferRespObj responseObj = new CreateUpdateOfferRespObj();
		List<ShoppingChartProductsEntity> productsEntities = entity.getProductsEntity();
		

		OracleConnection con = null;
		OracleCallableStatement callableStatement = null;
		
		
		try {
			con = AppsConnection.getOracleConnection();
			StructDescriptor productsDescriptor = StructDescriptor.createDescriptor("XXTSA_CHART_PRODUCTS", con);
			StructDescriptor offerDescriptor = StructDescriptor.createDescriptor("XXTSA_OFFER_OBJ", con);

			ArrayDescriptor productsArrayDescriptor = ArrayDescriptor.createDescriptor("XXTSA_CHART_PRODUCTS_TBL", con);

			STRUCT[] productDescStructs = new STRUCT[productsEntities.size()];
			int lineCount = 0;
			Iterator<ShoppingChartProductsEntity> productIterator = productsEntities.iterator();

			while (productIterator.hasNext()) {

				ShoppingChartProductsEntity newProduct = productIterator.next();

				Object[] productObj = new Object[2];

				productObj[0] = newProduct.getID();
				productObj[1] = newProduct.getQuantity();

				STRUCT prodStruct = new STRUCT(productsDescriptor, con, productObj);
				productDescStructs[lineCount] = prodStruct;
				lineCount = lineCount + 1;

			}

			Object[] chartObj = new Object[13];
			chartObj[0] = entity.getOfferId();
			chartObj[1] = entity.getDealerCode();
			chartObj[2] = entity.getCompanyName();
			chartObj[3] = entity.getName();
			chartObj[4] = entity.getSurname();
			chartObj[5] = entity.getEmail();
			chartObj[6] = entity.getPhoneNumber();
			chartObj[7] = entity.getRequestedPrice();
			chartObj[8] = entity.getCurrency();
			chartObj[9] = entity.getCancelOffer();
			chartObj[10] = entity.getRequestNewDate();
			chartObj[11] = entity.getDealerComment();
			chartObj[12] = new ARRAY(productsArrayDescriptor, con, productDescStructs);
			STRUCT offerStruct = new STRUCT(offerDescriptor, con, chartObj);

			callableStatement = (OracleCallableStatement) con.prepareCall(SqlConstant.CALCULATE_UPDATE_OFFER);

			callableStatement.setSTRUCT(1, offerStruct);

			callableStatement.registerOutParameter(2, Types.VARCHAR);
			callableStatement.registerOutParameter(3, Types.DOUBLE);
			callableStatement.registerOutParameter(4, Types.DOUBLE);
			callableStatement.registerOutParameter(5, Types.DATE);
			callableStatement.registerOutParameter(6, Types.VARCHAR);
			
			
			callableStatement.execute();

			
			 String OfferId        = callableStatement.getString(2);
			 double RegularPrice    = callableStatement.getDouble(3);
			 double DiscountedPrice = callableStatement.getDouble(4);
			 Date ValidDate         = callableStatement.getDate(5);
			 String status     		= callableStatement.getString(6);     

			
			System.out.println("OfferId " + OfferId);
			System.out.println("RegularPrice " + RegularPrice);
			System.out.println("DiscountedPrice " + DiscountedPrice);
			System.out.println("status " + status);

			
			if(status.equalsIgnoreCase("S")){
				responseObj.setOfferId(OfferId);
				responseObj.setRegularPrice(RegularPrice);
				responseObj.setDiscountedPrice(DiscountedPrice);
				responseObj.setOfferValidDate(ValidDate);

				response.setResponseCode("1");
				response.setMessage("Success");
				response.setOutput(responseObj);
				
				
			}else {
				
				response.setResponseCode("0");
				response.setMessage("Fail During Database Operation");				
			}
			
	


		} catch (Exception e) {
			System.out.println("dbCalculateShoppingCart'da hata loglar� inceleyiniz" + e);
			response.setResponseCode("0");
			response.setMessage("Fail During Database Connection  :" + e);
			e.printStackTrace(System.out);

		} finally {

			try {
				
				if (callableStatement != null) {
					callableStatement.close();
				}
				
			

				if (con != null) {
					con.close();
				}

			} catch (Exception e) {

				System.out.println("Error during SQLException" + e);
				LOG.error("Error during SQLException", e);

			}

		}
		return response;
	}
	
	public static CreateOrderResponse dbCreateOrder(CreateOrderEntity entity){
		
		CreateOrderResponse response = new CreateOrderResponse();
		CreateOrderRespObj responseObj = new CreateOrderRespObj();
		
		

		OracleConnection con = null;
		OracleCallableStatement callableStatement = null;
		
		
		try {
			con = AppsConnection.getOracleConnection();
			

			callableStatement = (OracleCallableStatement) con.prepareCall(SqlConstant.CREATE_ORDER);

			callableStatement.setString(1, entity.getOfferId());
			callableStatement.setString(2, entity.getCustomerType());
			callableStatement.setString(3, entity.getCompanyName());
			callableStatement.setString(4, entity.getCustomerName());
			
			
			callableStatement.setString(5, entity.getCustomerSurname());
			callableStatement.setString(6, entity.getTaxOffice());
			callableStatement.setString(7, entity.getTaxNumber());
			callableStatement.setString(8, entity.getAddress());
			callableStatement.setString(9, entity.getProvince());
			callableStatement.setString(10, entity.getDistrict());
			callableStatement.setString(11, entity.getCounty());
			callableStatement.setString(12, entity.getCountry());
			callableStatement.setString(13, entity.getPhoneNumber());
			callableStatement.setString(14, entity.getGSMNumber());
			callableStatement.setString(15, entity.getMailAdress());
			callableStatement.setString(16, entity.getPaymentMethod());

			callableStatement.registerOutParameter(17, Types.VARCHAR);
			callableStatement.registerOutParameter(18, Types.VARCHAR);
			callableStatement.registerOutParameter(19, Types.VARCHAR);

			callableStatement.execute();
			


			 String orderID        = callableStatement.getString(17);
			 String paymentLink        = callableStatement.getString(18);
			 String status        = callableStatement.getString(19);
  

			
			System.out.println("orderID " + orderID);
			System.out.println("paymentLink " + paymentLink);
			System.out.println("status " + status);

			
			if(status.equalsIgnoreCase("S")){
				
				responseObj.setOrderId(orderID);
				responseObj.setPaymentLink(paymentLink);

				response.setResponseCode("1");
				response.setMessage("Success");
				response.setOutput(responseObj);
				
				
			}else {
				
				response.setResponseCode("0");
				response.setMessage("Fail During Database Operation");				
			}
			


		} catch (Exception e) {
			System.out.println("dbCalculateShoppingCart'da hata loglar� inceleyiniz" + e);
			response.setResponseCode("0");
			response.setMessage("Fail During Database Connection  :" + e);
			e.printStackTrace(System.out);

		} finally {

			try {
				
				if (callableStatement != null) {
					callableStatement.close();
				}
				
			

				if (con != null) {
					con.close();
				}

			} catch (Exception e) {

				System.out.println("Error during SQLException" + e);
				LOG.error("Error during SQLException", e);

			}

		}
		return response;
		
		
	}
}
