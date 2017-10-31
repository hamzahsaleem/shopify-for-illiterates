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
import java.util.Timer;
import java.util.TimerTask;

public class ItemList extends AppCompatActivity {

    ListView l1;
    ItemAdapter adapter;
    ArrayList<ItemObject> items;
    TextToSpeech t1;
    private static final int SPEECH_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);


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



        l1 = (ListView) findViewById(R.id.listView2);
        adapter = new ItemAdapter(this,R.layout.item_listitem,items,t1);

        l1.setAdapter(adapter);


        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


               /* Intent intent = new Intent(getApplicationContext(),Episodelist_Activity.class);

                intent.putExtra("dramaImage",dramas.get(position).getPictureResource());
                intent.putExtra("dramaName",dramas.get(position).getDramaName());


                startActivity(intent);

*/

            }
        });




    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.searchmenu, menu);
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

            case R.id.search:


                t1.speak("Speak the name of the item to search in the mike. To retry click the mike again.", TextToSpeech.QUEUE_FLUSH, null);



                Timer t = new Timer();
                t.schedule(new TimerTask() {

                    @Override
                    public void run() {

                        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                        startActivityForResult(intent, SPEECH_REQUEST_CODE);




                    }
                }, 6000);





                return true;





            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);



                adapter.getFilter().filter("Jacket");


        }
        super.onActivityResult(requestCode, resultCode, data);
    }





    @Override
    protected void onDestroy() {


        //Close the Text to Speech Library
        if(t1 != null) {

            t1.stop();
            t1.shutdown();
        }
        super.onDestroy();
    }




}
