package kaewmod.hospitalroom;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Yoga14Activity extends AppCompatActivity {

    //Explicit
    private static final String urlYoutube = "https://www.youtube.com/watch?v=-JqzVcRmQdI&feature=youtu.be";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga14);

        button = (Button) findViewById(R.id.yo14); //ID
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlYoutube));
                startActivity(intent);


            }
        });
    } //Main Method

    public void clickHomeYogaBack (View view) {
        startActivity(new Intent(Yoga14Activity.this,HomeyogaActivity.class));

    }
}
