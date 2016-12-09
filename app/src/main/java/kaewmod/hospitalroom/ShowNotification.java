package kaewmod.hospitalroom;

import android.app.Notification;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.TextView;

public class ShowNotification extends AppCompatActivity {
    //Explicit
    private TextView medicieneTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notification);

        //Bind Widget
        medicieneTextView = (TextView) findViewById(R.id.textView21);


        showNoti();

        medicieneTextView.setText(getIntent().getStringExtra("Mediciene"));

    } //Main Method

    private void showNoti() {
        Uri uri = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(ShowNotification.this);
        builder.setSmallIcon(R.drawable.tokjai);
        builder.setTicker("Hospital Room");
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("เตือนทานยา"); //แก้ เปลี่ยน eng
        builder.setContentText("กรุณาทานยาค่ะ");
        builder.setAutoCancel(false);
        builder.setSound(uri);


        Notification notification = builder.build();



        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notification.flags |= Notification.FLAG_AUTO_CANCEL;


        notificationManager.notify(1000, notification);


    }


} //Main Class
