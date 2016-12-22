package kaewmod.hospitalroom;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by masterUNG on 12/22/2016 AD.
 */

public class SynMother extends AsyncTask<Void, Void, String>{

    //Explicit
    private static final String urlPHP = "http://swiftcodingthai.com/mod/get_mother_where_id.php";
    private Context context;
    private String id_sonString;

    public SynMother(Context context, String id_sonString) {
        this.context = context;
        this.id_sonString = id_sonString;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("id_son", id_sonString)
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}   // Main Class
