package com.example.hamzasaleem.hci_new;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class SaleAdapter extends ArrayAdapter<ItemObject> {

    Context c;
    int layoutFile;
    ArrayList<ItemObject> data;
    TextToSpeech t1;




    public SaleAdapter(Context context, int resource, ArrayList<ItemObject> myArray,TextToSpeech t1) {
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


        ImageView im1= (ImageView) row.findViewById(R.id.ItemPicture);
        im1.setImageResource(data.get(position).getImage());




        ImageButton imb1= (ImageButton) row.findViewById(R.id.view1);


        imb1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                t1.speak(data.get(position).getObjName(), TextToSpeech.QUEUE_FLUSH, null);


            }

        });



        ImageButton imb2= (ImageButton) row.findViewById(R.id.view2);


        imb2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                Intent i = new Intent(c,ItemDesc.class);
                i.putExtra("ItemName",data.get(position).getObjName());
                i.putExtra("ItemImage",data.get(position).getImage());


                i.putExtra("RelatedItem1",data.get((position+1)% data.size()).getImage());
                i.putExtra("RelatedItem2",data.get((position+2)%data.size()).getImage());
                i.putExtra("RelatedItem3",data.get((position+3)%data.size()).getImage());

                i.putExtra("RelatedItem1Name",data.get((position+1)% data.size()).getObjName());
                i.putExtra("RelatedItem2Name",data.get((position+2)%data.size()).getObjName());
                i.putExtra("RelatedItem3Name",data.get((position+3)%data.size()).getObjName());



                c.startActivity(i);



            }

        });







        return row;
    }







}
