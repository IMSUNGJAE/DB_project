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
	ResultSet rs = null;
	
     int r = 0;
	

	try{

		Class.forName("com.mysql.cj.jdbc.Driver");

        con =DriverManager.getConnection("jdbc:mysql://192.168.56.101:3308/crimedb","dksroch","dlatjdwO123!");

        
 
    	Scanner scan = new Scanner(System.in,"euc-kr");
    	
    	
    	System.out.print("1.입력 2.수정.3.검색 4.삭제 :");
    	int num = Integer.parseInt(scan.nextLine());
    	
    	
    	
    	
    	if(num==1) {
    		
    	    System.out.println("수정항목: 1번 Criminal / 2번 Manager / 3번 Prison ");
    	    System.out.println("        4번 Prison_location / 5번 Works");
    	    
    	    int n = Integer.parseInt(scan.nextLine());
    	  
    	    switch(n) {//
    		
    	    case 1:
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
    	
    	
    	break;
    	
           case 2:
        	    System.out.print("M_id:");
        		int M_id2 = Integer.parseInt(scan.nextLine());
        	
        		System.out.print("Name:");
        		String Name = scan.nextLine();
        	
        		System.out.print("Kind:");
        		String Kind2 = scan.nextLine();
        	
        	    stmt = con.createStatement();
        	
        		r = stmt.executeUpdate("insert into Manage" + "(M_id,Name,Kind) value('"+M_id2+"','" +Name+"','"+Kind2+"')");
        		
        		if(r==1) {
        			
        			System.out.println("입력완료 ");
        		}
        		else {
        			System.out.println("입력실패 ");
        		}
        	
        	System.out.println("");
        	search();
        	
        	
        	
    	    case 3:
        	    System.out.print("P_id:");
        		int P_id = Integer.parseInt(scan.nextLine());
        	
        		System.out.print("Name:");
        		String Name2 = scan.nextLine();
        	
        		System.out.print("In_number:");
        		int In_number = Integer.parseInt(scan.nextLine());
        	
        		System.out.print("S_M_id:");
        		int S_M_id = Integer.parseInt(scan.nextLine());
        	 
        		
        	
        	
        		stmt = con.createStatement();
        	
        		r = stmt.executeUpdate("insert into Prison" + "(P_id,Name,In_number,S_M_id) value('"+
        		P_id+"','" +Name2+"','"+In_number+"', '"+S_M_id+"')");
        		
        		if(r==1) {
        			
        			System.out.println("입력완료 ");
        		}
        		else {
        			System.out.println("입력실패 ");
        		}
        	
        	System.out.println("");
        	search();
        	
        	
        	
    	    case 4:
        	    System.out.print("P_id:");
        		int P_id2 = Integer.parseInt(scan.nextLine());
        	
        		System.out.print("Prison_location:");
        		String Prison_location = scan.nextLine();
        	
        		
        	
        	
        		stmt = con.createStatement();
        	
        		r = stmt.executeUpdate("insert into Prison_location" + "(P_id,Prison_location) value('"+
        		P_id2+"','" +Prison_location+"')");
        		
        		if(r==1) {
        			
        			System.out.println("입력완료 ");
        		}
        		else {
        			System.out.println("입력실패 ");
        		}
        	
        	System.out.println("");
        	search();
        	
        	
        	
    	    case 5:
        	    System.out.print("P_id:");
        		int P_id3 = Integer.parseInt(scan.nextLine());
        	
        		
        		System.out.print("C_id:");
        		int C_id3 = Integer.parseInt(scan.nextLine());
        		
        		System.out.print("Hours:");
        		int Hours = Integer.parseInt(scan.nextLine());
        	
        	
        		stmt = con.createStatement();
        	
        		r = stmt.executeUpdate("insert into Works" + "(P_id,C_id,Hours) value('"+P_id3+"','" +C_id3+"','"+Hours+"')");
        		
        		if(r==1) {
        			
        			System.out.println("입력완료 ");
        		}
        		else {
        			System.out.println("입력실패 ");
        		}
        	
        	System.out.println("");
        	search();
        	
    	
    	
    	
    	    }//
    	
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
    	    
    	}else if(num==3){
    	    
    		System.out.println("검색 항목: 1번 -> Criminal / 2번 -> Manager / 3번 -> Prison / 4번 -> Prison_location / 5번 -> Works");
    	    int n = Integer.parseInt(scan.nextLine());
    		
    	
    	    switch(n) {
    	    case 1:
    	    System.out.print("검색항목(C_id): ");
    	    String en = scan.nextLine();
    	    
    	    System.out.print(en+ "를(을) 입력해주세요. :  ");
    	    String dn = scan.nextLine();
    	    
    	    stmt = con.createStatement();
    	    rs = stmt.executeQuery("select * from Criminal where " + en + " like '%" + dn + "%' ");
    	    
    	    
    	    if(rs == null) System.out.println("해당 내용을 찾을 수 없습니다. ");
    	    
    	   while(rs.next()) {
    		   
    		   int C_id = rs.getInt("C_id");
    		   String Fname = rs.getString("Fname");
    	       String Lname = rs.getString("Lname");
    	       String Address = rs.getString("Address");
    	       String Gender = rs.getString("Gender");
    	       String Kind = rs.getString("Kind");
    	       String Period = rs.getString("Period");
    	       int M_id = rs.getInt("M_id");
    	       
    	       System.out.printf("%d %s %s %s %s %s %s %d",C_id,Fname,Lname,Address,Gender,Kind,Period,M_id);
    	       System.out.println("");
    	  
    	   }
    	   
    	   break;
    	   
    	    case 2:
        	    System.out.print("검색항목M_id): ");
        	    String en1 = scan.nextLine();
        	    
        	    System.out.print(en1+ "를(을) 입력해주세요. :  ");
        	    String dn1 = scan.nextLine();
        	    
        	    stmt = con.createStatement();
        	    rs = stmt.executeQuery("select * from Manager where " + en1 + " like '%" + dn1 + "%' ");
        	    
        	    
        	    if(rs == null) System.out.println("해당 내용을 찾을 수 없습니다. ");
        	    
        	   while(rs.next()) {
        		   
        		   int M_id = rs.getInt("M_id");
        		   String Name = rs.getString("Name");
        	       String M_kind = rs.getString("M_Kind");
        	      
        	       System.out.printf("%d %s %s",M_id,Name,M_kind);
        	       System.out.println("");
        	  
        	   }
        	   
        	   break;
        	   
        	   
    	    case 3:
        	    System.out.print("검색항목(P_id): ");
        	    String en2 = scan.nextLine();
        	    
        	    System.out.print(en2+ "를(을) 입력해주세요. :  ");
        	    String dn2 = scan.nextLine();
        	    
        	    stmt = con.createStatement();
        	    rs = stmt.executeQuery("select * from Prison where " + en2 + " like '%" + dn2 + "%' ");
        	    
        	    
        	    if(rs == null) System.out.println("해당 내용을 찾을 수 없습니다. ");
        	    
        	   while(rs.next()) {
        		   
        		   int P_id = rs.getInt("P_id");
        		   String Name = rs.getString("Name");
        	       String In_number = rs.getString("In_number");
        	       String S_M_id = rs.getString("S_M_id");
        	       
        	       
        	       System.out.printf("%d %s %s %s %d",P_id,Name,In_number,S_M_id);
        	       System.out.println("");
        	  
        	   }
        	   
        	   break;
        	   
    	    case 4:
        	    System.out.print("검색항목(P_id): ");
        	    String en3 = scan.nextLine();
        	    
        	    System.out.print(en3+ "를(을) 입력해주세요. :  ");
        	    String dn3 = scan.nextLine();
        	    
        	    stmt = con.createStatement();
        	    rs = stmt.executeQuery("select * from Prsion_location where " + en3 + " like '%" + dn3 + "%' ");
        	    
        	    
        	    if(rs == null) System.out.println("해당 내용을 찾을 수 없습니다. ");
        	    
        	   while(rs.next()) {
        		   
        		   int P_id = rs.getInt("P_id");
        		   String Prison_location = rs.getString("Prison_location");
        	       
        	       
        	       System.out.printf("%d %s",P_id,Prison_location);
        	       System.out.println("");
        	  
        	   }
        	   
        	   break;
        	   
    	    case 5:
        	    System.out.print("검색항목(P_id): ");
        	    String en4 = scan.nextLine();
        	    
        	    System.out.print(en4+ "를(을) 입력해주세요. :  ");
        	    String dn4 = scan.nextLine();
        	    
        	    stmt = con.createStatement();
        	    rs = stmt.executeQuery("select * from Works where " + en4 + " like '%" + dn4 + "%' ");
        	    
        	    
        	    if(rs == null) System.out.println("해당 내용을 찾을 수 없습니다. ");
        	    
        	   while(rs.next()) {
        		   
        		   int P_id = rs.getInt("P_id");
        	
        	       int C_id = rs.getInt("C_id");
        	       
        	       int Hours= rs.getInt("Hours");
        	       
        	       System.out.printf("%d %d %d",P_id,C_id,Hours);
        	       System.out.println("");
        	  
        	   }
        	   
        	   break;
    	   
    	   
    	   
    	    }
    	    
    	    
    	}else if(num == 4) {
    	    	
    		
    		System.out.println("삭제 항목: 1번 -> Criminal / 2번 -> Manager / 3번 -> Prison / 4번 -> Prison_location / 5번 -> Works");
    	    int n = Integer.parseInt(scan.nextLine());
    		
          switch(n) {//
    		
          case 1:
        	  System.out.print("삭제할 내용: ");
    	        String cn = scan.nextLine();
    	        
    	        stmt = con.createStatement();
    	        r= stmt.executeUpdate("delete from Criminal where " + cn);
    	        
    	        if(r ==0) {
    	        	System.out.println("삭제할 내용을 찾을 수 없습니다.");
    	        	
    	        }else {
    	        	System.out.println("삭제완료!");
    	        }
    	        
    	        System.out.println("");
    	        search();
    	        
    	        
    	        break;
    	        
    	        
    	        
    	        
          case 2:
        	  System.out.print("삭제할 내용: ");
    	        String cn1 = scan.nextLine();
    	        
    	        stmt = con.createStatement();
    	        r= stmt.executeUpdate("delete from Manage where " +cn1);
    	        
    	        if(r ==0) {
    	        	System.out.println("삭제할 내용을 찾을 수 없습니다.");
    	        	
    	        }else {
    	        	System.out.println("삭제완료!");
    	        }
    	        
    	        System.out.println("");
    	        search();
    	        
    	        
    	        break;
    	        
    	        
          case 3:
        	  System.out.print("삭제할 내용: ");
    	        String cn2 = scan.nextLine();
    	        
    	        stmt = con.createStatement();
    	        r= stmt.executeUpdate("delete from Prison where " +cn2);
    	        
    	        if(r ==0) {
    	        	System.out.println("삭제할 내용을 찾을 수 없습니다.");
    	        	
    	        }else {
    	        	System.out.println("삭제완료!");
    	        }
    	        
    	        System.out.println("");
    	        search();
    	        
    	        
    	        break;
    	        
    	        
          case 4:
        	  System.out.print("삭제할 내용: ");
    	        String cn3 = scan.nextLine();
    	        
    	        stmt = con.createStatement();
    	        r= stmt.executeUpdate("delete from Prison_location where " +cn3);
    	        
    	        if(r ==0) {
    	        	System.out.println("삭제할 내용을 찾을 수 없습니다.");
    	        	
    	        }else {
    	        	System.out.println("삭제완료!");
    	        }
    	        
    	        System.out.println("");
    	        search();
    	        
    	        
    	        break;
    	        
          case 5:
        	  System.out.print("삭제할 내용: ");
    	        String cn4 = scan.nextLine();
    	        
    	        stmt = con.createStatement();
    	        r= stmt.executeUpdate("delete from Works where " +cn4);
    	        
    	        if(r ==0) {
    	        	System.out.println("삭제할 내용을 찾을 수 없습니다.");
    	        	
    	        }else {
    	        	System.out.println("삭제완료!");
    	        }
    	        
    	        System.out.println("");
    	        search();
    	        
    	        
    	        break;
    	        
    	        
    	        
    	    	
    	    }//
    	   
    
    	 con.close();
    	}
    	
	}catch(Exception e) {
		System.out.println(e);
	}
	
	
    }
}
    	
    	
    	
		
		
		
		
		














































