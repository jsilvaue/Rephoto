package com.example.rephoto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MenuActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView btMenu;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }

    public void Click_ibtnDefinicoes (View view) {

        Intent intent = new Intent(this, AlterarPassword.class);
        startActivity(intent);
    }

    public void Click_ibtnMapa (View view) {

        Intent intent = new Intent(this, MapaActivity.class);
        startActivity(intent);
    }

    public void Click_ibtnRanking (View view) {

        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);
    }

    public void Click_ibtnCam (View view) {

        Intent intent = new Intent(this, ArAcitivy.class);
        startActivity(intent);
    }

    public void Click_ibtnFotos (View view) {

        Intent intent = new Intent(this, PortfolioUtilizadorActivity.class);
        startActivity(intent);
    }

    public void Click_ibtnAlbum (View view) {

        Intent intent = new Intent(this, AlbumActivity.class);
        startActivity(intent);
    }
}