package it.skinjobs.simpletodo;

import android.os.AsyncTask;

        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;

public class LoadTask extends AsyncTask<String, String, String> {

    private RemoteTaskDelegate delegate;
    private final String url = "";

    public LoadTask(RemoteTaskDelegate delegate) {
        this.delegate = delegate;
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
            urlConnection.setRequestMethod("POST");
            InputStream in = urlConnection.getInputStream();
            InputStreamReader isw = new InputStreamReader(in);
            int data = isw.read();
            while (data != -1) {
                result += (char) data;
                data = isw.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception: " + e.getMessage();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String json) {
        this.delegate.complete(json);
    }
}
