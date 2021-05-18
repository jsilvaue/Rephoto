package com.example.rephoto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.*;
import androidx.appcompat.app.AppCompatActivity;

public class Cam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
    }

    static final int Request_Image_Capture = 1;

    public void Click_btnFoto (View view) {
        /*
        Intent TakePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(TakePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(TakePictureIntent, Request_Image_Capture); */
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
        }

}