package it.skinjobs.newsfeed;

import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

// questa classe rappresenta il modello dati dell'applicazione
// di cui quello dell'adapter è una copia
// contiene i dati del modello (le todo) e i metodi per modificarla
// implementa l'interfaccia item delegate, per impedire la dipendenza reciproca con l'adapter
public class NewsViewModel implements TaskDelegate, Observer {

    ArrayList<News> newsList;
    RecyclerViewAdapter adapter;

    public NewsViewModel(RecyclerViewAdapter adapter) {
        this.adapter = adapter;
        Subject.getInstance().addObserver(this, "reload");
        refresh();
    }

    private void refresh() {
        RemoteLoadTask loadTask = new RemoteLoadTask(this);
        loadTask.execute();
    }

    @Override
    public void complete(String json) throws Exception {
        this.newsList = new ArrayList<>();
        JSONObject root = new JSONObject(json);
        JSONArray array = root.getJSONArray("articles");
        for(int i=0; i< array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            News news = new News(
                    object.getString("title"),
                    object.getString("image_url"),
                    object.getString("url"));
            this.newsList.add(news);
        }
        this.adapter.update(this.newsList);
        Subject.getInstance().emitEvent("finish");
    }

    @Override
    public void error(String message) {

    }

    @Override
    public void update(String event) {
            this.adapter.update(new ArrayList<>());
            this.refresh();
    }
}
