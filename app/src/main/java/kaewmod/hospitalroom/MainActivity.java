package kaewmod.hospitalroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText nameEditText, password1EditText, password2EditText;
    private String nameString, password1String, password2String, mainString, sexString;
    private RadioGroup mainRadioGroup, sexRadioGroup;
    private RadioButton main1RadioButton, main2RadioButton,
            maleRadioButton, femaleRadioButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        nameEditText = (EditText) findViewById(R.id.editText);
        password1EditText = (EditText) findViewById(R.id.editText2);
        password2EditText = (EditText) findViewById(R.id.editText3);
        mainRadioGroup = (RadioGroup) findViewById(R.id.ragmain);
        sexRadioGroup = (RadioGroup) findViewById(R.id.regSex);
        main1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        main2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        maleRadioButton = (RadioButton) findViewById(R.id.radioButton3);
        femaleRadioButton = (RadioButton) findViewById(R.id.radioButton4);

        //Create Main Radio Controler
        mainRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton:
                        mainString = "0";
                        break;
                    case R.id.radioButton2:
                        mainString = "1";
                        break;

                }
            }
        });
        //Create Sex Radio Controller
        sexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton3:
                        sexString = "male";
                        break;
                    case R.id.radioButton4:
                        sexString = "female";
                        break;
                }
            }
        });











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
