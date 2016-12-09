package kaewmod.hospitalroom;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by IT on 9/12/2559.
 */

public class MyReceive extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent1 = new Intent(context, ShowNotification.class);

        intent1.putExtra("Mediciene", intent.getStringExtra("Mediciene"));


        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);


    } //Main Method
} //Main Class
