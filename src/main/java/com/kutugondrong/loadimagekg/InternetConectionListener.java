package com.kutugondrong.loadimagekg;

import android.graphics.Bitmap;

/**
 * Created by hedy on 4/7/2016.
 */
public interface InternetConectionListener {
    void start();
    void onProgress(Integer progress);
    void onDone(Bitmap image);
    void failed();
}
