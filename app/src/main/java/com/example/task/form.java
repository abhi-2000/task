package com.example.task;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;

public class form extends AppCompatActivity {
    Button upload,submit;
    EditText name,email;
    String imagedata="";
    ImageView imageupload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        upload=findViewById(R.id.upload);
        submit=findViewById(R.id.submit);
        name=findViewById(R.id.edittxtname);
        email=findViewById(R.id.edittxtEmail);
        imageupload=findViewById(R.id.imageupload);
    }

    public void upload(View view) {
        ImagePicker.with(this)
                .cameraOnly()
//                .crop()	    			//Crop image(Optional), Check Customization for more option
//                .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri=data.getData();
        imagedata = uri.toString();
        if(imagedata.isEmpty())
            Toast.makeText(getApplicationContext(), "Add image to continue" , Toast.LENGTH_LONG).show();
        else {
            imageupload.setImageURI(Uri.parse(imagedata));
            imageupload.setVisibility(View.VISIBLE);
        }

    }

    public void submit(View view) {
        String stremail=email.getText().toString();
        String strname=name.getText().toString();
        if (!Patterns.EMAIL_ADDRESS.matcher(stremail).matches()) {
            email.setError("Please enter a valid email id");
            email.requestFocus();
            return;
        }

        if (stremail.isEmpty()) {
            email.setError("Email cannot be empty");
            email.requestFocus();
            return;
        }
        if (strname.isEmpty()) {
            name.setError("Name cannot be empty");
            name.requestFocus();
            return;
        }

        Intent i = new Intent(getApplicationContext(), Screen_Final.class);
        i.putExtra("name",strname);
        i.putExtra("email",stremail);
        if(imagedata.isEmpty())
            Toast.makeText(getApplicationContext(), "Add image to continue" , Toast.LENGTH_LONG).show();

        else {
            i.putExtra("imagePath", imagedata);

            startActivity(i);
            finish();

        }
    }
}