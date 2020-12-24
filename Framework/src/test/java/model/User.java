package model;

import java.util.Objects;

public class User
{
    private String userName;
    private String userLastName;
    private String userEmail;
    private String userPassword;



    public User(String userName, String userLastName, String userEmail, String password) {
        this.userName = userName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = password;
    }

    public User(String userEmail, String password) {
        this.userEmail = userEmail;
        this.userPassword = password;
    }


    public String getUserName() { return userName; }

    public void setUserName(String username) {
        this.userName = username;
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
                "userName='" + userName + '\'' +
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
        return Objects.equals(userName, user.userName) &&
                Objects.equals(userLastName, user.userLastName) &&
                Objects.equals(userEmail, user.userEmail) &&
                Objects.equals(userPassword, user.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userLastName, userEmail, userPassword);
    }
}