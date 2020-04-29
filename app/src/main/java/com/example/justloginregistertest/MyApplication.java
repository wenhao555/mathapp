package com.example.justloginregistertest;

import android.app.Application;
import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        String DB_PATH = "/data/data/com.example.justloginregistertest/databases/";
        String DB_NAME = "question.db";

        if((new File(DB_PATH + DB_NAME).exists()) == false)
        {
            File dir = new File(DB_PATH);
            if (!dir.exists())
            {
                dir.mkdir();
            }

            try {
                InputStream is = getBaseContext().getAssets().open(DB_NAME);
                OutputStream os = new FileOutputStream(DB_PATH + DB_NAME);
                byte[] buffer = new byte[1024];
                int length;

                while((length = is.read(buffer)) > 0)
                {
                    os.write(buffer, 0, length);
                }
                os.flush();
                os.close();
                is.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
