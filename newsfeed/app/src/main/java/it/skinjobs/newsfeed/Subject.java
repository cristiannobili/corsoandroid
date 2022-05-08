package it.skinjobs.newsfeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject {
    private Map<String, List<Observer>> observerList;

    private static Subject instance;

    public static Subject getInstance() {
        if (instance == null) {
            instance = new Subject();
        }
        return instance;
    }

    private Subject() {
        this.observerList = new HashMap<>();
    }

    public void addObserver(Observer observer, String event) {
        if (!this.observerList.containsKey(event)) {
            this.observerList.put(event, new ArrayList<>());
        }
        this.observerList.get(event).add(observer);
    }

    public void emitEvent(String event) {
        if (this.observerList.containsKey(event)) {
            for (Observer observer : this.observerList.get(event)) {
                observer.update(event);
            }
        }
    }
}
