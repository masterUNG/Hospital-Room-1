package kaewmod.hospitalroom;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by masterUNG on 12/9/2016 AD.
 */

public class SynMediciene extends AsyncTask<Void, Void, String>{

    //Explicit
    private Context context;
    private String idString;
    private static final String urlPHP = "http://swiftcodingthai.com/mod/get_mediciene_where_id.php";

    public SynMediciene(Context context, String idString) {
        this.context = context;
        this.idString = idString;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("id", idString)
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            Log.d("9decV1", "e doIn ==> " + e.toString());
            return null;
        }


    }
}   // Main Class
