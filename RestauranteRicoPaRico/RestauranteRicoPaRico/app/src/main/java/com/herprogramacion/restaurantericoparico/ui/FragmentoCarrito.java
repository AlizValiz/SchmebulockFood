package com.herprogramacion.restaurantericoparico.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.herprogramacion.restaurantericoparico.R;
import com.herprogramacion.restaurantericoparico.modelo.AdaptadorProducto;
import com.herprogramacion.restaurantericoparico.modelo.Comida;

import java.util.List;

/**
 * Created by alizn on 5/15/2016.
 */
public class FragmentoCarrito extends Fragment {

    private List<Comida> mCartList;
    private AdaptadorProducto mProductAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_carrito, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        mCartList = Comida.getCart();

        // Make sure to clear the selections
        for(int i=0; i<mCartList.size(); i++) {
            mCartList.get(i).selected = false;
        }

        final ListView listViewCatalog = (ListView) findViewById(R.id.item_list_carrito);
        mProductAdapter = new AdaptadorProducto(mCartList, getActivity().getLayoutInflater(), true);
        listViewCatalog.setAdapter(mProductAdapter);


    }

//    private static final String INDICE_SECCION
//            = "com.restaurantericoparico.FragmentoCategoriasTab.extra.INDICE_SECCION";


//    private RecyclerView reciclador;
//    private GridLayoutManager layoutManager;
//    private AdaptadorCategorias adaptador;
//
//    public static FragmentoCategoria nuevaInstancia(int indiceSeccion) {
//        FragmentoCategoria fragment = new FragmentoCategoria();
//        Bundle args = new Bundle();
//        args.putInt(INDICE_SECCION, indiceSeccion);
//        fragment.setArguments(args);
//        return fragment;
//    }


}
