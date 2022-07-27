package com.planittesting.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.planittesting.model.pages.HomePage;

public class LoginTests extends BaseTest {
    @Test
    public void verifyUserLogin() {
        var homepage = new HomePage(driver)
        .clickLoginMenu()
        .setUserName("someone")
        .setPassword("letmein")
        .clickLoginButton();

        assertEquals("someone", homepage.getCurrentUser());
    }
}
