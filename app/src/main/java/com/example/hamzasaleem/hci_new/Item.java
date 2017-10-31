package com.example.hamzasaleem.hci_new;


import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Safi on 4/18/2016.
 */
public class Item implements Serializable{
    private String id;
    private String name;
    private String category;
    private Integer quantity;
    private Integer price;
    private Integer path;

    public Item()
    {
        init();
    }
    public Item(String n,String c,Integer q,Integer p,Integer pa)
    {
        init();
        name=n;
        category=c;
        quantity=q;
        price=p;
        path=pa;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public Integer getPath(){
        return path;
    }

    public String getName(){
        return name;
    }

    private void init() {
        this.id = UUID.randomUUID().toString();
    }
}
