package kaewmod.hospitalroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Yoga07Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga07);
    }
    public void clickHomeYogaBack (View view) {
        startActivity(new Intent(Yoga07Activity.this,HomeyogaActivity.class));

    }
}
