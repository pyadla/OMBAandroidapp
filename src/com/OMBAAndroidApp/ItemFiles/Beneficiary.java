package com.OMBAAndroidApp.ItemFiles;

public class Beneficiary {
	
	private String accountNo; 
    private String name; 
    private String bankCode;
   
    public Beneficiary() 
    { 
     this.accountNo = ""; 
     this.name = ""; 
     this.bankCode = "";
   
    } 
   
    public String getAccountNo()  
    { 
        return this.accountNo; 
    } 
    public void setAccountNo(String accountNo)  
    { 
        this.accountNo = accountNo; 
    } 
    public String getName()  
    { 
        return this.name; 
    } 
    public void setName(String name)  
    { 
        this.name = name; 
    } 
    public String getBankCode()  
    { 
        return this.bankCode; 
    } 
    public void setBankCode(String bankCode)  
    { 
        this.bankCode = bankCode; 
    } 
}
