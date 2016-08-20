package com.example.root.smsreader;

import android.util.Log;

/**
 * Created by root on 17/8/16.
 */
public class SmsAttributes {

    public String sms = "";
    String mydate = "";
    String INR = "";
    String place = "";


    SmsAttributes(String Sms){
    Log.v("Test","SmsAttributes const called...");

    this.sms = Sms;
        Log.v("Test","Func getINR called");

        INR = getINR(sms);
        Log.v("Test","Func getdate called");
        mydate = getDate(sms);
        Log.v("Test","Func getPlace called");
        place = getPlace(sms);

        getdefaultValues(INR, mydate, place);

        DisplayAllValues(INR, mydate, place);
    }




    public  String getINR(String s){
        String inr = "";
        int len=0;
        String inr1="";
        String inr2="";

        try {
            Log.v("Test1", "In func getINR");
Log.v("Test1","Actual Sring is "+s);

            if (s.contains(" INR ")) {
                Log.v("Test1", "String contains INR ");
                len = s.indexOf("INR");
                Log.v("Test1","index of INR is ;"+len);
try {
inr1 = s.substring(s.indexOf("INR"));
    Log.v("Test1","String from INR is "+inr1);

    len = inr1.length();
    Log.v("Test1","Length of INR String  is ;"+len);
    inr1 = s.substring(s.indexOf(" INR ") + 4);
    Log.v("Test1","String from INR is "+inr1);
    inr2 = inr1.substring(inr1.indexOf(" "),inr1.indexOf(".")+3);
    Log.v("Test1","String from space to .  is "+inr2);
    len=inr2.length();
    Log.v("Test1","Length of INR String till . is ;"+len);



   }catch(Exception e){
    e.getMessage();
    Log.v("Test1", "Something went wrong in INR func. ");
    Log.e("Test1", "The error is :"+e.getMessage());

}
                Log.v("Test1", "INR is " + inr);

            } else if (s.contains(" Rs ")) {
                Log.v("Test1", "String contains Rs");

                inr = s.substring(s.indexOf(" Rs ") + 2, s.indexOf(".") + 3);
                Log.v("Test1", "Rs is " + inr);

            } else {

                Log.v("Test1", " String does not contain INR nor Rs keyword");
            }
        }catch (Exception e ){
            e.getMessage();
        }
        Log.v("Test1","returning inr String ;"+inr2);

        return inr2;
    }



    public  String getDate(String s){
        String date="";
        String date1="";
        try {
            Log.v("Test", "In func getDate");

            if (s.contains(" on ")) {
                Log.v("Test", "yea it contains ON keyword");

                date1 = s.substring(s.indexOf(" on ") + 1);

                Log.v("Test", "Date is " + date1);
                try {
                    date = date1.substring(date1.indexOf("n") + 2, date1.indexOf("."));
                    Log.v("Test", " Final date is " + date);

                }catch(Exception e){
                    e.getMessage();
                    Log.v("Test", "Something wrong in Date func....");
                    Log.e("Test", "The error is :" + e.getMessage());

                }

            } else {
                Log.v("Test", " String does not contain ON keyword");

            }
        }catch (Exception e ){
            e.getMessage();
        }
        return date;
    }



    public  String getPlace(String s){
        String place="";
try {
    Log.v("Test", " in getPlace func");
    if (s.contains(" at ")) {

        Log.v("Test", " yes it contains AT keyword");

        place = s.substring(s.indexOf("at") + 2, s.indexOf("at") + 11);

        Log.v("Test", " Place is " + place);
    } else {

        Log.v("Test", " String doesnt contain AT keyword");
    }
}catch (Exception e)
{
    e.getMessage();
}
        return place;
    }



    public  void getdefaultValues( String INR , String Date , String place ){

        if(INR.trim().length()==0){
            INR = "Not Available";
        }
        if(mydate.trim().length()==0 ){
            mydate = "Not Available";
        }
        if(place.trim().length()==0 ){
            place = "Not Available";
        }

    }// end of getDefaultValues func


    public void DisplayAllValues(String INR , String Date , String place){
        Log.v("Test", " INR is :"+ INR);
        Log.v("Test", " Date is :"+ Date);
        Log.v("Test", " place is :"+ place);

    }

}// end of class
