package com.example.vis_thegathering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class AddAdActivity extends AppCompatActivity {
 TextView tw;
 LinearLayout ll;

 EditText title, cardId, quantity, price, note;
 //Switch type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ad);

        ll= findViewById(R.id.aAddForm);
        tw = findViewById(R.id.aResponse);
        
        title=findViewById(R.id.aTitle);
        //type=findViewById(R.id.aTypeSwitch);
        cardId=findViewById(R.id.aCardIdNum);
        quantity=findViewById(R.id.aQuantityNum);
        price=findViewById(R.id.aPriceNum);
        note=findViewById(R.id.aNote);
    }

    public void addAd(View view){
        //"http://www.vis-zur0037.php5.cz/indexAPI.php/ads/new?aTitle=title&aType=card&aCardId=234&aQuantity=2&aPrice=12&aNote=Ahoj"
        String URI = "http://www.vis-zur0037.php5.cz/indexAPI.php/ads/new" + "?" +
                "aTitle=" + title.getText() + "&" +
                "aType=card&" +
                "aCardId="+cardId.getText() +"&" +
                "aQuantity="+quantity.getText() + "&" +
                "aPrice="+price.getText()+"&" +
                "aNote="+note.getText() + "";
        Ion.with(getApplicationContext()).load(URI).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                ll.setVisibility(View.GONE);
                tw.setText(result);
                Log.e("notErr", result);
            }
        });
    }
}
//Boolean switchState = simpleSwitch.isChecked();