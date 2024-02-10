package com.example.form;

public class StudentModel {
    public String Fullname;

    public  String FullAdreess;

    public Integer Date;

    public  String Username;

    public String pincode;

    public String email;

    public String  number ;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return Username;
    }

    public String setUsername(String username) {
        Username = username;
        return username;
    }

    public Integer getDate() {

        return Date;
    }

    public int setDate(int date) {
        Date = date;
        return date;
    }

    public String getFullAdreess() {
        return FullAdreess;
    }

    public String setFullAdreess(String fullAdreess) {
        FullAdreess = fullAdreess;
        return fullAdreess;
    }

    public String getFullname() {
        return Fullname;
    }

    public String setFullname(String fullname) {
        Fullname = fullname;
        return fullname;
    }
}
