package com.OMBAAndroidApp.ItemFiles;

public class Account  
{ 
     
    private String accountNo; 
    private String balance; 
   
    public Account() 
    { 
     this.accountNo = ""; 
     this.balance = "";
   
    } 
   
    public String getAccountNo()  
    { 
        return this.accountNo; 
    } 
    public void setAccountNo(String accountNo)  
    { 
        this.accountNo = accountNo; 
    } 
    public String getBalance()  
    { 
        return this.balance; 
    } 
    public void setBalance(String balance)  
    { 
        this.balance = balance; 
    } 
}