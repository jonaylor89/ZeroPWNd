package com.saadeh.rasha.zeropwnd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public boolean scam = false;
    public TextView mTextView;
    EditText mEdit;
    String fakeResult = "";
    public String postUrl= "https://zeropwnd.herokuapp.com/";
    public String postBody;
    public int responseBody;

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ZeroPWNd");



    }
    public void getText(){
        EditText text = (EditText) findViewById(R.id.editText);
        postBody = text.getText().toString();
    }

    private void postRequest(String postUrl, String postBody) {

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, postBody);

        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                Log.d("TAG", tempResponse.body().string());
                 responseBody = parseResponse(response);




            }
        });
    }

    public void parseResponse(Response response) throws IOException {

        return (Integer.parseInt(Integer.toString(response.body().string().length())));


        //responseBody = response.body().string().length();
        //mTextView = (TextView) findViewById(R.id.text_results);
        //mTextView.setText("This website is safe");
        //String num = (String) (Integer.toString(response.body().string().length()));

>>>>>>> c7f9e259dabb51bad44f250fae178cfd39a7eab4:app/src/main/java/com/saadeh/rasha/zeropwnd/MainActivity.java
    }





    public void clickBtn(View view){

        EditText text = (EditText) findViewById(R.id.editText);
        postBody = text.getText().toString();
        mTextView = findViewById(R.id.text_results);

        if(responseBody == 11){

            mTextView.setText("This website is safe!");
        } else{
            mTextView.setText("This website is not safe");
        }
        try {
            postRequest(postUrl,postBody);
        } catch (Exception e) {
            e.printStackTrace();
        }





        //mTextView = (TextView) findViewById(R.id.text_results);
        //mTextView.setText("This website is safe");
//                        if (responseBody == 0){
//                    mTextView.setText("This website is safe");
//                } else{
//                    mTextView.setText("This website is not safe");
//                }
       // mTextView.setText("This website is safe");


//        mTextView = findViewById(R.id.text_results);
//        OkHttpClient client =  new OkHttpClient();
//        mEdit   = (EditText)findViewById(R.id.editText);
//        String url = "https://zeropwnd.herokuapp.com/";
//
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if(response.isSuccessful()){
//                    final String myresponse = response.body().string();
//
//                    MainActivity.this.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            mTextView.setText(myresponse);
//                        }
//                    });
//                }
//            }
//        });

    }




}
