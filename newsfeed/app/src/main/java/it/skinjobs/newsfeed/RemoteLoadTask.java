package it.skinjobs.newsfeed;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RemoteLoadTask extends AsyncTask<String, String, String> {

    private TaskDelegate delegate;
    private final String url = "https://api.m3o.com/v1/news/Headlines";
    private final String apiKey = "NTA5OGZkZjktNDA4Zi00YzcxLTgzNDUtMGMxNTg1MjMxYzFh";
    private final String json = "{\n" +
            "  \"language\": \"it\",\n" +
            "  \"locale\": \"it\"\n" +
            "}";
    private boolean error;
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public RemoteLoadTask(TaskDelegate delegate) {
        this.delegate = delegate;
        this.error = false;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(this.json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + this.apiKey)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            this.error = true;
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        if (this.error) {
            delegate.error(s);
        } else {
            try {
                delegate.complete(s);
            } catch (Exception e) {
                delegate.error(e.getMessage());
            }

        }
    }
}
