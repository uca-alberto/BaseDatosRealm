package com.example.alber.basedatosapi;

import io.realm.Realm;

/**
 * Created by alber on 20/3/2018.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
