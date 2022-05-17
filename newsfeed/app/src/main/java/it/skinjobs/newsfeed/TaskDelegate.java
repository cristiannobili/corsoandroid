package it.skinjobs.newsfeed;

public interface TaskDelegate {
    void complete(String json) throws Exception;
    void error(String message);
}
