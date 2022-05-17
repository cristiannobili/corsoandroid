package it.skinjobs.newsfeed;

public interface RemoteTaskDelegate {
    void complete(String json);
    void error(String message);
}
