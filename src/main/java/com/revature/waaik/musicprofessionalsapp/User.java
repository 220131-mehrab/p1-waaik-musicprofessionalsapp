package com.revature.waaik.musicprofessionalsapp;

public class User {

    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private int userCreditCard;
    private int userPick;

    public User(int userId, String userName, String userEmail, String userPassword, int userCreditCard, int userPick) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userCreditCard = userCreditCard;
        this.userPick = userPick;
    }

    public User(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserCreditCard() {
        return userCreditCard;
    }

    public void setUserCreditCard(int userCreditCard) {
        this.userCreditCard = userCreditCard;
    }

    public int getUserPick(){return userPick;}

    public void setUserPick(int userPick){this.userPick = userPick;}


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userCreditCard=" + userCreditCard + '\'' +
                ", userPick=" + userPick +
                '}';
    }
}


