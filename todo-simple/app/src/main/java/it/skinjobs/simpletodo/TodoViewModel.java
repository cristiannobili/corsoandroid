package it.skinjobs.simpletodo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// questa classe rappresenta il modello dati dell'applicazione
// di cui quello dell'adapter è una copia
// contiene i dati del modello (le todo) e i metodi per modificarla
// implementa l'interfaccia item delegate, per impedire la dipendenza reciproca con l'adapter
public class TodoViewModel implements ItemDelegate {

    ArrayList<Todo> todoList;
    RecyclerViewAdapter adapter;

    public TodoViewModel(RecyclerViewAdapter adapter) {
        this.adapter = adapter;
        init();
    }

    public void init() {
        this.todoList = new ArrayList<>();
        adapter.update(todoList);
    }

    public void remove(int position) {
        todoList.remove(position);
        adapter.update(todoList);
    }

    @Override
    public void complete(int position) {
        Todo todo = todoList.get(position);
        todo.setComplete(true);
        adapter.update(todoList);
    }

    public void add(String title) {
        todoList.add(new Todo(title));
        adapter.update(todoList);
    }

    public String toJson() {
        JSONArray jsonArray = new JSONArray();
        for (int i=0; i<this.todoList.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("title", this.todoList.get(i).getTitle());
            map.put("complete", this.todoList.get(i).isComplete()? "true": "false");
            JSONObject jsonObject = new JSONObject(map);
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }

    public void fromJson(String json) throws Exception {
        this.todoList = new ArrayList<>();
        JSONArray array = new JSONArray(json);
        for(int i=0; i< array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            Todo todo = new Todo(object.getString("title"));
            todo.setComplete(object.getBoolean("complete"));
            this.todoList.add(todo);
        }
    }
}
