package com.OMBAAndroidApp.ItemFiles;

public class SecurityQuestion  
{ 
     
    private String question; 
    private String answer; 
    public SecurityQuestion() 
    { 
     this.question = ""; 
     this.answer = "";
    } 
   
    public String getQuestion()  
    { 
        return this.question; 
    } 
    public void setQuestion(String question)  
    { 
        this.question = question; 
    } 
  
    public String getAnswer()  
    { 
        return this.answer; 
    } 
    public void setAnswer(String answer)  
    { 
        this.answer = answer; 
    } 
   
}
