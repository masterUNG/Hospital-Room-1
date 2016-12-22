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
import android.widget.TextView;

public class ShowNotification extends AppCompatActivity {
    //Explicit
    private TextView medicieneTextView, startTextView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notification);

        //Bind Widget
        medicieneTextView = (TextView) findViewById(R.id.textView21);
        button = (Button) findViewById(R.id.button16);


        showNoti();

        //Get Value From Intent
        getValueFromIntent();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });


    } //Main Method


//    intent.putExtra("Mediciene", nameMediciene);  /// ใส่ที่เหลือ หน้าแสดงแจ้งเตือนการกินยา
//    intent.putExtra("Login", loginStrings);
//    intent.putExtra("Start", day );
//    intent.putExtra("MonthYear", ("/" + month + "/" + year));
//    intent.putExtra("TimeUse", timeUser);
//    intent.putExtra("Morning", morning);
//    intent.putExtra("Lunch", lunch);
//    intent.putExtra("Diner", diner);
//    intent.putExtra("Sleep", sleep);
//    intent.putExtra("Food", food);


    private void getValueFromIntent() {

        String strStart = getIntent().getStringExtra("Start");
        Log.d("22decV2", "strStart ==> " + strStart);
        String strMonthYear = getIntent().getStringExtra("MonthYear");
        TextView startTextView = (TextView) findViewById(R.id.textView26);
        startTextView.setText("Start = " + strStart + strMonthYear);




        medicieneTextView.setText( "Mediciene = " + getIntent().getStringExtra("Mediciene"));


    }

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
