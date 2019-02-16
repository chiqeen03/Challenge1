package com.example.mnlgu.challenge1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ViewImageActivity extends AppCompatActivity {

    ImageView imageView;
    String imageURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        Intent i = getIntent();
        imageURL = (String) i.getSerializableExtra("imagen");

        imageView = findViewById(R.id.image_card);
        Glide.with(this).load(imageURL).into(imageView);
    }
}
