package com.example.hamzasaleem.hci_new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemListAdapter extends ArrayAdapter<Item> {
    private ArrayList<Item> items;

    public ItemListAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
        this.items = items;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        final Item item = items.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_main, parent, false);
        }

        ImageView qty = (ImageView) convertView.findViewById(R.id.qty);
        qty.setImageResource(item.getQuantity());

        TextView price = (TextView) convertView.findViewById(R.id.price);
        price.setText("$\t"+item.getPrice().toString());

        ImageView imgView=(ImageView) convertView.findViewById(R.id.imageView);
        imgView.setImageResource(item.getPath());

        ImageView delImg=(ImageView) convertView.findViewById(R.id.deleteImg);
        delImg.setImageResource(R.drawable.delete);

        delImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
}
