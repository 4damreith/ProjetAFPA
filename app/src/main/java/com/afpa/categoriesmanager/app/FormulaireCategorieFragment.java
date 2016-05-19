package com.afpa.categoriesmanager.app;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by syjebrane on 19/05/2016.
 */
public class FormulaireCategorieFragment extends Fragment implements View.OnClickListener {


    private FormulaireCategorieListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.formlaire_categorie_fragment, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.root);
        for (int i = 0; i < 50; i++) {
            View inputText = inflater.inflate(R.layout.form_input_text, container, false);
            layout.addView(inputText);
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        if (context instanceof FormulaireCategorieListener) {
            this.listener = (FormulaireCategorieListener) context;
        } else {
            throw new ClassCastException("L'activite conteneur doit implementer l'interface FormulaireCategorieFragment.FormulaireCategorieListener");
        }
        super.onAttach(context);
    }

    @Override
    public void onClick(View v) {
        this.listener.fireValidCategorie();
    }

    public interface FormulaireCategorieListener {

        public void fireValidCategorie();

    }
}
