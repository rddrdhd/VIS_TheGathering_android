package com.example.vis_thegathering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

public class AddDeckActivity extends AppCompatActivity {

    SeekBar sbCount;
    int cardsCount;
    LinearLayout llCards, llDeckForm;
    TextView twResult, twTitle;
    String URI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_deck);

        sbCount = findViewById(R.id.seekBarCardsCount);
        llCards = findViewById(R.id.linearLayoutCards);
        llDeckForm = findViewById(R.id.dAddForm);
        twResult = findViewById(R.id.dResponse);
        twTitle = findViewById(R.id.dTitle);

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
        //http://www.vis-zur0037.php5.cz/indexAPI.php/decks/new?deckTitle=ahoj&count=2&card1=123&card2=234

        ArrayList cards = new ArrayList<String>();

        EditText card;
        URI = "http://www.vis-zur0037.php5.cz/indexAPI.php/decks/new" + "?" +
                "deckTitle=" + twTitle.getText() +"&count=" +Integer.toString(cardsCount);

        for(int i = 0; i<cardsCount; i++){
            card = findViewById(i);
            URI+="&card"+(i+1)+"="+card.getText();
        }
        Ion.with(getApplicationContext()).load(URI).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {

                twResult.setText(result);
                llDeckForm.setVisibility(View.INVISIBLE);
            }
        });

    }

}
