package kaewmod.hospitalroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class YogaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);
    }

    public void clickYoga(View view) {
        startActivity(new Intent(YogaActivity.this, HomeyogaActivity.class));

    }

    public void clickYogaHome(View view) {
        startActivity(new Intent(YogaActivity.this, MenuActivity.class));
    }
}
