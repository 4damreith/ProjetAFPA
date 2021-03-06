package com.afpa.categoriesmanager.app;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by syjebrane on 19/05/2016.
 */
public class FormulaireCategorieFragment extends Fragment implements View.OnClickListener {


    private static AlertDialog dialogAjouterChamp;
    private FormulaireCategorieListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.formulaire_categorie_fragment, container, false);
        Button boutonAjouterChamp = (Button) view.findViewById(R.id.boutonAjouterChamp);
        Button boutonValiderCategorie = (Button) view.findViewById(R.id.boutonValiderCategorie);
        boutonAjouterChamp.setOnClickListener(this);
        boutonValiderCategorie.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        if (context instanceof FormulaireCategorieListener) {
            this.listener = (FormulaireCategorieListener) context;
        } else {
            throw new ClassCastException("L'activite conteneur doit implementer l'interface FormulaireCategorieFragment.FormulaireCategorieListener");
        }
        initDialogAjouterChamp(context);
        super.onAttach(context);
    }

    private void initDialogAjouterChamp(Context context) {
        ChampDAO champDAO = new ChampDAO(context);
        JSONObject jsonObject = champDAO.readAll(null);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View layoutAjouterChamp = inflater.inflate(R.layout.dialog_ajout_champ, null);
        Spinner spinner = (Spinner) layoutAjouterChamp.findViewById(R.id.spinnerAjoutChamp);
        ArrayAdapter<String> spinnerChampsAdapter = new ArrayAdapter<String>(
                context,
                R.layout.select_dialog_item_material,
                JsonUtils.getKeysAsList(jsonObject, new ArrayList<String>())
        );
        spinner.setAdapter(spinnerChampsAdapter);
        dialogAjouterChamp = new AlertDialog.Builder(context).setCancelable(false)
                .setView(layoutAjouterChamp)
                .setMessage(getResources().getString(R.string.titre_dialog_ajouter_champ))
                .setPositiveButton(
                        getString(R.string.texte_bouton_dialog_ajouter_champ_valider),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                .setNegativeButton(
                        getString(R.string.texte_bouton_dialog_ajouter_champ_annuler),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                .create();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boutonAjouterChamp:
                triggerAjouterChamp();
                break;
            case R.id.boutonValiderCategorie:
                triggerValiderCategorie();
                break;
        }
    }

    private void triggerAjouterChamp() {
        dialogAjouterChamp.show();
    }

    private void triggerValiderCategorie() {
        this.listener.fireValidCategorie();
    }

    public interface FormulaireCategorieListener {
        void fireValidCategorie();
    }
}
