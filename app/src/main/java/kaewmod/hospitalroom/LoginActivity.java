package kaewmod.hospitalroom;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText,passwordEditText;
    private String userString,passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Bind Widget
        userEditText = (EditText)findViewById(R.id.editText4);
        passwordEditText = (EditText)findViewById(R.id.editText19);


    }//Main Methop



    public void  clickMyLogin (View view) {

        userString = userEditText.getText().toString().trim();
        passwordString= passwordEditText.getText().toString().trim();

        if (userString.equals("") || passwordString.equals("")) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "Have Space",
            "please fill All Every Blank");
        } else {
        }


    } //clickMyLogin
    public  void ClickCancal (View view) {
        finish();
    }

    public void clickAddNewUser(View view) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
    public void clickOKHomeMenu (View view) {
        startActivity(new Intent(LoginActivity.this,MenuActivity.class));
    }

} //main Class
