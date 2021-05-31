package com.example.rephoto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.*;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Utilizador = findViewById(R.id.txt_Utilizador);
        TextView Password = findViewById(R.id.txt_Password);

        Utilizador.setText("João");
        Password.setText("password");
    }

    public void Click_btnLogin (View view) {

        TextView Utilizador = findViewById(R.id.txt_Utilizador);
        TextView Password = findViewById(R.id.txt_Password);


        if (Utilizador.getText().toString().equals("João") && Password.getText().toString().equals("password")){

            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }


        /*
        Password.setText("Sucesso");
        Utilizador.setText("Sucesso");*/

    }

    public void Click_btnRegistar (View view) {

        Intent intent = new Intent(this, RegistarActivity.class);
        startActivity(intent);
    }
}
