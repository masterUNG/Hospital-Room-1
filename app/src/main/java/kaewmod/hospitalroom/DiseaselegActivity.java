package kaewmod.hospitalroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DiseaselegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseaseleg);
    }
    public void clickMenuNurseLeg (View view) {
        startActivity(new Intent(DiseaselegActivity.this,NurseActivity.class));

    }
}
