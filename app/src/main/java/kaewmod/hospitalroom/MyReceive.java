package kaewmod.hospitalroom;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by IT on 9/12/2559.
 */

public class MyReceive extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent1 = new Intent(context, ShowNotification.class);

        intent1.putExtra("Mediciene", intent.getStringExtra("Mediciene"));
        intent1.putExtra("Start", intent.getStringExtra("Start"));
        intent1.putExtra("MonthYear", intent.getStringExtra("MonthYear"));
        intent1.putExtra("TimeUse", intent.getStringExtra("TimeUse"));
        intent1.putExtra("Morning", intent.getStringExtra("Morning"));
        intent1.putExtra("Lunch", intent.getStringExtra("Lunch"));
        intent1.putExtra("Diner", intent.getStringExtra("Diner"));
        intent1.putExtra("Sleep", intent.getStringExtra("Sleep"));
        intent1.putExtra("Food", intent.getStringExtra("Food"));


        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);


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

} //Main Class
