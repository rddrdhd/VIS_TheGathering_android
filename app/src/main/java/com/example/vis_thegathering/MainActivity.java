package com.example.vis_thegathering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    Button buttAdd;
    Button buttView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttAdd = findViewById(R.id.button2);
        buttView = findViewById(R.id.button1);
    }

    public void browse(View view){
        Intent i = new Intent(this, ItemListActivity.class);
        startActivity(i);
    }

    public void add(View view){
        Intent i = new Intent(this, AddActivity.class );
        startActivity(i);
    }

    public static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

}
