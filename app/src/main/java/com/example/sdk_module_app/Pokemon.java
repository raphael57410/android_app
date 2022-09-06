package com.example.sdk_module_app;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class Pokemon {
    private String name;
    private String url;

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Pokemon(JSONObject json) {

        try {
            this.name = json.getString("name");
            this.url = json.getString("url");
        } catch (JSONException e) {
            e.printStackTrace();
            this.name = "";
            this.url = "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
