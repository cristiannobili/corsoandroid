package it.skinjobs.listnavigation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class TodoViewModel extends ViewModel implements ItemDelegate {
    private MutableLiveData<List<Todo>> todoLiveData;
    ArrayList<Todo> todoList;

    public TodoViewModel() {
        todoLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<List<Todo>> getTodoLiveData() {
        return todoLiveData;
    }

    public void init() {
        this.todoList = new ArrayList<>();
        todoLiveData.setValue(todoList);
    }

    public void remove(int position) {
        todoList.remove(position);
        todoLiveData.setValue(todoList);
    }

    @Override
    public void complete(int position) {
        Todo todo = todoList.get(position);
        todo.setComplete(true);
        todoLiveData.setValue(todoList);
    }

    public void add(String title) {
        todoList.add(new Todo(title));
        todoLiveData.setValue(todoList);
    }
}
