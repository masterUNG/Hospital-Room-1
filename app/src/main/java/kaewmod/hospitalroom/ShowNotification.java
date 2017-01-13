package kaewmod.hospitalroom;

import android.app.Notification;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class ShowNotification extends AppCompatActivity {
    //Explicit
    private TextView medicieneTextView, startTextView, endTextView, foodTextView;
    private RadioButton morningRadioButton, lunchRadioButton,
            dinerRadioButton, sleepRadioButton;
    private Button button;
    private String[] columnStrings = new String[]{
            "Mediciene",
            "TimeUse",
            "Start",
            "MonthYear",
            "Year",
            "Morning",
            "Lunch",
            "Diner",
            "Sleep",
            "Food"};
    private String[] strings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notification);

        //Bind Widget
        bindWidget();

        //Get Value From Intent
        getValueFromIntent();

        //Show View
        showView();

        showNoti();




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });


    } //Main Method

    private void showView() {

        //ชื่อยา
        medicieneTextView.setText(strings[0]);
        startTextView.setText(strings[2] + strings[3]);
        endTextView.setText(Integer.toString(Integer.parseInt(strings[1]) + Integer.parseInt(strings[2])) + strings[3]);



    }   // showView

    private void bindWidget() {

        medicieneTextView = (TextView) findViewById(R.id.textView21);
        startTextView = (TextView) findViewById(R.id.textView26);
        endTextView = (TextView) findViewById(R.id.textView27);
        foodTextView = (TextView) findViewById(R.id.textView29);
        morningRadioButton = (RadioButton) findViewById(R.id.radioButton12);
        lunchRadioButton = (RadioButton) findViewById(R.id.radioButton13);
        dinerRadioButton = (RadioButton) findViewById(R.id.radioButton14);
        sleepRadioButton = (RadioButton) findViewById(R.id.radioButton15);
        button = (Button) findViewById(R.id.button16);

    }

    private void getValueFromIntent() {

//        String strStart = getIntent().getStringExtra("Start");
//        Log.d("22decV2", "strStart ==> " + strStart);
//        String strMonthYear = getIntent().getStringExtra("MonthYear");
//        TextView startTextView = (TextView) findViewById(R.id.textView26);
//        startTextView.setText("Start = " + strStart + strMonthYear);
//
//        medicieneTextView.setText("Mediciene = " + getIntent().getStringExtra("Mediciene"));

        strings = new String[columnStrings.length];

        for (int i = 0; i < columnStrings.length; i++) {

            strings[i] = getIntent().getStringExtra(columnStrings[i]);
            Log.d("13janV2", "strings(" + i + ")==> " + strings[i]);

        }   //for


    }   // getValue

    private void showNoti() {
        Uri uri = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(ShowNotification.this);
        builder.setSmallIcon(R.drawable.alert);
        builder.setTicker("Hospital Room");
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("Alert Medicine"); //แก้ เปลี่ยน eng
        builder.setContentText("Please take medicine");
        builder.setAutoCancel(false);
        builder.setSound(uri);


        Notification notification = builder.build();


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notification.flags |= Notification.FLAG_AUTO_CANCEL;


        notificationManager.notify(1000, notification);


    }


} //Main Class
