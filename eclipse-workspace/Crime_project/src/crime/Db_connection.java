
package crime;

import java.sql.*;




public class Db_connection {
 

 private static Connection conn;
 

 public static Connection getConnection() throws ClassNotFoundException, SQLException  {
  if (conn == null) {

	  Class.forName("com.mysql.cj.jdbc.Driver");
	  conn = DriverManager.getConnection("jdbc:mysql://192.168.56.201:3308/madang","dksroch", "dlatjdwO123!");;

	 
		  }
  return conn;
 }
 

 public static void close() {
  try {
   if (conn != null) {
    conn.close();
   }
  }catch(Exception e){
  }
  conn = null;
 }
}














































