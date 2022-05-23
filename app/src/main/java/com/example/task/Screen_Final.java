package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Screen_Final extends AppCompatActivity {

    TextView email,name;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen__final);
        email=findViewById(R.id.email);
        name=findViewById(R.id.name);
        imageView=findViewById(R.id.imageview);


        Intent intent = getIntent();
        String image_path= intent.getStringExtra("imagePath");
        String emailstr=intent.getStringExtra("email");
        String namestr=intent.getStringExtra("name");

        Uri fileUri = Uri.parse(image_path);
        imageView.setImageURI(fileUri);
        email.setText(emailstr);
        name.setText(namestr);

    }
}