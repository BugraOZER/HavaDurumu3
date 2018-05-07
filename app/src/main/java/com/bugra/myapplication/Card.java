package com.bugra.myapplication;


public class Card {
  //  private int mImageResource;
    private String mcity;
    private String mdesc;
    private String mtemp;


   /* public int getmImageResource() {
        return mImageResource;
    }*/

    public String getMcity() {
        return mcity;
    }

    public String getMdesc() {
        return mdesc;
    }

    public String getMtemp() {
        return mtemp;
    }

    public Card( String city, String desc, String  temp) {
       // mImageResource = imageResource;
        mcity = city;
        mdesc = desc;
        mtemp = temp;

    }


}


