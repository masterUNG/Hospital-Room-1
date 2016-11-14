package kaewmod.hospitalroom;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NurseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse);

        //logo_what
        ImageView img = (ImageView) findViewById(R.id.what);
        img.setBackgroundResource(R.drawable.logo_what);
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        frameAnimation.start();

    }
    public void clickNurseHead (View view) {
        startActivity(new Intent(NurseActivity.this,DiseaseheaderActivity.class));

    }
    public void clickNurseBody (View view) {
        startActivity(new Intent(NurseActivity.this,DiseasebodyActivity.class));

    }
    public void clickNurseLeg (View view) {
        startActivity(new Intent(NurseActivity.this,DiseaselegActivity.class));

    }
    public void clickNurseHomemenu (View view) {
        startActivity(new Intent(NurseActivity.this,MenuActivity.class));

    }
}
