package com.planittesting.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.planittesting.model.components.LoginDialog;

public class BasePage<CurrentPage extends BasePage<CurrentPage>> {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public ContactPage clickContactMenu() {
    driver.findElement(By.cssSelector( "#nav-contact a")).click();
    return new ContactPage(driver);
    }

    @SuppressWarnings("unchecked")
    public LoginDialog<CurrentPage> clickLoginMenu() {
        driver.findElement(By.cssSelector("#nav-login a")).click();
        return new LoginDialog<CurrentPage>(
            driver.findElement(By.className("popup")),(CurrentPage) this);
    }
    
    public String getCurrentUser(){
        return driver.findElement(By.className("user")).getText();
    }

}
