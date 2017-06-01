package com.iklimsa.util;

public class ValidationClass {

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }
    
    public static boolean isValidIfOnlyContainsNumber(String strTobeChecked) {
        String ePattern ="\\d+";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(strTobeChecked);
        return m.matches();
 }
    
    public static boolean isValidPhoneNumber(String phoneNo) {
		
    	String ePattern ="\\(\\d{3}\\)-\\d{3}-\\d{4}";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(phoneNo);
        return m.matches();

	}
	
}
