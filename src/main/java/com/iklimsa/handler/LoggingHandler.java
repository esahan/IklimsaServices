package com.iklimsa.handler;

import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.iklimsa.db.DbOperation;
import com.iklimsa.log.ServiceLog;
import com.sun.xml.ws.developer.JAXWSProperties;


public class LoggingHandler implements SOAPHandler<SOAPMessageContext> {
	@Override
	public Set<QName> getHeaders() {
		return null;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		log(context);
		return true;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("handleMessage method");
		log(context);
		return true;
	}

	private void log(SOAPMessageContext smc) {
		System.out.println("log method");
		Boolean outboundProperty = (Boolean)smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		try {
			if (!outboundProperty.booleanValue()) {	
				SOAPMessage message = smc.getMessage();
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				message.writeTo(stream);
				
				String endpoint = (String)smc.get(JAXWSProperties.HTTP_REQUEST_URL);
				System.out.println("endpoint:"+endpoint);
				String[] contentTypeArray = message.getMimeHeaders().getHeader("Content-Type"); 
	            String contentType = contentTypeArray[0];
	            System.out.println("contentType:"+contentType);
	            
	            try {
	                SOAPMessage original = smc.getMessage();
	                MimeHeaders mimeheaders = original.getMimeHeaders();
	                MimeHeader mimeheader = null;

	                Iterator<?> iter = mimeheaders.getAllHeaders();

	                for (; iter.hasNext();) {
	                    mimeheader = (MimeHeader) iter.next();

	                    System.out.println("name=" + mimeheader.getName() + ", value="
	                            + mimeheader.getValue());
	                }


	             } catch (Exception e) {
	                 e.printStackTrace();
	             }

	          String contentLength;
	          String[] contentLengthArray= message.getMimeHeaders().getHeader("Content-Length");
	          if(contentLengthArray==null){
	        	  System.out.println("contentLengthArray: null");
	        	  contentLength = "0";
	          }
	          else{
	          contentLength = contentLengthArray[0];}
	            System.out.println("contentLength:"+contentLength);
	            String charset = "";
	            
	            //String charset = (String)smc.get("org.apache.cxf.message.Message.ENCODING");
	          
	            QName values = (QName)smc.get("javax.xml.ws.wsdl.operation");
	            
	            String namespace = values.getNamespaceURI();
	            System.out.println("namespace:"+namespace);
	            String operation = values.getLocalPart();
	            System.out.println("operation:"+operation);
	            
	            QName opn = (QName) smc.get(SOAPMessageContext.WSDL_OPERATION);
	            String requstMethod = (String)opn.getLocalPart();
	            System.out.println("requstMethod:"+requstMethod);
	            String messageId = UUID.randomUUID().toString();
	            System.out.println("messageId:"+messageId);
	            smc.put("MessageId", messageId);
	            
	            ServiceLog log = new ServiceLog();
	            log.setCharset(charset);
	            log.setContentLength(Integer.parseInt(contentLength));
	            log.setContentType(contentType);
	            log.setEndpoint(endpoint);
	            log.setMessageId(messageId);
	            log.setNamespace(namespace);
	            log.setOperation(operation);
	            log.setRequestMethod(requstMethod);
	            log.setRequestXml(stream);
	            DbOperation.writeRequestLog(log);
	            				
			} else {
				SOAPMessage message = smc.getMessage();
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				message.writeTo(stream);
				ServiceLog log = new ServiceLog();
				log.setMessageId((String)smc.get("MessageId"));
				
				
				if (!message.getSOAPPart().getEnvelope().getBody().hasFault()) {
					log.setHasFault(Boolean.FALSE);
				} else {
					log.setHasFault(Boolean.TRUE);
				}
				log.setResponseXml(stream);
				DbOperation.writeResponseLog(log);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.out.println("Exception in handler: " + e);
		}
	}
}
