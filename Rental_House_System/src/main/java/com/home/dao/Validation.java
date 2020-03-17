/*package com.home.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Validation {
	public static boolean checkUser(String un,String pw) {
		boolean st=false;
		try {
			
			template.Query("select un,pw from userRegistration where un=? and pw=?");
		    pst.setString(1,un);
		    pst.setString(2,pw);
		    
		    ResultSet rs=pst.executeQuery();
		    st=rs.next();
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}
*/