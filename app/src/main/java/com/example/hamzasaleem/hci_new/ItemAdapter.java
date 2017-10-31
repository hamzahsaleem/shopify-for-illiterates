package com.example.hamzasaleem.hci_new;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Locale;
import android.widget.Filter;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Filter;
import java.util.ArrayList;

import android.app.Activity;

import android.app.Activity;


public class ItemAdapter extends ArrayAdapter<ItemObject> {

    Context c;
    int layoutFile;
    ArrayList<ItemObject> data,data1;
    TextToSpeech t1;
    ValueFilter valuefilter;



    public ItemAdapter(Context context, int resource, ArrayList<ItemObject> myArray,TextToSpeech t1) {
        super(context, resource, myArray);

        c=context;
        layoutFile=resource;
        data=myArray;
        data1=data;

       this.t1=t1;




    }


    void setData(ArrayList<ItemObject> myArray)
    {

        data=myArray;
        data1=data;

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


        im1.setOnClickListener(new View.OnClickListener() {

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



    @Override
    public int getCount() {

        return data.size();
    }



    @Override
    public Filter getFilter()
    {
        if(valuefilter==null)
        {
            valuefilter = new ValueFilter();

        }
        return valuefilter;

    }


    private class ValueFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults result = new FilterResults();

            if(constraint!=null && constraint.length()!=0)
            {
                ArrayList<ItemObject> arr = new ArrayList<ItemObject>();

                for(int i=0;i<data1.size();i++)
                {
                    if((data1.get(i).getObjName().toUpperCase()).contains(constraint.toString().toUpperCase()) )
                    {
                        ItemObject n1 = new ItemObject(data1.get(i).getImage(),data1.get(i).getObjName());
                        arr.add(n1);

                    }

                }


                result.count=arr.size();
                result.values=arr;



            }

            else
            {
                result.count=data1.size();
                result.values=data1;

            }



            return result;

        }

        @Override
        protected void publishResults(CharSequence constraint,FilterResults results) {

            data= (ArrayList<ItemObject>) results.values;
            notifyDataSetChanged();



        }



    }




}
