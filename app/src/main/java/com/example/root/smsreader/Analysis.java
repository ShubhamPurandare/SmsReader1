package com.example.root.smsreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

public class Analysis extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Log.v("Test", "In Analysis class.....");
try {
    Intent intent = getIntent();
   // SmsAttributes s2 = (SmsAttributes)intent.getP("key");
    int l1 = intent.getIntExtra("key",0);
    int number_tvs = (l1*3)+4;
    Log.v("Test", number_tvs + " text views will be created now ");



    TextView[] textViews = new TextView[number_tvs];

    Log.v("Test", "Tv array initialized.......");

        textViews[0] = (TextView)findViewById(R.id.textView1);
        textViews[1] = (TextView)findViewById(R.id.textView12);
        textViews[2]= (TextView)findViewById(R.id.textView3);
        textViews[3]= (TextView)findViewById(R.id.textView4);
        textViews[4]= (TextView)findViewById(R.id.textView5);
        textViews[5]= (TextView)findViewById(R.id.textView6);
        textViews[6]= (TextView)findViewById(R.id.textView7);
        textViews[7]= (TextView)findViewById(R.id.textView8);
        textViews[8]= (TextView)findViewById(R.id.textView9);
        textViews[9] = (TextView)findViewById(R.id.textView10);
        textViews[10] = (TextView)findViewById(R.id.textView11);
        textViews[11]= (TextView)findViewById(R.id.textView12);
        textViews[12]= (TextView)findViewById(R.id.textView13);

        Log.v("Test",number_tvs +" textviews are created successfully.........");


        SmsAttributes[] smsAttributes = new SmsAttributes[l1];
        Log.v("Test", l1+" Sms objs created");
        int tcount = 3;

try {
    for (int i = 0; i < 3; i++) {

        Log.v("Test", "In for loop "+ i);
        Log.v("Test", "Date for  "+ smsAttributes[i] + " is "+smsAttributes[i].mydate);
        Log.v("Test", "INR for  "+ smsAttributes[i] + " is "+smsAttributes[i].INR);
        Log.v("Test", "Place for  "+ smsAttributes[i] + " is "+smsAttributes[i].place);

        textViews[tcount].setText(smsAttributes[i].mydate);
        tcount++;
        Log.v("Test", "Date set for "+i);

        textViews[tcount].setText(smsAttributes[i].INR);
        tcount++;
        Log.v("Test", "INR set for "+i);

        textViews[tcount].setText(smsAttributes[i].place);
        tcount++;
        Log.v("Test", "Place  set for "+i);

    }
}catch(NumberFormatException ne){
    ne.getMessage();
    Log.v("Test", "Something is wrong in parsing ..");

}

}catch(Exception e){
    e.getMessage();
    Log.v("Test"," Some thing went wrong in setting text.");
}


    }
}
