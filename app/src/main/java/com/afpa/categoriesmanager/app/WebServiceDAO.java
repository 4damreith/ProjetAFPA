package com.afpa.categoriesmanager.app;

import android.support.annotation.Nullable;
import com.loopj.android.http.AsyncHttpClient;
import org.json.JSONObject;

/**
 * Created by syjebrane on 19/05/2016.
 */
public abstract class WebServiceDAO {

    private static final String DOMAIN = "http://pc872:8085/Glutton-1.0-SNAPSHOT/acces/";
    private static AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    private String nomModele;

    public WebServiceDAO(String nomModele) {
        this.nomModele = nomModele;
    }

    public abstract void create(String[] params);

    public abstract JSONObject read(String[] params);

    public abstract JSONObject readAll(@Nullable String[] params);

    public abstract void update(String[] params);

    public abstract void delete(String[] params);

}
