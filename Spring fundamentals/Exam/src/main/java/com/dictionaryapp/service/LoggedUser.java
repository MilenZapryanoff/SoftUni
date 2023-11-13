package com.dictionaryapp.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {

    private String username;
    private boolean isLogged;

    public LoggedUser() {
    }

    /**
     * LOGIN method
     */
    public void login(String username) {
        this.username = username;
        this.isLogged = true;
    }

    /**
     * LOGOUT method
     */
    public void logout() {
        this.username = null;
        this.isLogged = false;
    }

    /**
     * Login check
     *
     * @return true or false
     */
    public boolean isLogged() {
        return isLogged;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
