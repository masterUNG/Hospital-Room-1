package kaewmod.hospitalroom;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class SonService extends AppCompatActivity {

    //Explicit


    private ListView listView;
    private String idMotherString;// นี่คือ id ของแม่
    private String nameMotherString;
    private Calendar calendar;
    private int dayCurrentAnInt, monthCurrentAnInt, yearCurrentAnInt;
    private String[] loginStrings, nameMedicineStrings, timeUseStrings,
            dayStartStrings, monthStartStrings, yearStartStrings, MorningStrings,
            LunchStrings, DinnerStrings, SleepStrings, FoodStrings, MyDateStrings;

    private String[] startStrings, endStrings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son_service);


        //bind Widget

        listView = (ListView) findViewById(R.id.livMedicieneSon);


        loginStrings = getIntent().getStringArrayExtra("Login");

        Log.d("9decV1", "idLogin ==> " + loginStrings[0]);  // หมายถึง id ของลูก


        try {

            SynMother synMother = new SynMother(SonService.this, loginStrings[0]);
            synMother.execute();
            String s = synMother.get();
            Log.d("9decV1", "JSON ==> " + s);

            JSONArray jsonArray = new JSONArray(s);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            idMotherString = jsonObject.getString("id");
            nameMotherString = jsonObject.getString("User");
            Log.d("13janV3", "id ของลูก ==> " + loginStrings[0]);
            Log.d("13janV3", "id ของแม่ ==> " + idMotherString);
            Log.d("13janV3", "ชื่อแม่ ==> " + nameMotherString);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Find Current Date
        findCurrentDate();

        //myNotification
        myNotification();

        //Create ListView
        createListView();


    }   // Main Method

    private void createListView() {

        SonAdapter sonAdapter = new SonAdapter(SonService.this,
                nameMotherString, nameMedicineStrings, startStrings, endStrings,
                MorningStrings, LunchStrings, DinnerStrings, SleepStrings, FoodStrings);
        listView.setAdapter(sonAdapter);

    }   // createListView

    private void findCurrentDate() {
        calendar = Calendar.getInstance();
        dayCurrentAnInt = calendar.get(Calendar.DAY_OF_MONTH);
        monthCurrentAnInt = calendar.get(Calendar.MONTH) + 1;
        yearCurrentAnInt = calendar.get(Calendar.YEAR);
    }

    private void myNotification() {

        try {

            SynMediciene synMediciene = new SynMediciene(SonService.this, idMotherString);
            synMediciene.execute();
            String strJSON = synMediciene.get();
            Log.d("9decV1", "JSON ==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);

            nameMedicineStrings = new String[jsonArray.length()];
            timeUseStrings = new String[jsonArray.length()];
            dayStartStrings = new String[jsonArray.length()];
            monthStartStrings = new String[jsonArray.length()];
            yearStartStrings = new String[jsonArray.length()];
            MorningStrings = new String[jsonArray.length()];
            MyDateStrings = new String[jsonArray.length()];
            LunchStrings = new String[jsonArray.length()];
            DinnerStrings = new String[jsonArray.length()];
            SleepStrings = new String[jsonArray.length()];
            FoodStrings = new String[jsonArray.length()];
            startStrings = new String[jsonArray.length()];
            endStrings = new String[jsonArray.length()];


            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                nameMedicineStrings[i] = jsonObject.getString("nameMedicine");
                timeUseStrings[i] = jsonObject.getString("timeUse");
                dayStartStrings[i] = jsonObject.getString("dayStart");
                monthStartStrings[i] = jsonObject.getString("monthStart");
                yearStartStrings[i] = jsonObject.getString("yearStart");
                MyDateStrings[i] = jsonObject.getString("MyDate");
                MorningStrings[i] = jsonObject.getString("Morning");
                LunchStrings[i] = jsonObject.getString("Lunch");
                DinnerStrings[i] = jsonObject.getString("Dinner");
                SleepStrings[i] = jsonObject.getString("Sleep");
                FoodStrings[i] = jsonObject.getString("Food");
                startStrings[i] = dayStartStrings[i] + "/" + monthStartStrings[i] +
                        "/" + yearStartStrings[i];
                endStrings[i] = Integer.toString(Integer.parseInt(dayStartStrings[i]) +
                        Integer.parseInt(timeUseStrings[i])) + "/" + monthStartStrings[i] +
                        "/" + yearStartStrings[i];


            }   // for

            Calendar calendar = Calendar.getInstance();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = dateFormat.format(calendar.getTime());
            Log.d("13janV3", "current Date ==> " + currentDate);

            Date myCurrentDate = new Date(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

            boolean b = true;

            for (int i = 0; i < MyDateStrings.length; i++) {

                Date date = new Date(Integer.parseInt(yearStartStrings[i]),
                        Integer.parseInt(monthStartStrings[i]) - 1,
                        Integer.parseInt(dayStartStrings[i]));

                if (myCurrentDate.before(date) && b) {
                    b = false;
                    Log.d("13janV1", "i ==> " + i);
                    Log.d("13janV3", "date ที่เตือน ==> " + date.toString());
                    Log.d("13janV1", "Medicent ==> " + nameMedicineStrings[i]);

                    setupDateForNoti(nameMedicineStrings[i], timeUseStrings[i],
                            dayStartStrings[i], monthStartStrings[i], yearStartStrings[i],
                            MorningStrings[i], LunchStrings[i], DinnerStrings[i],
                            SleepStrings[i], FoodStrings[i]);

                }   //if


            }   // for


        } catch (Exception e) {
            Log.d("9decV1", "e myNoti ==> " + e.toString());
        }

    }   // myNotification

    private void setupDateForNoti(String nameMediciene,
                                  String timeUser,
                                  String day,
                                  String month,
                                  String year,
                                  String morning,
                                  String lunch,
                                  String diner,
                                  String sleep,
                                  String food) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
        calendar.set(Calendar.MONTH, (Integer.parseInt(month) - 1));
        calendar.set(Calendar.YEAR, Integer.parseInt(year));
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Log.d("13janV1", "เวลาที่จะ Notification ==> " + calendar.getTime().toString());

        Random random = new Random();
        int intBroadcast = random.nextInt(1000);

        Intent intent = new Intent(getBaseContext(), MyReceive.class);

        Log.d("22decV2", "Start ==> " + day);

        intent.putExtra("Login", loginStrings);
        intent.putExtra("Mediciene", nameMediciene);  /// ใส่ที่เหลือ หน้าแสดงแจ้งเตือนการกินยา
        intent.putExtra("TimeUse", timeUser);
        intent.putExtra("Start", day);
        intent.putExtra("MonthYear", ("/" + month + "/" + year));
        intent.putExtra("Year", year);
        intent.putExtra("Morning", morning);
        intent.putExtra("Lunch", lunch);
        intent.putExtra("Diner", diner);
        intent.putExtra("Sleep", sleep);
        intent.putExtra("Food", food);

        //เสียงแตือน
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(),
                intBroadcast, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);


    } //setupDate

}   // Main Class
