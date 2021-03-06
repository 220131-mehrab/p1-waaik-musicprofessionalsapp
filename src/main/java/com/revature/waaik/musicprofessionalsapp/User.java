package com.revature.waaik.musicprofessionalsapp;

public class User {
    private static int count = 1;
    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private long userCreditCard;
   // private int userPick;

    public User(int userId, String userName, String userEmail, String userPassword, long userCreditCard) {
        this.userId = count++;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userCreditCard = userCreditCard;
       // this.userPick = userPick;
    }

    public User(){

    }

    public int getUserId() {
        return userId;
    }

    public int setUserId(int userId) {
        this.userId = userId;
        return userId;
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

    public long getUserCreditCard() {
        return userCreditCard;
    }

    public void setUserCreditCard(long userCreditCard) {
        this.userCreditCard = userCreditCard;
    }

    //public int getUserPick(){return userPick;}

    //public void setUserPick(int userPick){this.userPick = userPick;}


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userCreditCard=" + userCreditCard + '\'' +
                '}';
    }
}


