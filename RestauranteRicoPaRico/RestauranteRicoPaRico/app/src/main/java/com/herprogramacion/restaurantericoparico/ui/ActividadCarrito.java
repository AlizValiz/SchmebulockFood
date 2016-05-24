package com.herprogramacion.restaurantericoparico.ui;

import android.app.Activity;
import android.content.DialogInterface;
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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.herprogramacion.restaurantericoparico.R;
import com.herprogramacion.restaurantericoparico.modelo.AdaptadorProducto;
import com.herprogramacion.restaurantericoparico.modelo.Comida;

import java.util.List;

/**
 * Created by alizn on 5/15/2016.
 */
public class ActividadCarrito extends Activity {

    private List<Comida> mCartList;
    private AdaptadorProducto mProductAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_carrito);
        mCartList = Comida.getCart();

        // Make sure to clear the selections
        for(int i=0; i<mCartList.size(); i++) {
            mCartList.get(i).selected = false;
        }

        // Create the list
        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        mProductAdapter = new AdaptadorProducto(mCartList, getLayoutInflater(), true);
        listViewCatalog.setAdapter(mProductAdapter);

        listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Comida selectedProduct = mCartList.get(position);
                selectedProduct.selected = !selectedProduct.selected;

                mProductAdapter.notifyDataSetInvalidated();

            }
        });

        Button removeButton = (Button) findViewById(R.id.ButtonRemoveFromCart);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Loop through and remove all the products that are selected
                // Loop backwards so that the remove works correctly
                for (int i = mCartList.size() - 1; i >= 0; i--) {

                    if (mCartList.get(i).selected) {
                        mCartList.remove(i);
                    }
                }
                mProductAdapter.notifyDataSetChanged();
            }
        });



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
