package com.afpa.categoriesmanager.app;

import android.content.Context;
import android.support.annotation.Nullable;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by syjebrane on 20/05/2016.
 */
public class ChampDAO extends WebServiceDAO {

    private static final String NOM_MODELE = "champ";
    private Context context;

    public ChampDAO() {
        super(NOM_MODELE);
    }

    public ChampDAO(Context context) {
        super(NOM_MODELE);
        this.context = context;
    }

    @Override
    public void create(String[] params) {
        //TODO
    }

    @Override
    public JSONObject read(String[] params) {
        //TODO
        return null;
    }

    @Override
    public JSONObject readAll(@Nullable String[] params) {
        JSONObject json = null;
        try {
            json = JsonUtils.loadJSONFromResources(this.context, R.raw.champs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public void update(String[] params) {
        //TODO
    }

    @Override
    public void delete(String[] params) {
        //TODO
    }


}
