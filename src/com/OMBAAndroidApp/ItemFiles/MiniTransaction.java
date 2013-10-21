package com.OMBAAndroidApp.ItemFiles;

public class MiniTransaction { 
	 
	    private String date; 
	    private String amount; 
	    private String desc; 
	   
	    public MiniTransaction() 
	    { 
	     this.date = ""; 
	     this.amount = "";
	     this.desc = "";	   
	    } 
	   
	    public String getDate()  
	    { 
	        return this.date; 
	    } 
	    public void setDate(String date)  
	    { 
	        this.date = date; 
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
	        return this.desc; 
	    } 
	    public void setDescription(String desc)  
	    { 
	        this.desc = desc; 
	    } 	   
	}
