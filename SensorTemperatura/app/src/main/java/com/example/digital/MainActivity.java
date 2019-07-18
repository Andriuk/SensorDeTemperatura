package com.example.digital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button IdBiberones, IdAgua, IdAceite, IdComida, IdPersonalizar;
    // String para la direccion MAC
    private static String direccion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IdBiberones = findViewById(R.id.IdBiberones);
        IdAgua = findViewById(R.id.IdAgua);
        IdAceite = findViewById(R.id.IdAceite);
        IdComida = findViewById(R.id.IdComida);
        IdPersonalizar = findViewById(R.id.IdPersonalizar);
        //Consigue la direccion MAC desde DeviceListActivity via intent
        Intent intent = getIntent();
        //Consigue la direccion MAC desde DeviceListActivity via EXTRA
        direccion = intent.getStringExtra(DispositivosBT.EXTRA_DEVICE_ADDRESS);//<-<- PARTE A MODIFICAR >->->
        //Toast.makeText(getApplicationContext(),direccion, Toast.LENGTH_SHORT).show();
        IdBiberones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, UserInterfaz.class);//<-<- PARTE A MODIFICAR >->->
                i.putExtra("Address", direccion);
                i.putExtra("Funcion", 1);
                startActivity(i);
                //addNotification();
            }
        });

        IdAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, UserInterfaz.class);//<-<- PARTE A MODIFICAR >->->
                i.putExtra("Address", direccion);
                i.putExtra("Funcion", 2);
                startActivity(i);
                //addNotification();
            }
        });

        IdAceite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, UserInterfaz.class);//<-<- PARTE A MODIFICAR >->->
                i.putExtra("Address", direccion);
                i.putExtra("Funcion", 3);
                startActivity(i);
                //addNotification();
            }
        });

        IdComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, UserInterfaz.class);//<-<- PARTE A MODIFICAR >->->
                i.putExtra("Address", direccion);
                i.putExtra("Funcion", 4);
                startActivity(i);
                //addNotification();
            }
        });

        IdPersonalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PersonalizarActiv.class);//<-<- PARTE A MODIFICAR >->->
                i.putExtra("Address", direccion);
                startActivity(i);
                //addNotification();
            }
        });

    }


}
