package com.example.hamzasaleem.hci_new;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class SaleActivity extends AppCompatActivity {

    ListView l1;
    SaleAdapter adapter;
    ArrayList<ItemObject> items;
    TextToSpeech t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);



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



        items= new  ArrayList<ItemObject>();

        items.add(new ItemObject(R.drawable.menblazer,"Men Blazer"));
        items.add(new ItemObject(R.drawable.menbrownjacket,"Men Brown Jacket"));
        items.add(new ItemObject(R.drawable.menjacket,"Men Jacket"));
        items.add(new ItemObject(R.drawable.menwhiteblazer,"Men White Blazer"));
        items.add(new ItemObject(R.drawable.hoodedjacket,"Men Hooded Jacket"));



        l1 = (ListView) findViewById(R.id.listView3);
        adapter = new SaleAdapter(this,R.layout.saleitem_row,items,t1);

        l1.setAdapter(adapter);


        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent i = new Intent(getApplicationContext(),ItemDesc.class);
                i.putExtra("ItemName",items.get(position).getObjName());
                i.putExtra("ItemImage",items.get(position).getImage());


                i.putExtra("RelatedItem1",items.get((position+1)% items.size()).getImage());
                i.putExtra("RelatedItem2",items.get((position+2)%items.size()).getImage());
                i.putExtra("RelatedItem3",items.get((position+3)%items.size()).getImage());

                i.putExtra("RelatedItem1Name",items.get((position+1)% items.size()).getObjName());
                i.putExtra("RelatedItem2Name",items.get((position+2)%items.size()).getObjName());
                i.putExtra("RelatedItem3Name",items.get((position+3)%items.size()).getObjName());



                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                getApplicationContext().startActivity(i);

            }
        });






    }

}
