package com.example.hamzasaleem.hci_new;

import android.content.Intent;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class CancelOrderActivity extends AppCompatActivity {
    TextToSpeech t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_order);



        t1=new TextToSpeech(this,

                new TextToSpeech.OnInitListener()

                {
                    @Override
                    public void onInit ( int status){
                        if (status != TextToSpeech.ERROR) {
                            t1.setLanguage(Locale.ENGLISH);
                            t1.speak("To cancel your order select the option to talk to our customer support.", TextToSpeech.QUEUE_FLUSH, null);

                        }
                    }
                }

        );




    }





    public void CancelBtn(View V)
    {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "111222333444"));
        try {
            startActivity(intent);
        }

        catch(Exception e)
        {
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();


        }




    }



    public void BackBtn(View V) {


        super.onBackPressed();


    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }




    }
