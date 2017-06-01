package com.iklimsa.util;


public class DateConversion {
	public static java.sql.Date getSqlDateFromUtilDate(java.util.Date utilDate) {
		return new java.sql.Date(utilDate.getTime());
	}

	public static java.util.Date getUtilDateFromSqlDate(java.sql.Date sqlDate) {
		return new java.util.Date(sqlDate.getTime());
	}
	

    
    
}
