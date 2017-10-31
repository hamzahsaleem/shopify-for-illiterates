package com.example.hamzasaleem.hci_new;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    ArrayList<Item> items;
    int selectedItem;
    ItemListAdapter adapter;
    ListView list;
    TextToSpeech t1;
    int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        if(items==null){
            items=new ArrayList<Item>();
            items.add(new Item("Men grey suit","Men Wear",R.drawable.qty3,500,R.drawable.greysuit));
            items.add(new Item("Men glasses","Men Wear",R.drawable.qty2,100,R.drawable.glasses));
            items.add(new Item("Tablet PC","Phones",R.drawable.qty3,1750,R.drawable.tab));

        }

        createView();
    }

    public void createView()
    {
        ListView listview = (ListView) findViewById(R.id.listview);
        ItemListAdapter adapter = new ItemListAdapter(this,items);
        listview.setAdapter(adapter);

        ImageView speech=(ImageView) findViewById(R.id.imageView2);
        ImageView stopSpeech=(ImageView) findViewById(R.id.imageView3);

        ImageView buy=(ImageView) findViewById(R.id.buyItem);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t1==null)
                {
                    t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if(status != TextToSpeech.ERROR) {
                                t1.setLanguage(Locale.UK);
                                t1.setSpeechRate(1);
                            }
                        }
                    });
                }
                String toSpeak = "";
                for(int i=0;i<items.size();i++) {
                    toSpeak+=items.get(i).getName()+" ";
                }
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                pos=(pos+1)%items.size();
            }
        });

        stopSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t1 !=null){
                    t1.stop();
                }
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(items.size()==0)
                {
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);

                    finish();

                }
                else {
                    Intent intent = new Intent(getApplicationContext(), CartConf.class);
                    startActivity(intent);

                    finish();

                }

            }
        });
    }





    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}
