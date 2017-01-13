package kaewmod.hospitalroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class SonService extends AppCompatActivity {

    //Explicit
    private String[] loginStrings;
    private TextView textView;
    private ListView listView;
    private String idMotherString;// นี่คือ id ของแม่

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son_service);


        //bind Widget
        textView = (TextView) findViewById(R.id.textView22);
        listView = (ListView) findViewById(R.id.livMedicieneSon);


        loginStrings = getIntent().getStringArrayExtra("Login");

        Log.d("9decV1", "idLogin ==> " + loginStrings[0]);  // หมายถึง id ของลูก


        try {

            SynMother synMother = new SynMother(SonService.this, loginStrings[0]);
            synMother.execute();
            String s = synMother.get();
            Log.d("9decV1", "JSON ==> " + s);

            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            idMotherString = jsonObject.getString("id");
            Log.d("13janV3", "id ของลูก ==> " + loginStrings[0]);
            Log.d("13janV3", "id ของแม่ ==> " + idMotherString);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }   // Main Method

}   // Main Class
