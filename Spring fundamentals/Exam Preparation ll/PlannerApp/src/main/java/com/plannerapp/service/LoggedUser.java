package com.plannerapp.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {

    private String username;
    private boolean isLogged;

    public LoggedUser() {
    }

    //login method
    public void login(String username) {
        this.username = username;
        this.isLogged = true;
    }

    //logout method
    public void logout() {
        this.username = null;
        this.isLogged = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLogged() {
        return isLogged;
    }

//    public void setLogged(boolean logged) {
//        isLogged = logged;
//    }
}
