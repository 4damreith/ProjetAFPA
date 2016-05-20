package com.afpa.categoriesmanager.app;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;


public class MainActivity extends Activity implements FormulaireCategorieFragment.FormulaireCategorieListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragmentContainer, new FormulaireCategorieFragment());
        ft.commit();
    }

    @Override
    public void fireValidCategorie() {
        //TODO
    }
}
