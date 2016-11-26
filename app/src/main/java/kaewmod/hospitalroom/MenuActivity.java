package kaewmod.hospitalroom;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    private String[] loginStrings;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        button = (Button) findViewById(R.id.button15);



        ImageView img = (ImageView) findViewById(R.id.hospital);
        img.setBackgroundResource(R.drawable.logo_hospital);
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        frameAnimation.start();

        loginStrings = getIntent().getStringArrayExtra("Login");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, AddSon.class);
                intent.putExtra("Login", loginStrings);
                startActivity(intent);

            }
        });


    } //Main Method

    public void clickMenuBody (View view) {
        startActivity(new Intent(MenuActivity.this,NurseActivity.class));

    }

    public void clickMenuSave (View view) {
        startActivity(new Intent(MenuActivity.this,NoOkActivity.class));

    }

    public void clickMenuMadchin (View view) {
        Intent intent = new Intent(MenuActivity.this,DrugsaveActivity.class);
        intent.putExtra("Login", loginStrings);
        startActivity(intent);


    }

    public void clickMenuYoga (View view) {
        startActivity(new Intent(MenuActivity.this,YogaActivity.class));

    }
}


