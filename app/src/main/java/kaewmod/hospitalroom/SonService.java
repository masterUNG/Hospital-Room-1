package kaewmod.hospitalroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SonService extends AppCompatActivity {

    //Explicit
    private String[] loginStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son_service);

        loginStrings = getIntent().getStringArrayExtra("Login");

        Log.d("9decV1", "idLogin ==> " + loginStrings[0]);

    }   // Main Method

}   // Main Class
