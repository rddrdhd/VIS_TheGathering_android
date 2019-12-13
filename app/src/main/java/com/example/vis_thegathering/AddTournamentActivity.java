package com.example.vis_thegathering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class AddTournamentActivity extends AppCompatActivity {

    LinearLayout ll;
    TextView tw;
    EditText title, date, time, location, price, prize, type, note;
    String URI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tournament);

        ll=findViewById(R.id.tAddForm);
        tw = findViewById(R.id.tResponse);
        title=findViewById(R.id.tTitle);
        date = findViewById(R.id.tDate);
        time = findViewById(R.id.tTime);
        location=findViewById(R.id.tLocation);
        price=findViewById(R.id.tPrice);
        prize=findViewById(R.id.tPrize);
        note=findViewById(R.id.tNote);
    }

    public void addTournament(View view){
        //"http://www.vis-zur0037.php5.cz/indexAPI.php/tournaments/new?tTitle=XXX&tDate=2019-12-13T23:58&tLocation=OVA&tPrize=&tPrice=&tType=restricted&tNote=Ahoj&tAuthorID=1
URI = "http://www.vis-zur0037.php5.cz/indexAPI.php/tournaments/new?" +
        "tTitle="+MainActivity.encodeValue(title.getText().toString())+"&" +
        "tDate="+date.getText()+"T"+time.getText()+"&" +
        "tLocation="+MainActivity.encodeValue(location.getText().toString())+"&" +
        "tPrize="+MainActivity.encodeValue(prize.getText().toString())+"&" +
        "tPrice="+price.getText()+"&" +
        "tType=restricted" +"&" +
        "tNote="+MainActivity.encodeValue(note.getText().toString())+"&" +
        "tAuthorID=1";

        Ion.with(getApplicationContext()).load(URI).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                ll.setVisibility(View.GONE);
                tw.setText(result);
            }
        });
    }
}
