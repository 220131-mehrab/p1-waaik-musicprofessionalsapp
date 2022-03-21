package com.revature.waaik.musicprofessionalsapp;

public class Hired {

    private int hId;
    private int uId;

    public Hired(int hId, int uId) {
        this.hId = hId;
        this.uId = uId;
    }

    public Hired() {
    }

    public int gethId() {
        return hId;
    }

    public void sethId() {
        this.hId = hId;

    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "Hired{" +
                "hId=" + hId +
                ", uId=" + uId +
                '}';
    }
}

