package com.rabitabank.test;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


public class Activity2  extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recycler;
    ImageView iv_leftarrow;
 //   ActivityViewModel activityViewModel;
    DataAdapter dataAdapter;
    Button btn_message_chat;
    EditText et_message;

    RelativeLayout rl_right5;
    ImageView iv_leftphoto, image_right;
    TextView tvMessage7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        et_message = findViewById(R.id.et_message);
        iv_leftarrow = findViewById(R.id.iv_leftarrow);
        recycler = findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplication());
        linearLayoutManager.setStackFromEnd(true);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        dataAdapter = new DataAdapter(this, new ArrayList<DataChat>());
        dataAdapter.notifyItemChanged(dataAdapter.getItemCount());
        recycler.setAdapter(dataAdapter);

        rl_right5 = findViewById(R.id.rl_right5);
        iv_leftphoto = findViewById(R.id.iv_leftphoto);
        tvMessage7 = findViewById(R.id.tvMessage7);
        image_right = findViewById(R.id.image_right);

        iv_leftphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto, 1);
                Intent intent = new Intent();
                intent.putExtra("id_image", pickPhoto);




            }
        });

        iv_leftarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                startActivity(intent);

            }
        });

        btn_message_chat = findViewById(R.id.btn_message_chat);
        btn_message_chat.setOnClickListener(this);



    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    image_right.setImageURI(selectedImage);


                }
                break;

        }
    }



    @Override
    public void onClick(View view) {


        Intent intent = getIntent();
        String id_image = intent.getStringExtra("id_image");

        String context = et_message.getText().toString();
        String url = id_image;

        DataChat dataChat = new DataChat(context, url);
        dataAdapter.add(dataChat);

        recycler.scrollToPosition(dataAdapter.getItemCount() - 1);
        et_message.getText().clear();
        dataAdapter.notifyDataSetChanged();




    }
}
