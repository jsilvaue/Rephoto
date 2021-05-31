package com.example.rephoto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.*;


public class MapaActivity extends AppCompatActivity {

    GoogleMap map;
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        client = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(MapaActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getCurrentLocation();
        }
        else {
            ActivityCompat.requestPermissions(MapaActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
    }

    private void getCurrentLocation() {


        @SuppressLint("MissingPermission") Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

                if(location != null) {

                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
                            MarkerOptions options = new MarkerOptions().position(latLng).title("Estou aqui");
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                            options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                            googleMap.addMarker(options);


                            LatLng Torre_Belem = new LatLng(38.69182536113338, -9.21589720202717);
                            MarkerOptions options1 = new MarkerOptions().position(Torre_Belem).title("Torre de Belém");
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Torre_Belem, 10));
                            googleMap.addMarker(options1);

                            LatLng Mosteiro_Jeronimos = new LatLng(38.69808346654581, -9.206693173190343);
                            MarkerOptions options2 = new MarkerOptions().position(Mosteiro_Jeronimos).title("Mosteiro dos Jerónimos");
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Mosteiro_Jeronimos, 10));
                            googleMap.addMarker(options2);

                            LatLng Monumento_Restauradores = new LatLng(38.7158860484517, -9.141637486679969);
                            MarkerOptions options3 = new MarkerOptions().position(Monumento_Restauradores).title("Monumento aos Restauradores");
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Monumento_Restauradores, 10));
                            googleMap.addMarker(options3);

                            LatLng Estatua_DuqueTerceira = new LatLng(38.706714715647415, -9.143524902026734);
                            MarkerOptions options4 = new MarkerOptions().position(Estatua_DuqueTerceira).title("Estátua do Duque da Terceira");
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Estatua_DuqueTerceira, 10));
                            googleMap.addMarker(options4);

                            LatLng Estatua_MarquesPombal = new LatLng(38.72532326018175, -9.149959115516307);
                            MarkerOptions options5 = new MarkerOptions().position(Estatua_MarquesPombal).title("Estátua do Marquês de Pombal");
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Estatua_MarquesPombal, 10));
                            googleMap.addMarker(options5);

                        }
                    });
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 44) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            }
        }
    }
}