package com.jirikrejci.jsonparsingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView tvOutout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOutout = (TextView) findViewById(R.id.tvOutput);





    }

    public void btnRunRequest_OnClick(View view) {

        HttpURLConnection httpURLConnection = null;

        try {
            URL url = new URL("android.studio.com");
            httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.connect();
            InputStream inputStream =  httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            StringBuffer strBuff = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                strBuff.append(line);
            }

            tvOutout.setText(strBuff.toString());


        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        finally {
            if (httpURLConnection != null) httpURLConnection.disconnect();
        }
    }
}
