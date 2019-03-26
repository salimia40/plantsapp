package ir.puyaars.plantsapp;

import android.app.Application;

import ir.puyaars.plantsapp.repository.Repository;

public class app extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * initialize the repository
         * in case of web api un comment init network with your api link
         */
        Repository
                .getInstance(this.getApplicationContext())
                .initDatabase();

//                .initNetwork("https://puyaars.ir")

    }
}
