package kaewmod.hospitalroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Yoga02Activity extends AppCompatActivity {

    //Explicit
    private static final String urlYoutube = "https://youtu.be/h2nIHSgQ2Bs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga02);
    }
    public void clickHomeYogaBack (View view) {
        finish();

    }

}
