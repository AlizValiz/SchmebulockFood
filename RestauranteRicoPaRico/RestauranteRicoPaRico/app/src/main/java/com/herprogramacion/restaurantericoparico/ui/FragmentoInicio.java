package com.herprogramacion.restaurantericoparico.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.herprogramacion.restaurantericoparico.R;
import com.herprogramacion.restaurantericoparico.modelo.Comida;
import com.herprogramacion.restaurantericoparico.modelo.JSONParser;

import java.util.Date;

/**
 * Fragmento para la sección de "Inicio"
 */
public class FragmentoInicio extends Fragment {
    private RecyclerView reciclador;
    private LinearLayoutManager layoutManager;
    private AdaptadorInicio adaptador;

    public FragmentoInicio() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_inicio, container, false);

        reciclador = (RecyclerView) view.findViewById(R.id.reciclador);
        layoutManager = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(layoutManager);

        adaptador = new AdaptadorInicio(Comida.COMIDAS_POPULARES, new AdaptadorInicio.OnItemClickListener() {
            @Override
            public void onItemClick(Comida item) {
                Toast.makeText(getContext(), "Prueba, Lanzar datos a WebService", Toast.LENGTH_LONG).show();

                AsyncTask<String, Void, String> execute = new JSONParser(getActivity()).
                        execute("1", new Date().toString(), "Salmon", "120.50", "Pan", "2.80", "Ensalada", "60.99 ", "Refresco", "10.50");
            }
        });
        reciclador.setAdapter(adaptador);


        return view;
    }



}
