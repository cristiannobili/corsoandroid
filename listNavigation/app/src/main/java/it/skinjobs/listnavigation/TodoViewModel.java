package it.skinjobs.listnavigation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class TodoViewModel extends ViewModel implements RemoveDelegate {
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
        this.todoList.add(new Todo("Test"));
        todoLiveData.setValue(todoList);
    }

    public void remove(int position) {
        todoList.remove(position);
        todoLiveData.setValue(todoList);
    }
}
