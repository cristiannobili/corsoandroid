package it.skinjobs.simpletodo;

public interface RemoteTaskDelegate {
    void complete(String json);
    void error(String message);
}
