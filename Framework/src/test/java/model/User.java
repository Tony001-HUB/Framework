package model;

import java.util.Objects;

public class User
{
    private String username;
    private String userLastName;
    private String userEmail;
    private String userPassword;



    public User(String username, String userLastName, String userEmail, String password) {
        this.username = username;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = password;
    }

    public User(String userEmail, String password) {
        this.userEmail = userEmail;
        this.userPassword = password;
    }


    public String getUserName() { return username; }

    public void setUserName(String username) {
        this.username = username;
    }


    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public String getUserPassword() { return userPassword; }

    public void setPassword(String password) {
        this.userPassword = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + username + '\'' +
                ", lastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(userLastName, user.userLastName) &&
                Objects.equals(userEmail, user.userEmail) &&
                Objects.equals(userPassword, user.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, userLastName, userEmail, userPassword);
    }
}