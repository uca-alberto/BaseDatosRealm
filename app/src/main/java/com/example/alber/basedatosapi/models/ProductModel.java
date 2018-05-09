package com.example.alber.basedatosapi.models;

import io.realm.RealmObject;

/**
 * Created by alber on 20/3/2018.
 */

public class ProductModel extends RealmObject{
    private String sku;
    private  String name;
    private float price;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

