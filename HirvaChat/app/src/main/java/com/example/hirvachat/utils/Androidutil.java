package com.example.hirvachat.utils;

import android.content.Context;
import android.widget.Toast;

public class Androidutil {
    public static void showToast(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
