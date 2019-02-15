package com.example.mnlgu.challenge1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mnlgu.challenge1.R;
import com.example.mnlgu.challenge1.model.Escuela;

public class CardActivity extends AppCompatActivity {

    Escuela escuela;
    ImageView imageView;
    TextView nombre, telefono, campus, sitioweb, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        escuela = (Escuela) i.getSerializableExtra("escuela");
        setContentView(R.layout.activity_card);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void init(){
        nombre = findViewById(R.id.nombre_card);
        campus = findViewById(R.id.campus_card);
        telefono = findViewById(R.id.telefono_card);
        email = findViewById(R.id.email_card);
        sitioweb = findViewById(R.id.sitioWeb_card);
        imageView = findViewById(R.id.image_card);

        nombre.setText(escuela.getNombre());
        campus.setText(escuela.getCampus());
        telefono.setText(escuela.getTelefono());
        email.setText(escuela.getCorreoElectronico());
        sitioweb.setText(escuela.getSitioWeb());
        Glide.with(this).load(escuela.getImagenURL()).into(imageView);
    }
}
