package com.example.vis_thegathering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    Button calendarButt;

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
        calendarButt=findViewById(R.id.addToCalendar);
        calendarButt.setVisibility(View.GONE);
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
                calendarButt.setVisibility(View.VISIBLE);
            }
        });
    }
    public void addCalendarEvent(View view){


        String d = date.getText().toString().replaceAll("-","");
        String t = time.getText().toString().replaceAll(":","");
        String URL = "https://www.google.com/calendar/render?action=TEMPLATE&" +
                "text=" + title.getText() + "&" +
                "details=" + note.getText() + "&" +
                "location="+location.getText()+ "&" +
                "dates=" + d +
                "T" + t +
                "00Z%2F" +d+
                "T" + (Integer.parseInt(t)+200)+
                "00Z";


        Log.d("url",URL);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
        startActivity(browserIntent);
    }
}
