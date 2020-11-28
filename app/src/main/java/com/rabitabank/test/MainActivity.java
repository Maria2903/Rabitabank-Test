package com.rabitabank.test;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {



   RelativeLayout rl_item_contact;
   ImageView iv_photo1, iv_profile_image, iv_profile_image2, iv_photo4, iv_photo5, iv_photo6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);


        rl_item_contact = findViewById(R.id.rl_item_contact);
        rl_item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);

            }
        });


        iv_photo1 = findViewById(R.id.iv_photo1);
        Picasso.get()
                .load(R.drawable.photo1)
                .transform(new CircularTransformation(0))
                .into(iv_photo1);



        iv_photo4 = findViewById(R.id.iv_photo4);
        Picasso.get()
                .load(R.drawable.photo2)
                .transform(new CircularTransformation(0))
                .into(iv_photo4);


        iv_photo5 = findViewById(R.id.iv_photo5);
        Picasso.get()
                .load(R.drawable.photo7)
                .transform(new CircularTransformation(0))
                .into(iv_photo5);

        iv_photo6 = findViewById(R.id.iv_photo6);
        Picasso.get()
                .load(R.drawable.photo9)
                .transform(new CircularTransformation(0))
                .into(iv_photo6);




        iv_profile_image = findViewById(R.id.iv_profile_image);
        iv_profile_image2 = findViewById(R.id.iv_profile_image2);

        Picasso.get()
                .load(R.drawable.photo1)
                .transform(new CircularTransformation(0))
                .into(iv_profile_image);
        Picasso.get()
                .load(R.drawable.photo2)
                .transform(new CircularTransformation(0))
                .into(iv_profile_image2);


    }
}
