package com.OMBAAndroidApp.ItemFiles;

public class Transaction {

	private String date; 
    private String toFrom; 
    private String amount; 
    private String description; 
    private String balance;
   
   
    public Transaction() 
    { 
     this.date = ""; 
     this.toFrom = "";
     this.amount = ""; 
     this.description = "";
     this.balance="";
   
    } 
   
    public String getDate()  
    { 
        return this.date; 
    } 
    public void setDate(String date)  
    { 
        this.date = date; 
    } 
    public String getToFrom()  
    { 
        return this.toFrom; 
    } 
    public void setToFrom(String toFrom)  
    { 
        this.toFrom = toFrom; 
    } 
    public String getAmount()  
    { 
        return this.amount; 
    } 
    public void setAmount(String amount)  
    { 
        this.amount = amount; 
    } 
    public String getDescription()  
    { 
        return this.description; 
    } 
    public void setDescription(String description)  
    { 
        this.description = description; 
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
