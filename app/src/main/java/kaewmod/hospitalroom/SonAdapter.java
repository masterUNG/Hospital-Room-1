package kaewmod.hospitalroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by masterUNG on 1/13/2017 AD.
 */

public class SonAdapter extends BaseAdapter {

    //Explicit
    private Context context;
    private String motherNameString;
    private String[] nameMedicineStrings, startStrings, endStrings, morningStrings,
            lunchStrings, dinnerStrings, sleepStrings, foodStrings;

    private TextView motherTextView, medicineTextView, startTextView, endTextView, morningTextView,
            lunchTextView, dinnerTextView, sleepTextView, foodTextView;

    public SonAdapter(Context context,
                      String motherNameString,
                      String[] nameMedicineStrings,
                      String[] startStrings,
                      String[] endStrings,
                      String[] morningStrings,
                      String[] lunchStrings,
                      String[] dinnerStrings,
                      String[] sleepStrings,
                      String[] foodStrings) {
        this.context = context;
        this.motherNameString = motherNameString;
        this.nameMedicineStrings = nameMedicineStrings;
        this.startStrings = startStrings;
        this.endStrings = endStrings;
        this.morningStrings = morningStrings;
        this.lunchStrings = lunchStrings;
        this.dinnerStrings = dinnerStrings;
        this.sleepStrings = sleepStrings;
        this.foodStrings = foodStrings;
    }

    @Override
    public int getCount() {
        return nameMedicineStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_son_listview, viewGroup, false);

        //Bind Widget
        motherTextView = (TextView) view1.findViewById(R.id.textView25);
        medicineTextView = (TextView) view1.findViewById(R.id.textView30);
        startTextView = (TextView) view1.findViewById(R.id.textView46);
        endTextView = (TextView) view1.findViewById(R.id.textView31);
        morningTextView = (TextView) view1.findViewById(R.id.textView48);
        lunchTextView = (TextView) view1.findViewById(R.id.textView56);
        dinnerTextView = (TextView) view1.findViewById(R.id.textView57);
        sleepTextView = (TextView) view1.findViewById(R.id.textView58);
        foodTextView = (TextView) view1.findViewById(R.id.textView23);

        //Show View
        morningTextView.setText(motherNameString);
        medicineTextView.setText(nameMedicineStrings[i]);
        startTextView.setText(startStrings[i]);
        endTextView.setText(endStrings[i]);
        morningTextView.setText(morningStrings[i]);
        lunchTextView.setText(lunchStrings[i]);
        dinnerTextView.setText(dinnerStrings[i]);
        sleepTextView.setText(sleepStrings[i]);
        foodTextView.setText(foodStrings[i]);


        return view1;
    }
}   // Main Class
