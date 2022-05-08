package it.skinjobs.newsfeed;

import org.json.JSONException;

public interface TaskDelegate {
    void complete(String json) throws Exception;
    void error(String message);
}
