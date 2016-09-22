package kaewmod.hospitalroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DiseaseheaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseaseheader);
    }
    public void clickMenuNurseHead (View view) {
        startActivity(new Intent(DiseaseheaderActivity.this,NurseActivity.class));

    }
    public void clickDisHead1 (View view) {
        startActivity(new Intent(DiseaseheaderActivity.this,DisbodyActivity.class));

    }
}
