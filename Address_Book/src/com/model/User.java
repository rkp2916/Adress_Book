package com.model;

import java.util.Date;;

public class User {
 private String userid;
 private String firstName;
 private String lastName;
 private Date dob;
 private String address;
 private String contactNo;

 public String getUserid() {
   
  return userid;
 }
 public void setUserid(String userid) {
  
  this.userid = userid;
  System.out.println("The userid " +  this.userid);
 }
 
 public String getFirstName() {
  return firstName;
 }
 
 public void setFirstName(String firstName) {
  this.firstName = firstName;
  //System.out.println("The Firstname " +  this.firstName);
 }
 /**
  * @return the dob
  */
 public Date getDob() {
  return dob;
 }
 /**
  * @param dob the dob to set
  */
 public void setDob(Date dob) {
  this.dob = dob;
 }
 /**
  * @return the email
  */
 public String getAddress() {
  return address;
 }
 
 public void setAddress(String address) {
  this.address = address;
 }
 
 public String getLastName() {
  return lastName;
 }
 
 public void setLastName(String lastName) {
  
  this.lastName = lastName;

 }
 
 public String getContactNo()
 {
	 return contactNo;
 }	
 
 public void setContactNo(String contactNo)
 {
	 this.contactNo= contactNo;
 }
 
 @Override
    public String toString() {
        return "User [userid= " + userid + ", firstName= " + firstName
                + ", lastName=" + lastName + ", dob=" + dob + ", Address="
                + address + "Contactno="+ contactNo +"]";
    }    
}
