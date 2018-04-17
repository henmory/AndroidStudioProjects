package com.henmory.learnasnyctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
//import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    Button bt;
    TextView tv;
    Button bt_http_post;

//    HttpClient client; 已经不推荐使用了
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tv = (TextView) findViewById(R.id.tv_content);
        bt = (Button) findViewById(R.id.btn_get);
        bt_http_post = (Button) findViewById(R.id.btn_http_post);


        if (null != bt){
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DownLoad dl = new DownLoad(MainActivity.this);
                    dl.execute("http://www.baidu.com");

                }
            });
        }

        if (bt_http_post != null){
            bt_http_post.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    httpPostGetNet("http://fanyi.youdao.com/openapi.do");
                }
            });
        }

    }

    public void httpPostGetNet(String url){

        new AsyncTask<String, Void, Void>() {
            @Override
            protected Void doInBackground(String... params) {
                try {
                    URL url = new URL(params[0]);
                    URLConnection con = url.openConnection();
                    con.setDoInput(true);
                    con.setDoOutput(true);
//                                con.setRequestMethod("POST");

                    OutputStream os = con.getOutputStream();
                    OutputStreamWriter osw = new OutputStreamWriter(os);
                    BufferedWriter bw = new BufferedWriter(osw);
                    bw.write("keyfrom=mytesta&key=1528032227&type=data&doctype=xml&version=1.1&q=welcome");
                    bw.flush();

                    InputStream is = con.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String line;
                    StringBuffer sb = new StringBuffer();
                    while ((line = br.readLine()) != null){
                        sb.append(line);
                    }
                    System.out.println(sb.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute(url);

    }
    public class DownLoad extends AsyncTask<String, Integer, String >{

        Context mct;
        ProgressDialog pd;
        @Override
        protected String doInBackground(String... params) {
            URL url = null;
            InputStreamReader isr = null;
            String str;
            StringBuilder sb = new StringBuilder();
            Integer length = 0;
            try {
                url = new URL(params[0]);
                URLConnection connection = url.openConnection();
                length = connection.getContentLength();
                isr = new InputStreamReader(connection.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            BufferedReader br = new BufferedReader(isr);
            try {
                while((str = br.readLine()) != null){
                    sb.append(str);
                    Thread.sleep(2000);
                    length++;
                    publishProgress(length);
                }
                isr.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }

        @Override
        protected void onPreExecute() {
//            Toast.makeText(MainActivity.this, "开始调用", Toast.LENGTH_SHORT).show();
            pd = new ProgressDialog(mct);
            pd.setTitle("正在下载...");
            pd.setMessage("请稍等...");
            pd.setMax(1000);
            pd.setCancelable(true);
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.show();
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            tv.setText(s);
            super.onPostExecute(s);
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        public DownLoad(Context ct) {
            mct = ct;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pd.setProgress(values[0]);
            super.onProgressUpdate(values);
        }
    }


}
