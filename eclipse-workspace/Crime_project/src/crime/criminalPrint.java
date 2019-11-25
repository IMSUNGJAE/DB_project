package crime;

import java.util.*;
import java.sql.*;

public class criminalPrint {

	
	 
	 public ArrayList<criminal> list() {
	  ArrayList<criminal> result = new  ArrayList<criminal>();
	  
	  
	  
	  Connection conn = null;
	  Statement stmt = null;
	  
	  try {
	   conn = Db_connection.getConnection();

	   stmt = conn.createStatement();
	  
	   String sql = String.format("SELECT lpart, spart, year, name, age, do_name, si_name, c_number  FROM crimeView ");
	   ResultSet rs = stmt.executeQuery(sql);
	   
	   while(rs.next()) {
	   
	    String lpart = rs.getString("lpart");
	    String spart = rs.getString("spart");
	    String year = rs.getString("year");
	    String name = rs.getString("name");
	    int age = rs.getInt("age");
	    String do_name = rs.getString("do_name");
	    String si_name = rs.getString("si_name");
	    int c_number = rs.getInt("c_number");
	   
	    
	    
	    criminal s = new criminal();
	   
	    s.setName(lpart);
	    s.setSpart(spart);
	    s.setYear(year);
	    s.setName(name);
	    s.setAge(age);
	    s.setDo_name(do_name);
	    s.setSi_name(si_name);
	    s.setC_number(c_number);
	    
	   }
	   
	   rs.close();
	   
	  }catch(Exception e){
	   e.printStackTrace();
	  }finally{
	   try {
	    if (stmt != null) {
	     stmt.close();
	    }
	   }catch(Exception e){
	   }
	   Db_connection.close();
	  }
	  
	  return result;
	 }
	 
	 public int count() {
	  int result = 0;
	  
	  
	  
	  Connection conn = null;
	  PreparedStatement pstmt = null;
	  try {
	   conn = Db_connection.getConnection();  
	   
	   String sql = String.format("SELECT COUNT(*) AS \"count\" FROM crimnial");

	   pstmt = conn.prepareStatement(sql);
	   
	   ResultSet rs = pstmt.executeQuery();
	   
	   while(rs.next()) {
	    result = rs.getInt("count");
	   }
	  
	   rs.close();
	  
	  }catch(Exception e){
	   e.printStackTrace();
	  }finally{
	   try {
	    if (pstmt != null) {
	     pstmt.close();
	    }
	   }catch(Exception e){
	   }
	   
	   Db_connection.close();   
	  }
	  
	  return result;
	 }
	 
	 
	 
	 //범죄자  추가(입력) 메소드
	 public int add(criminal criminial) {
	  int result = 0;
	  
	  
	  
	  Connection conn = null;
	  PreparedStatement pstmt = null;
	  try {
	   conn = Db_connection.getConnection(); 
	  
	   String sql = String.format("INSERT INTO criminal (lpart, spart, year, name, age, do_name, si_name, c_number) VALUES (criminalSeq.nextval, ?, ?, ? ,?, ?, ?, ?)");
	   pstmt = conn.prepareStatement(sql); 
	   
	   pstmt.setString(1, criminal.getLpart()); 
	   pstmt.setString(2, criminal.getSpart()); 
	   result = pstmt.executeUpdate();
	   
	  }catch(Exception e){
	   e.printStackTrace();
	  }finally{
	   try {
	    if (pstmt != null) {
	     pstmt.close();
	    }
	   }catch(Exception e){
	   }
	   
	   Db_connection.close();  
	  }
	  
	  return result;
	 }
}
	 
	 
	 
	 