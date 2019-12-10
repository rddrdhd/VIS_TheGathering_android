package com.example.vis_thegathering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class AddAdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ad);
        try {
            URL yahoo = new URL("http://vis-zur0037.php5.cz/indexAPI.php/ads/new?aTitle=title&aType=card&aCardId=234&aQuantity=2&aPrice=12&aNote=Ahoj");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yahoo.openStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null)
                Log.e("errNot", inputLine);

            in.close();
        }
        catch (Exception e) {
            Log.e("err",e.toString());
        }
    }
}
//Boolean switchState = simpleSwitch.isChecked();