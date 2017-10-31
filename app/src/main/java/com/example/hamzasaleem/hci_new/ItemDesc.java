package com.example.hamzasaleem.hci_new;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class ItemDesc extends AppCompatActivity {

    String itemName="";
    int itemImage;
    int RelatedItem1;
    int RelatedItem2;
    int RelatedItem3;

    String RelatedItem1Name="";
    String RelatedItem2Name="";
    String RelatedItem3Name="";



    TextToSpeech t1;
    ImageButton speak;
    ImageView main;

    ImageView sim1;
    ImageView sim2;
    ImageView sim3;

    ImageView size1;
    ImageView size2;
    ImageView size3;

    ImageButton mute;
    ImageButton plus;
    ImageButton minus;
    ImageButton buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_desc);


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




        Intent i = getIntent();
        itemName= i.getStringExtra("ItemName");

        itemImage=i.getIntExtra("ItemImage",R.drawable.hoodedjacket);
        RelatedItem1=i.getIntExtra("RelatedItem1",R.drawable.hoodedjacket);
        RelatedItem2=i.getIntExtra("RelatedItem2",R.drawable.hoodedjacket);
        RelatedItem3=i.getIntExtra("RelatedItem3",R.drawable.hoodedjacket);


        RelatedItem1Name=i.getStringExtra("RelatedItem1Name");
        RelatedItem2Name=i.getStringExtra("RelatedItem2Name");
        RelatedItem3Name=i.getStringExtra("RelatedItem3Name");





        main = (ImageView)findViewById(R.id.imageView);
        main.setImageResource(itemImage);

        sim1 = (ImageView)findViewById(R.id.similar1);
        sim1.setImageResource(RelatedItem1);

        sim2 = (ImageView)findViewById(R.id.similar2);
        sim2.setImageResource(RelatedItem2);

        sim3 = (ImageView)findViewById(R.id.similar3);
        sim3.setImageResource(RelatedItem3);

        size1 = (ImageView)findViewById(R.id.size1);
        size1.setImageResource(itemImage);

        size2 = (ImageView)findViewById(R.id.size2);
        size2.setImageResource(itemImage);

        size3 = (ImageView)findViewById(R.id.size3);
        size3.setImageResource(itemImage);






    }




    public void ItemPlus(View V)
    {
        TextView e = (TextView) findViewById(R.id.ItemAmount);

        int amount= Integer.parseInt(e.getText().toString()) ;
        amount++;
        e.setText(String.valueOf(amount) );


    }

    public void ItemNegative(View V)
    {
        TextView e = (TextView) findViewById(R.id.ItemAmount);

        int amount= Integer.parseInt(e.getText().toString()) ;
        if(amount!=1)
            amount--;
        e.setText(String.valueOf(amount) );


    }


    public void SpeakBtn(View V)
    {

        t1.speak(itemName+ " available in three colors and small, medium and large sizes ", TextToSpeech.QUEUE_FLUSH, null);


    }

    public void MuteBtn(View V)
    {

        t1.stop();


    }


    public void CartBtn(View V)
    {

        Intent i = new Intent(this,CartSplash.class);
        startActivity(i);



    }

    @Override
    protected void onPause() {

        t1.stop();
        super.onPause();
    }

    @Override
    protected void onDestroy() {

        t1.stop();
        super.onDestroy();
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


    public void Sim1Click(View V)
    {


        Intent i = new Intent(this,ItemDesc.class);
        i.putExtra("ItemName",RelatedItem1Name);
        i.putExtra("ItemImage",RelatedItem1);


        i.putExtra("RelatedItem1",itemImage);
        i.putExtra("RelatedItem2",RelatedItem2);
        i.putExtra("RelatedItem3",RelatedItem3);

        i.putExtra("RelatedItem1Name",itemName);
        i.putExtra("RelatedItem2Name",RelatedItem2Name);
        i.putExtra("RelatedItem3Name",RelatedItem3Name);

        startActivity(i);

        finish();




    }

    public void Sim2Click(View V)
    {

        Intent i = new Intent(this,ItemDesc.class);
        i.putExtra("ItemName",RelatedItem2Name);
        i.putExtra("ItemImage",RelatedItem2);


        i.putExtra("RelatedItem1",itemImage);
        i.putExtra("RelatedItem2",RelatedItem1);
        i.putExtra("RelatedItem3",RelatedItem3);

        i.putExtra("RelatedItem1Name",itemName);
        i.putExtra("RelatedItem2Name",RelatedItem1Name);
        i.putExtra("RelatedItem3Name",RelatedItem3Name);

        startActivity(i);

        finish();




    }


    public void Sim3Click(View V)
    {

        Intent i = new Intent(this,ItemDesc.class);
        i.putExtra("ItemName",RelatedItem3Name);
        i.putExtra("ItemImage",RelatedItem3);


        i.putExtra("RelatedItem1",itemImage);
        i.putExtra("RelatedItem2",RelatedItem2);
        i.putExtra("RelatedItem3",RelatedItem1);

        i.putExtra("RelatedItem1Name",itemName);
        i.putExtra("RelatedItem2Name",RelatedItem2Name);
        i.putExtra("RelatedItem3Name",RelatedItem1Name);

        startActivity(i);

        finish();



    }


    public void BlueClick(View V) {


        ImageView bluetick = (ImageView) findViewById(R.id.bluetick);
        bluetick.setVisibility(View.VISIBLE);

        ImageView greytick = (ImageView) findViewById(R.id.greytick);
        greytick.setVisibility(View.GONE);

        ImageView redtick = (ImageView) findViewById(R.id.redtick);
        redtick.setVisibility(View.GONE);





    }



    public void GreyClick(View V) {


        ImageView bluetick = (ImageView) findViewById(R.id.bluetick);
        bluetick.setVisibility(View.GONE);

        ImageView greytick = (ImageView) findViewById(R.id.greytick);
        greytick.setVisibility(View.VISIBLE);

        ImageView redtick = (ImageView) findViewById(R.id.redtick);
        redtick.setVisibility(View.GONE);





    }


    public void RedClick(View V) {


        ImageView bluetick = (ImageView) findViewById(R.id.bluetick);
        bluetick.setVisibility(View.GONE);

        ImageView greytick = (ImageView) findViewById(R.id.greytick);
        greytick.setVisibility(View.GONE);

        ImageView redtick = (ImageView) findViewById(R.id.redtick);
        redtick.setVisibility(View.VISIBLE);





    }


    public void SmallClick(View V) {


        ImageView bluetick = (ImageView) findViewById(R.id.smalltick);
        bluetick.setVisibility(View.VISIBLE);

        ImageView greytick = (ImageView) findViewById(R.id.medtick);
        greytick.setVisibility(View.GONE);

        ImageView redtick = (ImageView) findViewById(R.id.largetick);
        redtick.setVisibility(View.GONE);




    }

    public void MedClick(View V) {


        ImageView bluetick = (ImageView) findViewById(R.id.smalltick);
        bluetick.setVisibility(View.GONE);

        ImageView greytick = (ImageView) findViewById(R.id.medtick);
        greytick.setVisibility(View.VISIBLE);

        ImageView redtick = (ImageView) findViewById(R.id.largetick);
        redtick.setVisibility(View.GONE);




    }

    public void LargeClick(View V) {


        ImageView bluetick = (ImageView) findViewById(R.id.smalltick);
        bluetick.setVisibility(View.GONE);

        ImageView greytick = (ImageView) findViewById(R.id.medtick);
        greytick.setVisibility(View.GONE);

        ImageView redtick = (ImageView) findViewById(R.id.largetick);
        redtick.setVisibility(View.VISIBLE);




    }

    }
