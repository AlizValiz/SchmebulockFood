package com.herprogramacion.restaurantericoparico.modelo;

import com.herprogramacion.restaurantericoparico.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Modelo de datos estático para alimentar la aplicación
 */
public class Comida {
    public float precio;
    public String nombre;
    public int idDrawable;
    public boolean selected;

    public Comida(float precio, String nombre, int idDrawable) {
        this.precio = precio;
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    public static final List<Comida> COMIDAS_POPULARES = new ArrayList<Comida>();
    public static final List<Comida> BEBIDAS = new ArrayList<>();
    public static final List<Comida> POSTRES = new ArrayList<>();
    public static final List<Comida> PLATILLOS = new ArrayList<>();
    public static List<Comida> CART;

    static {
        COMIDAS_POPULARES.add(new Comida(37, "Tarro Cerveza", R.drawable.tarro_cerveza));
        COMIDAS_POPULARES.add(new Comida(16, "Taza de Café", R.drawable.cafe));
        COMIDAS_POPULARES.add(new Comida(63.9f, "Sushi agrodulce", R.drawable.sushi_endulce));
        COMIDAS_POPULARES.add(new Comida(83, "Spagetti Bolognesa", R.drawable.spagetti_bolognesa));
        COMIDAS_POPULARES.add(new Comida(58, "Pastel Mini Festin", R.drawable.pastel_cumpleanos));
        COMIDAS_POPULARES.add(new Comida(22, "Crepas de Fresa", R.drawable.crepa_fresa));
        COMIDAS_POPULARES.add(new Comida(42, "Capucchino Vainilla", R.drawable.capucchino));
        COMIDAS_POPULARES.add(new Comida(102, "Pollo Endulsado", R.drawable.sour));
        COMIDAS_POPULARES.add(new Comida(136.5f, "Coctel Camarones", R.drawable.mega_coctel));
        COMIDAS_POPULARES.add(new Comida(73, "Salmon Simple", R.drawable.salmon));

      PLATILLOS.add(new Comida(73, "Sopa de Tomate", R.drawable.sopa));
        PLATILLOS.add(new Comida(102, "Pollo Endulsado", R.drawable.sour));
        PLATILLOS.add(new Comida(136.5f, "Coctel Camarones", R.drawable.mega_coctel));
        PLATILLOS.add(new Comida(84.5f, "Ensalada", R.drawable.ensalada));
        PLATILLOS.add(new Comida(63.9f, "Sushi agrodulce", R.drawable.sushi_endulce));
        PLATILLOS.add(new Comida(83, "Spagetti Bolognesa", R.drawable.spagetti_bolognesa));
        PLATILLOS.add(new Comida(165, "Carne Ahumada", R.drawable.carne_aumada));
        PLATILLOS.add(new Comida(184, "Camarones", R.drawable.camarones));
        PLATILLOS.add(new Comida(184f, "Sushi Gurmet", R.drawable.sushi));
        PLATILLOS.add(new Comida(70, "Sandwich Basico", R.drawable.sandwich));
        PLATILLOS.add(new Comida(340f, "Lomo De Cerdo", R.drawable.lomo_cerdo));
        PLATILLOS.add(new Comida(128, "Brochetas Marinadas", R.drawable.brochetas_marinadas));
        PLATILLOS.add(new Comida(117.9f, "Salmon y Papas", R.drawable.salmon_papas));
        PLATILLOS.add(new Comida(1945.9f, "Festin Completo", R.drawable.fastin));
        PLATILLOS.add(new Comida(73, "Salmon Simple", R.drawable.salmon));
        PLATILLOS.add(new Comida(46.9f, "Sandwitch", R.drawable.sandwitch));
        PLATILLOS.add(new Comida(107.9f, "Pizza Basica", R.drawable.pizza));
        PLATILLOS.add(new Comida(73f, "Camarones Entrada", R.drawable.camarones_entrada));
        PLATILLOS.add(new Comida(149.9f, "Carne Ahumada/Vino", R.drawable.descarga));
        PLATILLOS.add(new Comida(54.9f, "Chile Relleno", R.drawable.chile_relleno));

        BEBIDAS.add(new Comida(389, "Botella Vino", R.drawable.vino_tinto));
        BEBIDAS.add(new Comida(276, "Champagne", R.drawable.champang));
        BEBIDAS.add(new Comida(20, "Jugo Natural", R.drawable.jugo_natural));
        BEBIDAS.add(new Comida(39, "Coctel Stell", R.drawable.coctel_jordano));
        BEBIDAS.add(new Comida(42, "Capucchino Vainilla", R.drawable.capucchino));
        BEBIDAS.add(new Comida(37, "Tarro Cerveza", R.drawable.tarro_cerveza));
        BEBIDAS.add(new Comida(27, "Limonada Mineral", R.drawable.limonada_mineral));
        BEBIDAS.add(new Comida(16, "Taza de Café", R.drawable.cafe));
        BEBIDAS.add(new Comida(42, "Coctel Frutas", R.drawable.coctel));
        BEBIDAS.add(new Comida(35, "Licuados", R.drawable.licuado));

        POSTRES.add(new Comida(57, "Coctel Frutas", R.drawable.coctel_frutas));
        POSTRES.add(new Comida(38, "Hotcakes", R.drawable.hotcackes));
        POSTRES.add(new Comida(22, "Crepas de Fresa", R.drawable.crepa_fresa));
        POSTRES.add(new Comida(26, "Postre Vainilla", R.drawable.postre_vainilla));
        POSTRES.add(new Comida(35, "Pastel Fresa/Leche", R.drawable.pastel_leche));
        POSTRES.add(new Comida(18, "Mini Crepas", R.drawable.crepas));
        POSTRES.add(new Comida(21, "Flan Light", R.drawable.flan_celestial));
        POSTRES.add(new Comida(27.5f, "Cupcake", R.drawable.cupcakes_festival));
        POSTRES.add(new Comida(58, "Pastel Mini Festin", R.drawable.pastel_cumpleanos));
        POSTRES.add(new Comida(39, "Crepa Chocolate", R.drawable.crepa));
        POSTRES.add(new Comida(42, "Pastel De Fresa", R.drawable.pastel_fresa));
        POSTRES.add(new Comida(58, "Muffin de Dia", R.drawable.muffin_amoroso));
        POSTRES.add(new Comida(27, "Helado Fresa", R.drawable.helado));
        POSTRES.add(new Comida(22, "Helado Fruit", R.drawable.postrehelado));
    }

    public float getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }


    public static List<Comida> getCart() {
        if(CART == null) {
            CART = new Vector<Comida>();
        }
        return CART;
    }
}
