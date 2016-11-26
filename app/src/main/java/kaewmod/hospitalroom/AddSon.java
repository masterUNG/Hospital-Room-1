package kaewmod.hospitalroom;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class AddSon extends AppCompatActivity {

    private ListView listView;
    private String loginString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_son);

        listView = (ListView) findViewById(R.id.livSon);


        //Create ListView
        ListAllSon listAllSon = new ListAllSon(AddSon.this);
        listAllSon.execute();

    } //Main Method

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


        }
    } //ListAllSon Class


} //Main Class
