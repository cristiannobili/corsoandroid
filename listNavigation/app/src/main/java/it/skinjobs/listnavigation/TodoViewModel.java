package it.skinjobs.listnavigation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class TodoViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Todo>> todoLiveData;
    ArrayList<Todo> todoList;

    public TodoViewModel() {
        todoLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<Todo>> getTodoLiveData() {
        return todoLiveData;
    }

    public void init() {
        this.todoList = new ArrayList<>();
        this.todoList.add(new Todo("Test"));
        todoLiveData.setValue(todoList);
    }
}
