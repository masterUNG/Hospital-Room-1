package kaewmod.hospitalroom;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MenuActivity extends AppCompatActivity {


    //โค๊ดการแจ้งเตือนอยู่หน้านี้!!
    //Explicit
    private String[] loginStrings, nameMedicineStrings, timeUseStrings,
            dayStartStrings, monthStartStrings, yearStartStrings, MorningStrings,
            LunchStrings, DinnerStrings, SleepStrings, FoodStrings;
    private Button button;
    private Calendar calendar;
    private int dayCurrentAnInt, monthCurrentAnInt, yearCurrentAnInt;

    private ArrayList<String> nameMedicine3, timeUse3, dayStart3, monthStart3, yearStart3,
            Morning3, Lunch3, Dinner3, Sleep3, Food3;

    private ArrayList<String> nameMedicine1, timeUse1, dayStart1, monthStart1, yearStart1,
            Morning1, Lunch1, Dinner1, Sleep1, Food1;

    private ArrayList<String> nameMedicine2, timeUse2, dayStart2, monthStart2, yearStart2,
            Morning2, Lunch2, Dinner2, Sleep2, Food2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Bind Widget
        button = (Button) findViewById(R.id.button15);

        //Logo ตุกติก
        myAnimationLogo();

        //Get Intent    จะรู้ว่า  user คนไหน เข้ามาใช้
        loginStrings = getIntent().getStringArrayExtra("Login");

        //Setup Array
        setupArray();

        //Find Current Date
        findCurrentDate();


        //buttonController  ปุ่มที่ทำหน้าที่เพิ่มลูก
        addSonButtonController();


        //*******************************************
        //Check Notification
        //*******************************************

        //Find ID login
        Log.d("9decV1", "idLogin ==> " + loginStrings[0]);

        //myNotification
        myNotification();


    } //Main Method

    private void addSonButtonController() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, AddSon.class);
                intent.putExtra("Login", loginStrings);
                startActivity(intent);

            }
        });
    }

    private void findCurrentDate() {
        calendar = Calendar.getInstance();
        dayCurrentAnInt = calendar.get(Calendar.DAY_OF_MONTH);
        monthCurrentAnInt = calendar.get(Calendar.MONTH) + 1;
        yearCurrentAnInt = calendar.get(Calendar.YEAR);
    }

    private void myAnimationLogo() {
        ImageView img = (ImageView) findViewById(R.id.hospital);
        img.setBackgroundResource(R.drawable.logo_hospital);
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        frameAnimation.start();
    }

    private void setupArray() {
        nameMedicine1 = new ArrayList<String>();
        timeUse1 = new ArrayList<String>();
        dayStart1 = new ArrayList<String>();
        monthStart1 = new ArrayList<String>();
        yearStart1 = new ArrayList<String>();
        Morning1 = new ArrayList<String>();
        Lunch1 = new ArrayList<String>();
        Dinner1 = new ArrayList<String>();
        Sleep1 = new ArrayList<String>();
        Food1 = new ArrayList<String>();

        nameMedicine2 = new ArrayList<String>();
        timeUse2 = new ArrayList<String>();
        dayStart2 = new ArrayList<String>();
        monthStart2 = new ArrayList<String>();
        yearStart2 = new ArrayList<String>();
        Morning2 = new ArrayList<String>();
        Lunch2 = new ArrayList<String>();
        Dinner2 = new ArrayList<String>();
        Sleep2 = new ArrayList<String>();
        Food2 = new ArrayList<String>();

        nameMedicine3 = new ArrayList<String>();
        timeUse3 = new ArrayList<String>();
        dayStart3 = new ArrayList<String>();
        monthStart3 = new ArrayList<String>();
        yearStart3 = new ArrayList<String>();
        Morning3 = new ArrayList<String>();
        Lunch3 = new ArrayList<String>();
        Dinner3 = new ArrayList<String>();
        Sleep3 = new ArrayList<String>();
        Food3 = new ArrayList<String>();
    }

    private void myNotification() {

        try {

            SynMediciene synMediciene = new SynMediciene(MenuActivity.this, loginStrings[0]);
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
            LunchStrings = new String[jsonArray.length()];
            DinnerStrings = new String[jsonArray.length()];
            SleepStrings = new String[jsonArray.length()];
            FoodStrings = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                nameMedicineStrings[i] = jsonObject.getString("nameMedicine");
                timeUseStrings[i] = jsonObject.getString("timeUse");
                dayStartStrings[i] = jsonObject.getString("dayStart");
                monthStartStrings[i] = jsonObject.getString("monthStart");
                yearStartStrings[i] = jsonObject.getString("yearStart");
                MorningStrings[i] = jsonObject.getString("Morning");
                LunchStrings[i] = jsonObject.getString("Lunch");
                DinnerStrings[i] = jsonObject.getString("Dinner");
                SleepStrings[i] = jsonObject.getString("Sleep");
                FoodStrings[i] = jsonObject.getString("Food");


                //Check Year
                if ((Integer.parseInt(yearStartStrings[i])) >= yearCurrentAnInt) {

                    nameMedicine1.add(nameMedicineStrings[i]);
                    timeUse1.add(timeUseStrings[i]);
                    dayStart1.add(dayStartStrings[i]);
                    monthStart1.add(monthStartStrings[i]);
                    yearStart1.add(yearStartStrings[i]);
                    Morning1.add(MorningStrings[i]);
                    Lunch1.add(LunchStrings[i]);
                    Dinner1.add(DinnerStrings[i]);
                    Sleep1.add(SleepStrings[i]);
                    Food1.add(FoodStrings[i]);

                }   // if

            }   // for


            //Check Month
            for (int i = 0; i < nameMedicine1.size(); i++) {

                if ((Integer.parseInt(monthStart1.get(i))) >= monthCurrentAnInt) {

                    nameMedicine2.add(nameMedicine1.get(i));
                    timeUse2.add(timeUse1.get(i));
                    dayStart2.add(dayStart1.get(i));
                    monthStart2.add(monthStart1.get(i));
                    yearStart2.add(yearStart1.get(i));
                    Morning2.add(Morning1.get(i));
                    Lunch2.add(Lunch1.get(i));
                    Dinner2.add(Dinner1.get(i));
                    Sleep2.add(Sleep1.get(i));
                    Food2.add(Food1.get(i));

                }   // if

            }   // for


            //Check Day
            for (int i=0;i<nameMedicine2.size();i++) {

                if ((Integer.parseInt(dayStart2.get(i))) >= dayCurrentAnInt) {

                    nameMedicine3.add(nameMedicine2.get(i));
                    timeUse3.add(timeUse2.get(i));
                    dayStart3.add(dayStart2.get(i));
                    monthStart3.add(monthStart2.get(i));
                    yearStart3.add(yearStart2.get(i));
                    Morning3.add(Morning2.get(i));
                    Lunch3.add(Lunch2.get(i));
                    Dinner3.add(Dinner2.get(i));
                    Sleep3.add(Sleep2.get(i));
                    Food3.add(Food2.get(i));

                }

            }   //for

            Log.d("9decV1", "nameMedicine3  ==> " + nameMedicine3);

            int minDay = 31;

            for (int i=0;i<nameMedicine3.size();i++) {

                int i1 = Integer.parseInt(dayStart3.get(i));
                if (i1 < minDay) {
                    minDay = i1;
                } //if
            }   //for

            Log.d("9decV1", "minDay ==> " + minDay);
            int indexNoti = dayStart3.indexOf(Integer.toString(minDay));
            Log.d("9decV1", "indexNoti ==> " + indexNoti);

            Log.d("9decV2", "data Noti ==> " + dayStart3.get(indexNoti) +
                    "/" + monthStart3.get(indexNoti) +
                    "/" + yearStart3.get(indexNoti));

            setupDateForNoti(nameMedicine3.get(indexNoti),
                    timeUse3.get(indexNoti),
                    dayStart3.get(indexNoti),
                    monthStart3.get(indexNoti),
                    yearStart3.get(indexNoti),
                    Morning3.get(indexNoti),
                    Lunch3.get(indexNoti),
                    Dinner3.get(indexNoti),
                    Sleep3.get(indexNoti),
                    Food3.get(indexNoti));


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
        calendar.set(Calendar.MONTH, (Integer.parseInt(month) -1));
        calendar.set(Calendar.YEAR, Integer.parseInt(year));
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Random random = new Random();
        int intBroadcast = random.nextInt(1000);

        Intent intent = new Intent(getBaseContext(), MyReceive.class);

        Log.d("22decV2", "Start ==> " + day);

        intent.putExtra("Mediciene", nameMediciene);  /// ใส่ที่เหลือ หน้าแสดงแจ้งเตือนการกินยา
        intent.putExtra("Login", loginStrings);
        intent.putExtra("Start", day );
        intent.putExtra("MonthYear", ("/" + month + "/" + year));
        intent.putExtra("TimeUse", timeUser);
        intent.putExtra("Morning", morning);
        intent.putExtra("Lunch", lunch);
        intent.putExtra("Diner", diner);
        intent.putExtra("Sleep", sleep);
        intent.putExtra("Food", food);

        //เสียงแตือน
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(),
                intBroadcast, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);




    } //setupDate


    public void clickMenuBody(View view) {
        startActivity(new Intent(MenuActivity.this, NurseActivity.class));

    }

    public void clickMenuSave(View view) {
        startActivity(new Intent(MenuActivity.this, NoOkActivity.class));

    }

    public void clickMenuMadchin(View view) {
        Intent intent = new Intent(MenuActivity.this, DrugsaveActivity.class);
        intent.putExtra("Login", loginStrings);
        startActivity(intent);


    }

    public void clickMenuYoga(View view) {
        startActivity(new Intent(MenuActivity.this, YogaActivity.class));

    }

}   // Main Class


