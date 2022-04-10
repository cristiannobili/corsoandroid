package it.skinjobs.simpletodo;

public class Todo {
    private String title;
    private boolean complete;

    public Todo(String title) {
        this.complete = false;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

}
