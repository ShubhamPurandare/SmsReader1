package com.example.root.smsreader;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

public  int len_all_sms = 0;
public int Count=0;


    public String INR[] ;
    ListView L1 ;
    TextView count;
    Button analysis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.v("Test", "List view initialized");
        List<String> s;
        s = readSms();
        len_all_sms = s.size();
        Log.v("Test", "readSms func called");
        Log.v("Test", " "+ len_all_sms +" objects will be created now .....");

        SmsAttributes[] smsAttributes = new SmsAttributes[len_all_sms];
        Log.v("Test", len_all_sms+" Objects created successfully...");

        try {
    //L1 = (ListView) findViewById(R.id.listView);
    count = (TextView)findViewById(R.id.textView3);






    String messagecsv = "";

    Log.v("Test", "going inside a for loop");

    for(int index =0 ; index < s.size(); index++){
        Log.v("Test", "In the for loop to call d class with index "+index);

        String get = s.get(index);
       smsAttributes[index] = new SmsAttributes(get);
        Log.v("Test", " obj sucess and constructor called....");

    }


    for (int i = 0; i < s.size(); i++) {
        Log.v("Test", "Inside a for loop now ......... splitting....");
        messagecsv += s.get(i) + ",";
    }
    Log.v("Test", " **************** Display **************");

    for(int j=0 ; j< s.size() ; j++){
        Log.v("Test", "Date for object "+ smsAttributes[j] + " is "+smsAttributes[j].mydate);
        Log.v("Test", "INR for object "+ smsAttributes[j] + " is "+smsAttributes[j].INR);
        Log.v("Test", "Place for object "+ smsAttributes[j] + " is "+smsAttributes[j].place);

    }

    String messageArray[];

    messageArray = messagecsv.split(",");

    Log.v("Test", "splitting done.....");
    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, messageArray);

    Log.v("Test", "ArrayAdapter initialized ......");
   // L1.setAdapter(adapter);

    Log.v("Test", "list view shud show something now !!!");

            Log.v("Test", "Count value converted to String ...");
            Log.v("Test", Count+ " is the count integer...");

           // Log.v("Test", Count+ " is the count string...");

            count.setText(Count);
            Log.v("Test", "Count value set successfully .....");


}catch(Exception e){
    e.getMessage();

    Log.v("Test", "Fucked up !!!! Something went wrong !!!");
}


    /*    analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("Test","In onclickListener of analysis ........");
                Intent transfer = new Intent(MainActivity.this, Analysis.class);


                Log.v("Test", "Starting activity of  a new Intent .......");

                startActivity(transfer);

            }
        });*/


        int number_tvs = (len_all_sms*3)+6;
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
        textViews[13]= (TextView)findViewById(R.id.textView14);
        textViews[14]= (TextView)findViewById(R.id.textView15);

        Log.v("Test",number_tvs +" textviews are created successfully.........");
        int tcount = 6;
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



    }// end of oncreate method.

public List<String> readSms(){

                Log.v("Test", "Inside readsms func.....");
                List<String> sms = new ArrayList<String>();

                try {

                    Log.v("Test", "sms string done ");
                    Uri geturi = Uri.parse("content://sms/inbox");

                    Log.v("Test", "uri parsed to inbox successfully .....");
                    Cursor cur = getContentResolver().query(geturi, null, null, null, null);

                    Log.v("Test", "cursor obj set ....");

                    while (cur.moveToNext()) {
                        Log.v("Test", "inside while loop....");
                        String address = cur.getString(cur.getColumnIndex("address"));
                        Log.v("Test", " Address is "+address);

                        String body = cur.getString(cur.getColumnIndexOrThrow("body"));
                        Log.v("Test", " Body is " + body);
                                if(body.contains(" INR ")|| body.contains(" on ") || body.contains(" at ") || body.contains("Rs") ) {
                                  Count++;
                                    Log.v("Test", "Incrementing count value to "+ Count);

                                    Log.v("Test", "getting string and storing in 'body' string ");
                                    sms.add(body);
                                }else{
                                    Log.v("Test", "msg not added");
                                    }
                                            }
                    Log.v("Test", "outside while loop");

                   }catch (Exception e){
                    Log.v("Test", "Something went wrong in the readsms func ..............  :( ");

                }
                return sms;
        }//end of readsms method

}// end of class .







































