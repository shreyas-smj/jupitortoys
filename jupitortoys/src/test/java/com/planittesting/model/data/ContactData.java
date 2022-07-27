package com.planittesting.model.data;

public record ContactData (
    String forename,
    String surname,
    String email,
    String telephone,
    String message) {
    
}
