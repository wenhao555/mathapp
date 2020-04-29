package com.student.oclass.data;

import android.content.SharedPreferences;

import com.example.justloginregistertest.MyApplication;

import static android.content.Context.MODE_PRIVATE;

public class SaveData {
    public static void save(String name){
        SharedPreferences sp = MyApplication.context.getSharedPreferences("info", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("name", name);
        edit.apply();
 }
 public static String getData(){
        return  MyApplication.context. getSharedPreferences("info", MODE_PRIVATE).getString("name","");
 }
}
