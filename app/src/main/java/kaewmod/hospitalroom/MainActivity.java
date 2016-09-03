package kaewmod.hospitalroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText nameEditText, password1EditText, password2EditText;
    private String nameString, password1String, password2String;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        nameEditText = (EditText) findViewById(R.id.editText);
        password1EditText = (EditText) findViewById(R.id.editText2);
        password2EditText = (EditText) findViewById(R.id.editText3);



    } //Main Method

    public void clickSaveData(View view) {

        nameString = nameEditText.getText().toString().trim();
        password1String = password1EditText.getText().toString().trim();
        password2String = password2EditText.getText().toString().trim();


        //Check Space
        if (checkSpace()) {
            //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกทุกช่อง ค่ะ");
        }

    } //ClickSavedata

    private boolean checkSpace() {
        return nameString.equals("")||
                password1String.equals("")||
                password2String.equals("");

    }


} //Main Class
