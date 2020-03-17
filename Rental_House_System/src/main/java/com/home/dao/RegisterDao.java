package com.home.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.home.model.Login;
import com.home.model.Property;
import com.home.model.Register;



public class RegisterDao {
	
	
JdbcTemplate template; 
	
	public void setTemplate(JdbcTemplate template)
	{    
	    this.template = template;    
	}    
	
	public int save(Register p)
	{    
	    String sql="insert into userRegistration values('"+p.getUname()+"','"+p.getEmail()+"','"+p.getMob()+"','"+p.getPass()+"','"+p.getAddr()+"')";    
	    return template.update(sql);    
	}   
	
	public List<Login> check(Login c)
	{
		
		String sql="select un,pw from userRegistration where un='"+c.getUname()+"' and pw='"+c.getPass()+"'" ;
		return template.query(sql, new RowMapper<Login>() 
		{
		
			public Login mapRow(ResultSet rs, int rowNum) throws SQLException 
			{
				Login l=new Login();
				l.setUname(rs.getString(1));
				l.setPass(rs.getString(2));
				 
				return l;
			}
		});

	}

	public int addprop(Property prop) {
		String sql = "insert into Property (type,rent,address,ownerno,ownername) values('" + prop.getType() + "','" + prop.getRent() + "','" + prop.getAddress() + "','"
				+ prop.getOwnerno() + "','" + prop.getOwnername() + "')";

		return template.update(sql);

	}
	
	public Property getPropertyById(int Id){    
	    String sql="select * from Property where Id=?";    
	    return template.queryForObject(sql, new Object[]{Id},new BeanPropertyRowMapper<Property>(Property.class));    
	}   
	
	public int delete(int Id){    
	    String sql="delete from Property where Id="+Id+"";    
	    return template.update(sql);    
	} 
	
	public int update(Property prop){    
	    String sql="update Property set type='"+prop.getType()+"', rent="+prop.getRent()+",address='"+prop.getAddress()+"' where Id="+prop.getId()+"";    
	    return template.update(sql);    
	} 
	
	
}
