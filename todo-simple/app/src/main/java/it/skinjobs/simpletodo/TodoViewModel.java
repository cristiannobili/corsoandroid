package it.skinjobs.simpletodo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

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
}
