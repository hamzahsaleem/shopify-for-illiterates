package com.example.hamzasaleem.hci_new;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Feedback extends AppCompatActivity {

    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);



        t1=new TextToSpeech(getApplicationContext(),

                new TextToSpeech.OnInitListener()

                {
                    @Override
                    public void onInit ( int status){
                        if (status != TextToSpeech.ERROR) {
                            t1.setLanguage(Locale.ENGLISH);
                            t1.speak("Thank you for shopping with us!", TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                }

        );





        Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {

                finish();
            }
        }, 2000);










    }
}
