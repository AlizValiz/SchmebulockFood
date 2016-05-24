package com.herprogramacion.restaurantericoparico.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.herprogramacion.restaurantericoparico.R;
import com.herprogramacion.restaurantericoparico.modelo.Comida;

import java.lang.reflect.Array;
import java.util.List;

public class ActividadProductDetail extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_product_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        List<Comida> catalog = Comida.COMIDAS_POPULARES;
        final List<Comida> cart = Comida.getCart();


        int productIndex = getIntent().getExtras().getInt(Comida.PRODUCT_INDEX);
        final Comida selectedProduct = catalog.get(productIndex);

        ImageView productImageView = (ImageView) findViewById(R.id.ImageViewProduct);
        Drawable productImage = getResources().getDrawable(selectedProduct.getIdDrawable(), null);
        productImageView.setImageDrawable(productImage);
        TextView productTitleTextView = (TextView) findViewById(R.id.TextViewProductTitle);
        productTitleTextView.setText(selectedProduct.getNombre());

        Button cartButton = (Button) findViewById(R.id.ButtonAddToCart);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               cart.add(selectedProduct);
                finish();
            }
        });

        if(cart.contains(selectedProduct)) {
            cartButton.setEnabled(false);
            cartButton.setText("Item in Cart");
        }

    }

}



