package com.example.sdk_module_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.mainBtn).setOnClickListener(v -> {
            Intent listeView = new Intent (getApplicationContext(),Liste.class);
            startActivity(listeView);
            finish();
        });
    }
}
