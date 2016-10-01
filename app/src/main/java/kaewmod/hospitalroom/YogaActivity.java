package kaewmod.hospitalroom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class YogaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        //Auto Intent
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(YogaActivity.this,HomeyogaActivity.class));
                finish();
            }
        },5000);
        MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),
                R.raw.intro_start_horse);
        mediaPlayer.start();


    }//Main Methon

    public void clickYoga(View view) {
        startActivity(new Intent(YogaActivity.this, HomeyogaActivity.class));
        finish();

    }

    public void clickYogaHome(View view) {
        finish();
    }
}
