package com.login.login.service;

public interface SecurityService { // skapar SecurityService för att tillhandahålla aktuell inloggad användare
    boolean isAuthenticated();
}
