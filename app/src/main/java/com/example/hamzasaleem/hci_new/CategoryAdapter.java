package com.example.hamzasaleem.hci_new;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Filter;
import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.widget.Toast;

import at.markushi.ui.CircleButton;


public class CategoryAdapter extends ArrayAdapter<CategoryObject> {

    Context c;
    int layoutFile;
    ArrayList<CategoryObject> data;
    TextToSpeech t1;


    public CategoryAdapter(Context context, int resource, ArrayList<CategoryObject> myArray,TextToSpeech t1) {
        super(context, resource, myArray);

        c=context;
        layoutFile=resource;
        data=myArray;
        this.t1=t1;





    }




    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View row=convertView;

        if(row== null)
        {
            LayoutInflater inflater = ((Activity)c).getLayoutInflater();

            row = inflater.inflate(layoutFile, parent, false);

        }


        ImageView im1= (ImageView) row.findViewById(R.id.categoryPic);
        im1.setImageResource(data.get(position).getCategoryPhoto());

        im1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(c,ItemList.class);
                i.putExtra("Category",data.get(position).getCateogyName());
                c.startActivity(i);


            }

        });



        ImageButton imb1= (ImageButton) row.findViewById(R.id.view1);


        imb1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                t1.speak(data.get(position).getCateogyName(), TextToSpeech.QUEUE_FLUSH, null);


            }

        });



        ImageButton imb2= (ImageButton) row.findViewById(R.id.view2);


        imb2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                Intent i = new Intent(c,ItemList.class);
                i.putExtra("Category",data.get(position).getCateogyName());
                c.startActivity(i);



            }

        });














        return row;
    }







}
