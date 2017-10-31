package com.example.hamzasaleem.hci_new;


import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        t1=new TextToSpeech(getApplicationContext(),

                new TextToSpeech.OnInitListener()

                {
                    @Override
                    public void onInit ( int status){
                        if (status != TextToSpeech.ERROR) {
                            t1.setLanguage(Locale.ENGLISH);
                        }
                    }
                }

        );






    }




    public void signInBtn(View V)
    {

        EditText e = (EditText) findViewById(R.id.editText);

        String str=e.getText().toString();

        if(str.length()==11)
        {
            t1.speak("Welcome to Shopify!", TextToSpeech.QUEUE_FLUSH, null);

            Intent i= new Intent(this,Home.class);
            startActivity(i);


        }
        else if(str.length()==0)
        {
            t1.speak("Please Enter Your Phone Number!", TextToSpeech.QUEUE_FLUSH, null);

        }
        else

        {

            t1.speak("Wrong Phone Number. Please type again.", TextToSpeech.QUEUE_FLUSH, null);
            e.setText("");

        }





    }


    public void PhoneBtn(View V)
    {


        t1.speak("Please Enter Your Phone Number!", TextToSpeech.QUEUE_FLUSH, null);






    }



}
