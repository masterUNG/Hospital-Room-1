package kaewmod.hospitalroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class SonService extends AppCompatActivity {

    //Explicit
    private String[] loginStrings;
    private TextView textView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son_service);


        //bind Widget
        textView = (TextView) findViewById(R.id.textView22);
        listView = (ListView) findViewById(R.id.livMedicieneSon);


        loginStrings = getIntent().getStringArrayExtra("Login");

        Log.d("9decV1", "idLogin ==> " + loginStrings[0]);


        try {

            SynMother synMother = new SynMother(SonService.this, loginStrings[0]);
            synMother.execute();
            String s = synMother.get();
            Log.d("9decV1", "JSON ==> " + s);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }   // Main Method

}   // Main Class
