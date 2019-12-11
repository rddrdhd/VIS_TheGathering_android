package com.example.vis_thegathering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
//import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class AddAdActivity extends AppCompatActivity {


    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private boolean isVerified = false;

    TextView tw;
    LinearLayout ll;
    EditText title, cardId, quantity, price, note;
    ImageView imageView;
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
        imageView=findViewById(R.id.aPhotoTaken);
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
                String s = isVerified?"Verified a":"A"+"d added:  "+result;
                tw.setText(s);
                Log.e("notErr", result);
            }
        });
    }

    public void verifyCard(View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
            } else {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(this, "camera permission denied ("+grantResults[0]+", "+MY_CAMERA_PERMISSION_CODE+")", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            isVerified = true;
        }
    }
}
//Boolean switchState = simpleSwitch.isChecked();