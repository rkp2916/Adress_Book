package com.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
//import java.lang.NullPointerException;
import java.util.ArrayList;
//import javax.servlet.http.HttpSession;
import com.ConnectionUtility.DBConnectionUtility;
import com.model.User;
import org.apache.log4j.Logger;


public class UserData {
  private Connection conn ; 
 private static String iduQuery = null;
 static final Logger log = Logger.getLogger(UserData.class);

  public UserData()
  {
   /*System.out.println("USerDao Connertion");*/
   conn  = DBConnectionUtility.getConnection();
   System.out.println("USerDao Connertion   :    " + conn);
  }
 
 public void addUsers(User user )
  {
  log.info("Inserting....");	 
  System.out.println("Befor insert");
   try
    {
      iduQuery = "insert into user (userid, firstname, lastname, dob, address, contactno) values (?,?, ?, ?, ?, ?) ";
     /*System.out.println("insert Query " + iduQuery);*/
     
     PreparedStatement prest = conn.prepareStatement(iduQuery);
     prest.setString(1,user.getUserid());
     prest.setString(2,user.getFirstName());
     prest.setString(3,user.getLastName());
     prest.setDate(4, new java.sql.Date(user.getDob().getTime()));
     prest.setString(5, user.getAddress());
     prest.setString(6, user.getContactNo());
     prest.executeUpdate();
    } catch (Exception e)
     {
      e.printStackTrace();
      System.out.println("Error : ADD USER  :  " + e );
     }
  }
 
 /*public void deleteUser(int userid)
 {
   try
    { 
     iduQuery = "delete from user where userid = ?";
     PreparedStatement prestm = conn.prepareStatement(iduQuery);
      prestm.setInt(1, userid);
      prestm.executeUpdate();
     
    } catch(Exception e)
     {
      e.printStackTrace();
      System.out.println("Error : delete : " + e);
     }
      
 }*/
 
 public void updateUser(User user)
 {
  try
   {
    iduQuery = "update user set firstname=?, lastname=? ,  dob =? , address =?, contactno =?  where UserID = ?  ";
    PreparedStatement pre = conn.prepareStatement(iduQuery);
    pre.setString(1, user.getUserid());
    pre.setString(2, user.getFirstName());
    pre.setString(3 , user.getLastName());
    pre.setDate(4, new java.sql.Date(user.getDob().getTime()));
    pre.setString(5, user.getAddress());
    pre.setString(6, user.getContactNo());
    
    pre.executeUpdate();
   }
  catch(Exception e )
    {
     e.printStackTrace();
     System.out.println("Error : Update : " + e);
    }
 }

 public ArrayList<User> getAllUsers()
 {
  
  ArrayList<User> USER = new ArrayList<User>();
    try
   {
     iduQuery = "select * from user";
     
    Statement st = conn.createStatement();
    ResultSet rs =st.executeQuery(iduQuery);
   
    while(rs.next())
    {
     
     User user =new User();
     
     user.setUserid(rs.getString("UserID"));
     System.out.println("USER ID :    " + user);
     user.setFirstName(rs.getString("firstname"));
     user.setLastName(rs.getString("lastname"));
     user.setDob( new java.sql.Date(rs.getDate("dob").getTime()));
     user.setAddress(rs.getString("address"));
     user.setContactNo(rs.getString("contactno"));
     
     USER.add(user);
    }
    
   }catch(Exception e)
   {
     e.printStackTrace();
     System.out.println("Error : GetALLUSER   " + e);
   }
   return USER;
 }

 public User getUSerById(String UserID)
 {
   User user = new User();
   try
   {
    iduQuery = " select * from user where userid = ?";
    PreparedStatement prestmet = conn.prepareStatement(iduQuery);
    //prestmet.setString(1, UserID);
    ResultSet rs = prestmet.executeQuery();
    if(rs.next())
    {
      user.setUserid(rs.getString("userid"));
      user.setFirstName(rs.getString("firstname"));
      user.setLastName(rs.getString("lastname"));
      user.setDob(rs.getDate("dob"));
      user.setAddress(rs.getString("address"));
      user.setContactNo(rs.getString("contactno"));
    }
  } catch (Exception e)
     {
      e.printStackTrace();
      System.out.println("Error : getUSERByID : " + e);
     }
   return user;
 }
 public int addID()
 {
  int  id = 0 ;
  Statement st =null;
  ResultSet rs = null;
  try{
  // System.out.println("id uis >>>>>");
    st = conn.createStatement();
   String getID = "select userid from user";
  // System.out.println("id uis >>>>>" + getID);
   
    rs = st.executeQuery(getID);
   if(rs.last())
   {
     id =rs.getInt(1);
   }
   id=  id +1;
  // System.out.println("id uis >>>>> " + id);
   
  }catch (Exception  e )
  {
   e.printStackTrace();
  }
  return id; 
 }
}