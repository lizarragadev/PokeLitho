package com.miramicodigo.demolitho;

import android.app.Application;

import com.facebook.soloader.SoLoader;

/**
 *
 * @author Gustavo Lizárraga
 * @date 25-07-17
 *
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, false);
    }
}
