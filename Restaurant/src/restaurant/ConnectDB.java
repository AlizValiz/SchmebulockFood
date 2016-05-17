
package restaurant;

import java.sql.*;
/**
 *
 * @author Alejandro D
 */
public class ConnectDB {
    
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/orders";
   
   //  Database credentials
   static final String USER = "admin";
   static final String PASS = "admin";
   
   public static Connection getConnection() {
       
   Connection conn = null;
   try{

      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("Conectando a base de datos...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(conn==null){
             System.out.println("No se realizo correctamebte la conexion a la BD");
            conn.close();
         }   
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   
   return conn;
}
}
