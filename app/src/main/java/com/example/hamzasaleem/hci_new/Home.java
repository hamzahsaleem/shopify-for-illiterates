package com.example.hamzasaleem.hci_new;

import android.content.Intent;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Home extends AppCompatActivity {

    ListView l1;
    TextToSpeech t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        t1=new TextToSpeech(this,

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

    public void saleBtn(View V)
    {



        Intent i= new Intent(this,SaleActivity.class);
        startActivity(i);





    }




    public void categoryBtn(View V)
    {




        Intent i= new Intent(this,CategoryList.class);
        startActivity(i);





    }


    public void CancelOrderBtn(View V)
    {




                Intent intent = new Intent(this,CancelOrderActivity.class);

                    startActivity(intent);






    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
        } catch (Exception e)
        {


        }

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)

    {
        // Handle item selection
        switch (item.getItemId())
        {
            case R.id.cart:

                Intent i= new Intent(this,CartActivity.class);
                startActivity(i);


                return true;



            default:
                return super.onOptionsItemSelected(item);
        }
    }




    @Override
    public void onBackPressed() {


            super.onBackPressed();

    }





}
