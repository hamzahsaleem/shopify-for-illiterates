package com.example.hamzasaleem.hci_new;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoryList extends AppCompatActivity {

    ListView l1;
    CategoryAdapter adapter;
    ArrayList<CategoryObject> categories;
    TextToSpeech t1;
    private static final int SPEECH_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);


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



        categories= new  ArrayList<CategoryObject>();

        categories.add(new CategoryObject(R.drawable.men,"Men's Fashion"));
        categories.add(new CategoryObject(R.drawable.women,"Women Fashion"));
        categories.add(new CategoryObject(R.drawable.shoes,"Shoes"));
        categories.add(new CategoryObject(R.drawable.phones,"Mobile Phones"));
        categories.add(new CategoryObject(R.drawable.watch,"Smart Watches"));
        categories.add(new CategoryObject(R.drawable.bed,"Home and Garden"));
        categories.add(new CategoryObject(R.drawable.camera,"Cameras"));





        l1 = (ListView) findViewById(R.id.listView);
        adapter = new CategoryAdapter(this,R.layout.category_listitem,categories,t1);

        l1.setAdapter(adapter);


        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent i = new Intent(getApplicationContext(),ItemList.class);
                i.putExtra("Category",categories.get(position).getCateogyName());
                getApplicationContext().startActivity(i);

            }
        });



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
    protected void onDestroy() {


        if(t1 != null) {

            t1.stop();
            t1.shutdown();
        }
        super.onDestroy();
    }


}
