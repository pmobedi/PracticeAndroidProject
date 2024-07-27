package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.activity.AboutActivity;
import com.example.myapplication.activity.ContactActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imageSlider;
    Button btn_home, btn_contact;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("LifeCycle Main", "OnCreate");
        imageSlider = (ImageView) findViewById(R.id.img_slider);
        btn_home = (Button) findViewById(R.id.btn_home);
        btn_contact = (Button)findViewById(R.id.btn_contact);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("LifeCycle Main","on click for test");
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.contact_message), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle Main", "onPause");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle Main", "onStart");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("LifeCycle Main", "Restart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle Main", "onResume");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle Main", "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle Main", "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu); }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.item_about:
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
                break;

//            case R.id.item_exit:
//
//                //   finish();
//
//                break;
//
//
            case R.id.item_contact:
                Intent intent_ahmadi = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:0912236458"));
                startActivity(intent_ahmadi);
                break;

//
//
//            case R.id.item_search:
//
//
//                break;
//
            case R.id.item_sms:
                Intent intent2 = new Intent(Intent.ACTION_VIEW , Uri.parse("sms:0912236458"));
                startActivity(intent2);
                break;
//
            case R.id.item_website:
                Intent intent_mohammadi2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                startActivity(intent_mohammadi2);
                break;




        }


        return super.onOptionsItemSelected(item);
    }
}

