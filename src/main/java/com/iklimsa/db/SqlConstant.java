package com.iklimsa.db;

public class SqlConstant {
	/* LOG SQL Scripts */
	public static String LOG_TABLE = "XXTSA_IKLIMSA_WS_LOG";
	public static String LOG_REQUEST_SELECT = "SELECT REQUEST_XML_CLOB FROM " + LOG_TABLE
			+ " WHERE MESSAGE_ID = ? FOR UPDATE";
	public static String LOG_RESPONSE_SELECT = "SELECT RESPONSE_XML_CLOB FROM " + LOG_TABLE
			+ " WHERE MESSAGE_ID = ? FOR UPDATE";
	public static String LOG_INSERT_DML = "INSERT INTO " + LOG_TABLE
			+ " (MESSAGE_ID, ENDPOINT, CONTENT_TYPE, CONTENT_LENGTH, CHARSET, OPERATION, REQUEST_METHOD, NAMESPACE, REQUEST_XML_CLOB, RESPONSE_XML_CLOB, CREATION_DATE, CREATED_BY, LAST_UPDATE_DATE) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, empty_clob(), empty_clob(), SYSDATE, NULL, SYSDATE)";
	public static String LOG_UPDATE_DML = "UPDATE " + LOG_TABLE + " SET HAS_ERROR = ? WHERE MESSAGE_ID = ?";

	/* TEST Scripts */
	public static String TEST_SELECT = "SELECT * FROM XXTSA_IKLIMSA_BAYI_VW";

	public static String GET_USER_INFO_SELECT = "SELECT OBJ.PARTY_NAME BAYI_ISMI,     \n"
			+ "          HC.ACCOUNT_NUMBER BAYI_NO, \n" + "          CSM.SALES_CHANNEL BOLGE,   \n"
			+ "          OBJ.EMAIL_ADDRESS MAIL,    \n" + "          SUBJ.STATUS       STATUS   \n"
			+ "     FROM HZ_PARTY_RELATIONSHIPS REL,\n" + "          HZ_PARTIES SUBJ,\n" + "          HZ_PARTIES OBJ,\n"
			+ "          HZ_CUST_ACCOUNTS HC,\n" + "          CUSTOMER_SALESPERSON_MAP_V CSM\n"
			+ "    WHERE     SUBJ.PARTY_ID = REL.SUBJECT_ID\n" + "          AND SUBJ.PARTY_TYPE = 'PERSON'\n"
			+ "          AND OBJ.PARTY_ID = REL.OBJECT_ID\n" + "          AND OBJ.PARTY_TYPE = 'ORGANIZATION'\n"
			+ "          AND HC.PARTY_ID = REL.OBJECT_ID\n" + "          AND CSM.CUST_ACCOUNT_ID = HC.CUST_ACCOUNT_ID\n"
			+ "          AND CUSTOMER_CLASS_CODE in  ('ÝKLÝMSA MERKEZÝ', 'SERVÝS')\n"
			+ "          AND TRUNC (SYSDATE) BETWEEN TRUNC (\n"
			+ "                                         NVL (CSM.START_DATE_ACTIVE,\n"
			+ "                                              TRUNC (SYSDATE - 1)))\n"
			+ "                                  AND TRUNC (\n"
			+ "                                         NVL (CSM.END_DATE_ACTIVE,\n"
			+ "                                              TRUNC (SYSDATE + 1)))";

	public static String GET_CATEGORY_STRUCTURE = "select \n" + "   CATEGORY_ID   Kategori_id,\n"
			+ "   SEGMENT1  MainCategoryName,\n" + "   SEGMENT2  SubCategoryName,\n" + "   SEGMENT3  CategoryName,\n"
			+ "   SEGMENT4  BrandName  \n" + "from xxbyp_categories_v";

	public static String GET_CATALOG_STRUCTURE = "select distinct  catalog_group_id,\n"
			+ "                catalog_group_name\n" + "                from xxbyp_item_catalog_elements_v";

	public static String GET_CATALOG_STRUCTURE_TECH_DETAILS = "SELECT   \n" + "            element_name,\n"
			+ "            element_sequence\n" + "from \n" + "xxbyp_item_catalog_elements_v \n"
			+ "where catalog_group_id= ? and CATALOG_GROUP_NAME= ? ";
	
	public static String GET_ITEM_INFO_MAIN= "SELECT distinct CATEGORY_ID,                          \n" +
			"       INVENTORY_ITEM_ID,                             \n" +
			"       PRODUCT_CODE,                                  \n" +
			"       DESCRIPTION,                                   \n" +
			"       UNIT_PRICE,                                    \n" +
			"       CURRENCY_CODE,                                 \n" +
			"       ATTRIBUTE13,                                   \n" +
			"       STATUS                                         \n" +
			"  FROM XXBYP_ITEMS_V";
	
	public static String GET_ITEM_INFO_PRODUCT_CATALOG="  SELECT                                  \n" +
			"       ELEMENT_NAME,                                  \n" +
			"       ELEMENT_VALUE                                      \n" +
			"  FROM XXBYP_ITEMS_V where CATEGORY_ID= ? and INVENTORY_ITEM_ID= ?";
	
	public static String WRITE_SHOPPING_CHART = "{call xxbyp_iklimsa_portal_pkg.write_shopping_chart(?, ?, ?)}";
	
	public static String CALCULATE_CHART_AMOUNT = "{call xxbyp_iklimsa_portal_pkg.calculate_cart_amount(?, ?, ?, ?, ?)}";
	
	public static String CALCULATE_UPDATE_OFFER = "{call xxbyp_iklimsa_portal_pkg.Create_Update_Offer_Prc(?, ?, ?, ?, ?, ?)}";

	public static String CREATE_ORDER = "{call xxbyp_iklimsa_portal_pkg.Create_Order_Prc(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";


}
