package crime;

import java.sql.*;
import java.util.Scanner;

import java.sql.ResultSet;


public class Db_connection{
	
	public static void main(String args[]) {
		search();
	}
	
    private static void search() {
	
	
	Connection con = null;
	Statement stmt = null;
	
	
	int r = 0;
	

	try{

		Class.forName("com.mysql.cj.jdbc.Driver");

        con =DriverManager.getConnection("jdbc:mysql://192.168.56.101:3308/crimedb","dksroch","dlatjdwO123!");

        
 
    	Scanner scan = new Scanner(System.in,"euc-kr");
    	
    	
    	System.out.print("1.입력 2.수정.3.검색 4.삭제 :");
    	int num = Integer.parseInt(scan.nextLine());
    	
    	
    	if(num==1) {
    		System.out.print("C_id:");
    		int C_id = Integer.parseInt(scan.nextLine());
    	
    		System.out.print("Fname:");
    		String Fname = scan.nextLine();
    	
    		System.out.print("Lname:");
    		String Lname = scan.nextLine();
    	
    		System.out.print("Address:");
    		String Address = scan.nextLine();
    	
    		System.out.print("Gender:");
    		String Gender = scan.nextLine();
    	
    		System.out.print("Kind:");
    		String Kind = scan.nextLine();
    		
    		System.out.print("Period:");
    		String Period = scan.nextLine();
    		
    		System.out.print("M_id:");
    		int M_id = Integer.parseInt(scan.nextLine());
    	
    	
    		stmt = con.createStatement();
    	
    		r = stmt.executeUpdate("insert into Criminal" + "(C_id,Fname,Lname,Address,Gender,Kind,Period,M_id) value('"+
    		C_id+"','" +Fname+"','"+Lname+"', '"+Address+"','"+Gender+"','"+Kind+"','"+Period+"','" +M_id+"')");
    		
    		if(r==1) {
    			
    			System.out.println("입력완료 ");
    		}
    		else {
    			System.out.println("입력실패 ");
    		}
    	
    	System.out.println("");
    	search();
    	
    	}else if(num==2) {
    		
    		System.out.println("수정항목: 1번 -> Criminal / 2번 -> Manager / 3번 -> Prison / 4번 -> Prison_location / 5번 -> Works");
    	    int n = Integer.parseInt(scan.nextLine());
    	    
    	    switch(n) {
    	    
    	    
    	    case 1: 
    	    	
    	    	System.out.print("수정항목(예시:C_id=?): ");
    	       String da = scan.nextLine();
    	        
    	    	System.out.print("수정 내용: ");
    	        String ea = scan.nextLine();
    	        
    	        stmt = con.createStatement();
    	        r= stmt.executeUpdate("update Criminal set " + ea + "where "+da);
    	    	
    	    if(r==0) {
    	    	System.out.println("데이터가 없습니다.");
    	    }
    	    else {
    	    	System.out.println("수정완료 ");
    	    }
    	    System.out.print("");
    	    search();
    	    
    	    break;
    	    
    	    
    	    case 2: 
    	    	System.out.print("수정항목(예시:C_id=?): ");
    	        int ea1 = Integer.parseInt(scan.nextLine());
    	        
    	    	System.out.print("수정내용: ");
    	        String da1 = scan.nextLine();
    	        
    	        stmt = con.createStatement();
    	        r= stmt.executeUpdate("update Manager set " + ea1 + "where " +da1);
    	    	
    	    if(r==0) {
    	    	System.out.println("데이터가 없습니다.");
    	    }
    	    else {
    	    	System.out.println("수정완료 ");
    	    }
    	    System.out.print("");
    	    search();
    	    
    	    break;
    	    
    	    case 3: 
    	    	System.out.print("수정할항목(예시:C_id=?): ");
    	        int ea2 = Integer.parseInt(scan.nextLine());
    	        
    	    	System.out.print("수정내용: ");
    	        String da2 = scan.nextLine();
    	        
    	        stmt = con.createStatement();
    	        r= stmt.executeUpdate("update Prison set " + ea2 + "where " +da2);
    	    	
    	    if(r==0) {
    	    	System.out.println("데이터가 없습니다.");
    	    }
    	    else {
    	    	System.out.println("수정완료 ");
    	    }
    	    System.out.print("");
    	    search();
    	    
    	    break;
    	    
    	    case 4: 
    	    	System.out.print("수정항목(예시:C_id=?): ");
    	        int ea3 = Integer.parseInt(scan.nextLine());
    	        
    	    	System.out.print("수정내용: ");
    	        String da3 = scan.nextLine();
    	        
    	        stmt = con.createStatement();
    	        r= stmt.executeUpdate("update Prison_location set " + ea3 + "where "+ da3);
    	    	
    	    if(r==0) {
    	    	System.out.println("데이터가 없습니다.");
    	    }
    	    else {
    	    	System.out.println("수정완료 ");
    	    }
    	    System.out.print("");
    	    search();
    	    
    	    break;
    	    
    	    case 5: 
    	    	System.out.print("수정항목(예시:C_id=?): ");
    	        int ea4 = Integer.parseInt(scan.nextLine());
    	        
    	    	System.out.print("수정내용: ");
    	        String da4 = scan.nextLine();
    	        
    	        stmt = con.createStatement();
    	        r= stmt.executeUpdate("update Works set" + ea4 + "where" +da4);
    	    	
    	    if(r==0) {
    	    	System.out.println("데이터가 없습니다.");
    	    }
    	    else {
    	    	System.out.println("수정완료 ");
    	    }
    	    System.out.print("");
    	    search();
    	    
    	    break;
    	    
    	    
    	    }
    	    
    	}
    	
    	 con.close();
    	 
	}catch(Exception e) {
		System.out.println(e);
	}
	
	
    }
}
    	
    	
    	
		
		
		
		
		














































