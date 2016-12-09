package kaewmod.hospitalroom;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class AddSon extends AppCompatActivity {

    private ListView listView;
    private String[] loginStrings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_son);

        listView = (ListView) findViewById(R.id.livSon);
        loginStrings = getIntent().getStringArrayExtra("Login");



        //Create ListView
        ListAllSon listAllSon = new ListAllSon(AddSon.this);
        listAllSon.execute();

    } //Main Method

    private class EditSon extends AsyncTask<Void, Void, String>{


        private Context context;

        private String idSonString;


        public EditSon(Context context, String idSonString) {
            this.context = context;
            this.idSonString = idSonString;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (Boolean.parseBoolean(s)) {
                finish();
            } else {
                Toast.makeText(context, "Cannot Edit Son", Toast.LENGTH_SHORT).show();

            }

        }

        @Override
        protected String doInBackground(Void... voids) {


            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody requestBody = new FormEncodingBuilder()
                        .add("isAdd", "true")
                        .add("id", loginStrings[0])
                        .add("id_son", idSonString)
                        .build();
                Request.Builder builder = new  Request.Builder();
                Request request = builder.url("http://www.swiftcodingthai.com/mod/edit_son.php")
                        .post(requestBody).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();





            } catch (Exception e) {
                Log.d("26novV3", "e doIn ==> " + e.toString());
                return null;
            }

        }

    } //EditSon

    private class ListAllSon extends AsyncTask<Void, Void, String>{


        private Context context;
        private static final String jsonSTRING = "http://www.swiftcodingthai.com/mod/get_son_.php";


        public ListAllSon(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient= new OkHttpClient();
                RequestBody requestBody = new FormEncodingBuilder()
                        .add("isAdd", "true")
                        .add("Type", "1")
                        .build();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(jsonSTRING).post(requestBody).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();



            } catch (Exception e) {
                Log.d("26novV2", "e doIn ==> " + e.toString());
                return null;

            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("26novV2", "JSON ==> " + s);

            try {

                JSONArray jsonArray = new JSONArray(s);
                final String[] userString = new String[jsonArray.length()];
                final String[] idSonStrings = new String[jsonArray.length()];

                for (int i=0;i<jsonArray.length();i++){

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    userString[i] = jsonObject.getString("User");
                    idSonStrings[i] = jsonObject.getString("id");



                } //for

                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(context,
                        android.R.layout.simple_list_item_1, userString);
                listView.setAdapter(stringArrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        comfirmSon(idSonStrings[i], userString[i]);

                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        private void comfirmSon(final String idSonString, String userString) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(false);
            builder.setIcon(R.drawable.tokjai);
            builder.setTitle(userString);
            builder.setMessage("You Choose" + userString);
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();

                }
            });
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    EditSon editSon = new EditSon(context, idSonString);
                    editSon.execute();

                    dialogInterface.dismiss();

                }
            });
            builder.show();


        }
    } //ListAllSon Class


} //Main Class
