package kaewmod.hospitalroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Yoga14Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga14);
    }
    public void clickHomeYogaBack (View view) {
        startActivity(new Intent(Yoga14Activity.this,HomeyogaActivity.class));

    }
}
