package com.kutugondrong.loadimagekg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by hedy on 4/7/2016.
 */
public class LoadImage extends AsyncTask<String, Integer, Bitmap> {

    private InternetConectionListener internetConectionListener;

    public LoadImage(InternetConectionListener internetConectionListener){
        this.internetConectionListener = internetConectionListener;
    }

    @Override
    protected void onPreExecute() {
        internetConectionListener.start();

    }

    @Override
    protected Bitmap doInBackground(String... args) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        internetConectionListener.onProgress(progress[0]);

    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected void onPostExecute(Bitmap image) {
        if(image != null){
            internetConectionListener.onDone(image);
        }else{
            internetConectionListener.failed();
        }
    }
}
