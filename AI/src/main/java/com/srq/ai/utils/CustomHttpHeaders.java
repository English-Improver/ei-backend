package com.srq.ai.utils;



import java.util.HashMap;
import java.util.Map;
import java.net.http.HttpRequest;
/**
 * @author yitiansong
 * @since 10/11/24
 */
public class CustomHttpHeaders {
    private final Map<String, String> headers;

    public CustomHttpHeaders() {
        this.headers = new HashMap<>();
    }

    public void add(String name, String value) {
        headers.put(name, value);
    }

    public String get(String name) {
        return headers.get(name);
    }

    public void remove(String name) {
        headers.remove(name);
    }

    public void clear() {
        headers.clear();
    }

    public boolean contains(String name) {
        return headers.containsKey(name);
    }

    public void applyTo(HttpRequest.Builder requestBuilder) {
        headers.forEach(requestBuilder::header);
    }

    @Override
    public String toString() {
        return headers.toString();
    }
}
