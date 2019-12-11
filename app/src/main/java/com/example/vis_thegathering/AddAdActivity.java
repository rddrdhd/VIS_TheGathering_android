package com.example.vis_thegathering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class AddAdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ad);

        Ion.with(getApplicationContext()).load("http://www.vis-zur0037.php5.cz/indexAPI.php/decks").asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {

                Log.e("notErr", result);
            }
        });

    }
}
//Boolean switchState = simpleSwitch.isChecked();