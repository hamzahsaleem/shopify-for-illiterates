package com.example.hamzasaleem.hci_new;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, Main2Activity.class);


        PendingIntent pd = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_ONE_SHOT);
       AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

       alarm.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (2000), pd);



    }
}
