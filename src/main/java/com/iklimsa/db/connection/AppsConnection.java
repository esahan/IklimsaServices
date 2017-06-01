package com.iklimsa.db.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import oracle.jdbc.OracleConnection;



public class AppsConnection {
	static Logger LOG = Logger.getLogger(AppsConnection.class);	
	public static Connection getConnection() {
		Connection c =null;
        try {
            Context ctx=new InitialContext();
            DataSource ds=(DataSource) ctx.lookup(getDataSourceName());
            c = ds.getConnection();
        } catch (NamingException ex) {
        	LOG.error("Error during NamingException", ex);
        } catch (SQLException ex) {
        	LOG.error("Error during SQLException", ex);
        }
        return c;
	}
	
	public static OracleConnection getOracleConnection() {
		System.out.println("getOracleConnection method");
		Connection c =null;
        try {
            Context ctx=new InitialContext();
            DataSource ds=(DataSource) ctx.lookup(getDataSourceName());
           
            c = ds.getConnection();
        } catch (NamingException ex) {
        	System.out.println("Error during NamingException " +ex);
        	LOG.error("Error during NamingException", ex);
        } catch (SQLException ex) {
        	System.out.println("Error SQLException" +ex);
        	LOG.error("Error during SQLException", ex);
        }
        return (OracleConnection)c;
	}	
	
	private static String getDataSourceName() {
		System.out.println("getDataSourceName method");
		Properties configProp = new Properties();
		InputStream propFis = null;
		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			propFis = (InputStream) classloader.getResourceAsStream("config.properties");
			configProp.load(propFis);
		} catch (Exception e) {
			LOG.error("config.properties cannot be loaded.", e);
		}
		finally {
			if (propFis != null) {
				try {
					propFis.close();
				} catch (IOException e) {
					LOG.error("propFis cannot be closed.", e);
					return null;
				}
			}
		}		
		
		String s = configProp.getProperty("db.datasource");
		System.out.println("datasource "+s);
		
		return s;
	}
}
