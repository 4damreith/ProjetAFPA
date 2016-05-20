package com.afpa.categoriesmanager.app;

import android.support.annotation.Nullable;
import org.json.JSONObject;

/**
 * Created by syjebrane on 19/05/2016.
 */
public class CategorieDao extends WebServiceDAO {

    private static final String NOM_MODELE = "produit";

    public CategorieDao() {
        super(NOM_MODELE);
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
        //TODO
        return null;
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
