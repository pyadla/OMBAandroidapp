package com.OMBAAndroidApp.ItemFiles;


public class SchedTransfer {
  

    private Long id;
    private String customerId;

    private String fromaccount;
    private String toaccount;
    private String amount;    
    private String date;    
    


    // Accessors for the fields. JPA doesn't use these, but your application does.
    public SchedTransfer(String customerId,String fromaccount,String toaccount,String amount,
    		String date)  
    { 
        this.customerId=customerId;  

        this.fromaccount = fromaccount;  
        this.toaccount = toaccount;  
        this.amount = amount;  
        this.date = date;  

    }  

   
    public Long getId() {
		return id;
	}
    public String getCustomerId() {
        return customerId;
    } 
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    } 

	
    public String getFromAccount() {
        return fromaccount;
    } 
    public void setFromAccount(String fromaccount) {
        this.fromaccount = fromaccount;
    } 

    public String getToAccount() {
        return toaccount;
    } 
    public void setToAccount(String toaccount) {
        this.toaccount = toaccount;
    } 
    public String getAmount() {
        return amount;
    } 
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getDate() {
        return date;
    } 
    public void setDate(String date) {
        this.date = date;
    } 
}

