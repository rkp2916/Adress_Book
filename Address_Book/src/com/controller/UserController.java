package com.controller;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/*import java.util.List;*/
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.UserData;
import com.model.User;
/**
 * Servlet implementation class UserController
 */
//@WebServlet("/UserController")
public class UserController extends HttpServlet {
 private static final long serialVersionUID = 1L;
    private static final String  INSERT_OR_EDIT = "/user.jsp";
    private static final String LISTUSER = "/listUser.jsp";
    private UserData userdata;
    public UserController() {
        super();
        userdata = new UserData();
    }
   /* public void init() throws ServletException {
     userdao = new UserDao();
    }*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     System.out.println("THERE is :::::::::::::>>>>>>>>>>>>>>>>>>> in Do Get Method");
     String forward = "";
     String action = request.getParameter("action");
    /* if(action.equalsIgnoreCase("delete"))
      {
       int userid = Integer.parseInt( request.getParameter("userid"));
       //userdao.deleteUser(userid);
       request.setAttribute("users", userdao.getAllUsers());
      }*/
      if (action.equalsIgnoreCase("edit"))
      {
       forward = INSERT_OR_EDIT;
       String userid = request.getParameter("userid");
       User user = new UserData().getUSerById(userid);
       request.setAttribute("users", user);
      }
     else if(action.equalsIgnoreCase("listUser"))
      {
       System.out.println("GET LiSTUSer  >>>>>>>>>>>>");
       forward = LISTUSER ;
       ArrayList<User> myList = new ArrayList<User>();
       myList = userdata.getAllUsers();
       System.out.println("GET LiSTUSer  >>>>>>>>>>>> " + userdata.getAllUsers().size());
       System.out.println("THis List of data arte : " + myList);
       request.setAttribute("users", myList);
     }
      else
      { 
       int userid = userdata.addID();
       System.out.println(" we have got id  "+ userid);
       HttpSession session = request.getSession();
       session.setAttribute("userid",String.valueOf(userid));
       forward = INSERT_OR_EDIT;
      }
      request.getRequestDispatcher(forward).forward(request, response);
 }

 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     System.out.println("THERE is ERRoR: dopost::::>>>>>>>>>>>>>>>>>>> in Do Get Post");

     User user = new User();
     user.setUserid(request.getParameter("userid"));
     /*String fm,ln; 
     fm= request.getParameter("firstName");
     ln = request.getParameter("lastName");
     System.out.println("Firstname  "  + fm);
     System.out.println("lastname  "  + ln);*/
       user.setFirstName(request.getParameter("firstName"));
     user.setLastName(request.getParameter("lastName"));
      try
       {
        Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob")); 
         user.setDob(dob);
        
       } catch(Exception e)
       {
         e.printStackTrace();
       }
      
      user.setAddress(request.getParameter("address"));
      user.setContactNo(request.getParameter("contactno"));
      String userid = request.getParameter("userid");
      
      if(userid == null ||  userid.isEmpty())
      {
        userdata.addUsers(user);
      }
      else
      {
       /*user.setUsrid(userid);
       userdao.updateUSer(user);*/
       userdata.addUsers(user);
      }
     
      RequestDispatcher views = request.getRequestDispatcher(LISTUSER);
      request.setAttribute("users", userdata.getAllUsers());
      views.forward(request, response);
    } 

}
