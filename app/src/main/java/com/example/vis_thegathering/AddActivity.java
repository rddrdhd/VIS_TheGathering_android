package com.example.vis_thegathering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    public void addAd(View view){
        Intent i = new Intent(this, AddAdActivity.class);
        startActivity(i);
    }

    public void addDeck(View view){
        Intent i = new Intent(this, AddDeckActivity.class);
        startActivity(i);
    }

    public void addTournament(View view){
        Intent i = new Intent(this, AddTournamentActivity.class);
        startActivity(i);
    }
}
