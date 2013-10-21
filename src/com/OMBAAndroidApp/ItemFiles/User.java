package com.OMBAAndroidApp.ItemFiles;

public class User  
{ 
    private String status; 
    private String customerId; 
    private String customerName; 
    private String gender;
    private String password;
    
    public User() 
    {
     this.status="";
     this.customerId = ""; 
     this.customerName = "";
     this.gender="";
     this.password = "";
    } 
   
    public String getStatus()  
    { 
        return this.status; 
    } 
    public void setStatus(String status)  
    { 
        this.status = status; 
    } 
    public String getCustomerId()  
    { 
        return this.customerId; 
    } 
    public void setCustomerId(String customerId)  
    { 
        this.customerId = customerId; 
    } 
    public String getCustomerName()  
    { 
        return this.customerName; 
    } 
    public void setCustomerName(String customerName)  
    { 
        this.customerName = customerName; 
    }
    public String getGender()  
    { 
        return this.gender; 
    } 
    public void setGender(String gender)  
    { 
        this.gender = gender; 
    }
    public String getPassword()  
    { 
        return this.password; 
    } 
    public void setPassword(String password)  
    { 
        this.password = password; 
    }   
}  