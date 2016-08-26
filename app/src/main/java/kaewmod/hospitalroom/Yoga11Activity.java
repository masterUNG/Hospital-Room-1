package kaewmod.hospitalroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Yoga11Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga11);
    }
    public void clickHomeYogaBack (View view) {
        startActivity(new Intent(Yoga11Activity.this,HomeyogaActivity.class));

    }
}
