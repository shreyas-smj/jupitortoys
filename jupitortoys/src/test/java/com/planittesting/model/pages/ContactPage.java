package com.planittesting.model.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
    WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public ContactPage setEmail(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
        return this;
    }
    
    public ContactPage setForeName(String name){
        driver.findElement(By.id("forename")).sendKeys(name);
        return this;
    }

    public ContactPage setMsg(String msg){
        driver.findElement(By.id("message")).sendKeys(msg);
        return this;
    }

    public ContactPage clickSubmitButton() {
        driver.findElement(By.className("btn-contact")).click();
        return this;
    }

    public String getErrorText(String id){
        var elements = driver.findElements(By.id(id));
        if(elements.isEmpty())
            return "";
            return elements.get(0).getText();
    }

    public String getForeNameError() {
        return driver.findElement(By.id( "forename-err")).getText();
    }

    public String getMsgError() {
        return driver.findElement(By.id( "message-err")).getText();
    }
    
    public String getEmailError() {
        return driver.findElement(By.id( "email-err")).getText();
    }

    public String getSuccessMessage() {
        return new WebDriverWait(driver,Duration.ofSeconds(60))
            .until(d -> d.findElement(By.className("alert-success"))).getText();
    }


}
