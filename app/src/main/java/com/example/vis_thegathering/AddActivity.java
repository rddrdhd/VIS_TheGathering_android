package com.example.vis_thegathering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class AddActivity extends AppCompatActivity {
    Button buttPost;
    Button buttDeck;
    Button buttTournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        buttPost = findViewById(R.id.button3);
        buttDeck = findViewById(R.id.button4);
        buttTournament = findViewById(R.id.button5);

    }
}
