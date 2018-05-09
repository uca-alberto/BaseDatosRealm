package com.example.alber.basedatosapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.alber.basedatosapi.models.ProductModel;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CreatedProduct();
       // getAllProduct();
        deleteProducts();
        //updateProducts();
        getAllProduct();
    }
    public void CreatedProduct()
    {
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        ProductModel productModel = realm.createObject(ProductModel.class);

        //set values to model
        productModel.setSku("1234");
        productModel.setName("gatito lindo");
        productModel.setPrice(100);

        realm.commitTransaction();
    }
    public  void getAllProduct()
    {
        Realm realm = Realm.getDefaultInstance();

        RealmQuery<ProductModel> query = realm.where(ProductModel.class);

        RealmResults<ProductModel> results = query.findAll();

        for (ProductModel productModel : results)
        {
            Log.i("Name:",productModel.getName());
            Log.i("SKU:",productModel.getSku());
            Log.i("Price:",String.valueOf(productModel.getPrice()));
        }
    }
    private  void updateProducts(){
        Realm realm = Realm.getDefaultInstance();

        RealmQuery<ProductModel> query = realm.where(ProductModel.class);

        RealmResults<ProductModel> results = query.findAll();

        for (ProductModel productModel : results){
            updateProduct(productModel);
        }
    }
    private void updateProduct(ProductModel productModel){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        productModel.setName("dog lindo");

        realm.commitTransaction();
    }

    private void deleteProducts(){
        Realm realm = Realm.getDefaultInstance();

        RealmQuery<ProductModel> query = realm.where(ProductModel.class);

        RealmResults<ProductModel> results = query.findAll();

        for (int i = 0; i<results.size(); i++)
        {
            if (i==1)
            {
                deleteProduct(results.get(i));
            }
        }
    }
    private void deleteProduct(ProductModel productModel){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        productModel.deleteFromRealm();

        realm.commitTransaction();
    }
}
