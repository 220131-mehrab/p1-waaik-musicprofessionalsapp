package com.revature.waaik.musicprofessionalsapp;

public class Pros {

    private int proId;
    private String name;
    private String profession;
    private String email;
    private String phoneNumber;
    private int fee;

    public Pros(int proId, String name, String profession, String email, String phoneNumber, int fee) {
        this.proId = proId;
        this.name = name;
        this.profession = profession;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fee = fee;
    }

   public Pros(){

   }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }




    @Override
    public String toString() {
        return "Pros{" +
                "proId=" + proId +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fee=" + fee +
                '}';
    }
}


