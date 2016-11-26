package kaewmod.hospitalroom;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.util.Calendar;

public class DrugsaveActivity extends AppCompatActivity {

    //Explicit
    private EditText nameMedicientEditText, timeUserEditText,
            dayEditText, monthEditText, yearEditText;
    private RadioGroup radioGroup;
    private RadioButton morningRadioButton, lunchRadioButton, dinnerRadioButton,
            sleepRadioButton, beforeRadioButton, afterRadioButton;
    private Button button;
    private String idLoginString, nameMedicieneString, timeUserString,
            dayStartString, monthStartString, yearStartString, morningString = "0",
            lunchString = "0", dinnerString = "0", sleepString = "0", foodString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_save_medicine_layout);

        //Bind Widget
        bindWidget();

        String[] strings = getIntent().getStringArrayExtra("Login");
        idLoginString = strings[0];


        //Find Current Date
        currentDate();

        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Value From EditText
                nameMedicieneString = nameMedicientEditText.getText().toString().trim();
                timeUserString = timeUserEditText.getText().toString().toString();
                dayStartString = dayEditText.getText().toString().trim();
                monthStartString = monthEditText.getText().toString().trim();
                yearStartString = yearEditText.getText().toString().trim();

                //Check Space
                if (nameMedicieneString.equals("") ||
                        timeUserString.equals("") ||
                        dayStartString.equals("") ||
                        monthStartString.equals("") ||
                        yearStartString.equals("")) {
                    //Have Space

                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(DrugsaveActivity.this, "Have Space",
                            "Please Fill All Every Blank");

                } else if (morningRadioButton.isChecked()) {
                    morningString = "1";
                } else if (lunchRadioButton.isChecked()) {
                    lunchString = "1";
                } else if (dinnerRadioButton.isChecked()) {
                    dinnerString = "1";
                } else if (sleepRadioButton.isChecked()) {
                    sleepString = "1";
                } else if (!(morningRadioButton.isChecked() ||
                        lunchRadioButton.isChecked() ||
                        dinnerRadioButton.isChecked() ||
                        sleepRadioButton.isChecked())) {

                    radioAlert("Duration", "Please choose a time to eat");

                }

                if (beforeRadioButton.isChecked() || afterRadioButton.isChecked()) {
                    Log.d("29octV3", "True Check");

                    //Update To Server
                    AddMedicine addMedicine = new AddMedicine(DrugsaveActivity.this);
                    addMedicine.execute();



                } else {
                    Log.d("29octV3", "False Check");
                    radioAlert("Before meals or after meals่", "Eat before meals or after meals.");
                }





            }   // onClick
        });

        //Radio Group Controller
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {

                    case R.id.radioButton10: // Before
                        foodString = "0";
                        break;
                    case R.id.radioButton9:    // After
                        foodString = "1";
                        break;

                }   // switch

            }   // onCheck
        });


    }   // Main Method


    private class AddMedicine extends AsyncTask<Void, Void, String> {

        private Context context;
        private static final String urlPHP = "http://swiftcodingthai.com/mod/add_mediciene.php";


        public AddMedicine(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody requestBody = new FormEncodingBuilder()
                        .add("isAdd", "true")
                        .add("idLogin",idLoginString)
                        .add("nameMedicine",nameMedicieneString)
                        .add("timeUse",timeUserString)
                        .add("dayStart",dayStartString)
                        .add("monthStart",monthStartString)
                        .add("yearStart",yearStartString)
                        .add("Morning",morningString)
                        .add("Lunch",lunchString)
                        .add("Dinner",dinnerString)
                        .add("Sleep",sleepString)
                        .add("Food",foodString)
                        .build();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlPHP).post(requestBody).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();



            } catch (Exception e) {
                Log.d("26novV1", "e doIn ==>> " + e.toString());
                return null;

            }



        } //diInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (Boolean.parseBoolean(s)) {
                //True
                finish();
            }else {
                Toast.makeText(context, "Cannot Save Data", Toast.LENGTH_SHORT).show();


            }


        }
    } //AddMedicine

    private void radioAlert(String strTitle,
                            String strMessage) {

        //Non Choose RadioButton
        MyAlert myAlert = new MyAlert();
        myAlert.myDialog(DrugsaveActivity.this,
                strTitle, strMessage);
    }

    private void currentDate() {

        Calendar calendar = Calendar.getInstance();
        int intDay = calendar.get(Calendar.DAY_OF_MONTH);
        int intMonth = calendar.get(Calendar.MONTH) + 1;
        int intYear = calendar.get(Calendar.YEAR);

        dayEditText.setText(Integer.toString(intDay));
        monthEditText.setText(Integer.toString(intMonth));
        yearEditText.setText(Integer.toString(intYear));

    }   // currentDate

    private void bindWidget() {

        nameMedicientEditText = (EditText) findViewById(R.id.editText5);
        timeUserEditText = (EditText) findViewById(R.id.editText6);
        dayEditText = (EditText) findViewById(R.id.editText7);
        monthEditText = (EditText) findViewById(R.id.editText8);
        yearEditText = (EditText) findViewById(R.id.editText11);
        radioGroup = (RadioGroup) findViewById(R.id.ragFood);
        morningRadioButton = (RadioButton) findViewById(R.id.radioButton5);
        lunchRadioButton = (RadioButton) findViewById(R.id.radioButton6);
        dinnerRadioButton = (RadioButton) findViewById(R.id.radioButton7);
        sleepRadioButton = (RadioButton) findViewById(R.id.radioButton8);
        beforeRadioButton = (RadioButton) findViewById(R.id.radioButton9);
        afterRadioButton = (RadioButton) findViewById(R.id.radioButton10);
        button = (Button) findViewById(R.id.button35);


    }   // bindWidget

}   // Main Class