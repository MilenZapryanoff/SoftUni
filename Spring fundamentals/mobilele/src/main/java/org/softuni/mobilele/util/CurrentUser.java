package org.softuni.mobilele.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("currentUser")
@SessionScope
public class CurrentUser {

    private String firstName;
    private String lastName;
    private boolean isLogged;

    public CurrentUser() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        StringBuilder stringBuilder = new StringBuilder();

        if (!firstName.isEmpty()) {
            stringBuilder.append(firstName);
        }
        if (!lastName.isEmpty()) {
            if (!stringBuilder.isEmpty()) {
                stringBuilder.append(" ").append(lastName);
            } else {
                stringBuilder.append(lastName);
            }
        }
        return stringBuilder.toString();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public void logOut() {
        setLogged(false);
        setFirstName(null);
        setLastName(null);
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isLogged=" + isLogged +
                '}';
    }
}
