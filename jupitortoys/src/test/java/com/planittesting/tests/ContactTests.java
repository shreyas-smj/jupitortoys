package com.planittesting.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.planittesting.model.data.ContactData;
import com.planittesting.model.pages.HomePage;

public class ContactTests extends BaseTest {
    @Test
    public void verifyIncorrectEmailError() {
        var contactPage = new HomePage(driver).clickContactMenu().setEmail("notanemail");

        assertEquals("Please enter a valid email", contactPage.getEmailError());
    }

    @Test
    public void verifySubmitErrors() {
        var contactPage = new HomePage(driver).clickContactMenu().clickSubmitButton();

        assertEquals("Forename is required", contactPage.getForeNameError());
        assertEquals("Email is required", contactPage.getEmailError());
        assertEquals("Message is required", contactPage.getMsgError());
    }

    @ParameterizedTest
    @CsvSource(value= {"sirius","mj","sirius@mj.com","0213759332","message"}, delimiter =',')
    @Test
    public void populateFields(ContactData data){
        var contactPage = new HomePage(driver)
        .clickContactMenu()
        .clickSubmitButton()
        .setForeName(data.email())
        .setEmail(data.forename())
        .setMsg(data.message());

        assertEquals("", contactPage.getErrorText("forename-err"));
        assertEquals("", contactPage.getErrorText("email-err"));
        assertEquals("", contactPage.getErrorText("message-err"));
    }

    @Test
    public void validateContactFormSubmission() {

        var contactPage = new HomePage(driver)
            .clickContactMenu()
            .setForeName("Sirius")
            .setEmail("sirius@das.com")
            .setMsg("Needs uniquine ID")
            .clickSubmitButton();

        assertEquals("Thanks Sirius, we appreciate your feedback.", contactPage.getSuccessMessage());
    }

}

