package com.OMBAAndroidApp.ItemFiles;

public class CustomerDetails  
{ 
     
    private String phoneno; 
    private String address;
    private String email;
    public CustomerDetails() 
    { 
     this.phoneno = ""; 
     this.address = "";
     this.email = "";
    } 
   
    public String getPhoneno()  
    { 
        return this.phoneno; 
    } 
    public void setPhoneno(String phoneno)  
    { 
        this.phoneno = phoneno; 
    } 
  
    public String getAddress()  
    { 
        return this.address; 
    } 
    public void setAddress(String address)  
    { 
        this.address = address; 
    }

    public String getEmail()  
    { 
        return this.email; 
    } 
    public void setEmail(String email)  
    { 
        this.email = email; 
    } 
  
   
}
