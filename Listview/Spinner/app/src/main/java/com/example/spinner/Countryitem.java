package com.example.spinner;

public class Countryitem {
    private String mContryname;
    private int mFlagImage;

    public Countryitem(String countryName,int flagimage){
        mContryname = countryName;
        mFlagImage = flagimage;

    }
    public  String getmContryname(){
        return mContryname;

    }
    public int getmFlagImage(){
        return mFlagImage;
    }
}
