package com.example.hamzasaleem.hci_new;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CartConf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_conf);




    }



    public void tickBtn(View V)
    {

        Intent intent = new Intent(getApplicationContext(), Feedback.class);
        startActivity(intent);

        finish();



    }


    public void crossBtn(View V)
    {


        finish();



    }



}
