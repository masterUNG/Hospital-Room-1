package kaewmod.hospitalroom;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends LoginActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(HomeActivity.this, LoginActivity.class);
                HomeActivity.this.startActivity(splashIntent);
                HomeActivity.this.finish();
            }

        }, SPLASH_TIME_OUT);
    }}


