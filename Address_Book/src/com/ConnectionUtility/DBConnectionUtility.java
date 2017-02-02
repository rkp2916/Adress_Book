package com.ConnectionUtility;

//import java.io.InputStream;
import java.sql.*;
//import java.util.Properties;

public class DBConnectionUtility {
/* private static String driver = "com.mysql.jdbc.Driver";
 private static  String url = "jdbs:mysql://localhost:3306/regist";
 private static String user= "root";
 private static String password = "root";
*/
 private static Connection connection = null;
 
 static String Url = "jdbc:mysql://localhost:3307/rushi";
 static String drv = "com.mysql.jdbc.Driver";
 static String Uname = "root";
  static String pass = "";
 public static Connection getConnection() {
   if(connection != null )
   {
    return connection;
   }
   else
   { 
    try{
    /*Properties property = new Properties();
     InputStream in  =DbConUtility.class.getClassLoader().getResourceAsStream("/db.Properties");
     property.load(in);
     String driver = property.getProperty("driver");
     String url = property.getProperty("url");
     String user = property.getProperty("uesr");
     String password = property.getProperty("password");*/
     Class.forName(drv);
     connection = DriverManager.getConnection(Url, Uname, pass);
    }catch(ClassNotFoundException e)
    {
     e.printStackTrace();
     System.out.println("Error : Connection : " + e);
    } catch (SQLException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
   }
  return connection;
 }
}
