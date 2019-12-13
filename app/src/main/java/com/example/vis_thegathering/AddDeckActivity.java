package com.example.vis_thegathering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class AddDeckActivity extends AppCompatActivity {

    SeekBar sbCount;
    int cardsCount;
    LinearLayout llCards, llDeckForm;
    TextView twResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_deck);

        sbCount = findViewById(R.id.seekBarCardsCount);
        llCards = findViewById(R.id.linearLayoutCards);
        llDeckForm = findViewById(R.id.dAddForm);
        twResult = findViewById(R.id.dResponse);

        sbCount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardsCount = progress;
                if(cardsCount < llCards.getChildCount()){

                    for(int i = cardsCount; i<llCards.getChildCount(); i++){
                        llCards.removeViewAt(i);
                    }

                } else if(llCards.getChildCount() < cardsCount){

                    for(int i = llCards.getChildCount(); i < cardsCount; i++){
                        EditText et = new EditText(getApplicationContext());
                        et.setHint((i+1)+". card multiverseID");
                        et.setId(i);
                        et.setInputType(InputType.TYPE_CLASS_NUMBER);
                        llCards.addView(et);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),
                        cardsCount+" cards", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void addDeck(View view){
        llDeckForm.setVisibility(View.INVISIBLE);

    }

}
