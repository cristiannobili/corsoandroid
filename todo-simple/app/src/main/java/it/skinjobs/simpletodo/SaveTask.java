package it.skinjobs.simpletodo;

import android.os.AsyncTask;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SaveTask extends AsyncTask<String, String, String> {

    private RemoteTaskDelegate delegate;
    private final String url = "";
    private String json;

    public SaveTask(RemoteTaskDelegate delegate, String json) {
        this.delegate = delegate;
        this.json = json;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String result = "";
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(this.url);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                OutputStream outputStream = urlConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                bufferedWriter.write(this.json);

                InputStream in = urlConnection.getInputStream();
                InputStreamReader isw = new InputStreamReader(in);
                int data = isw.read();
                while (data != -1) {
                    result += (char) data;
                    data = isw.read();
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Exception: " + e.getMessage();
        }
        return result;

    }

    @Override
    protected void onPostExecute(String s) {
        LoadTask loadTask = new LoadTask(this.delegate);
        loadTask.execute();
    }
}
