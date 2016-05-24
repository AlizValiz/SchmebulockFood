package com.herprogramacion.restaurantericoparico.modelo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.herprogramacion.restaurantericoparico.R;

import java.util.List;

/**
 * Created by Alejandro D on 23/05/2016.
 */
public class AdaptadorProducto extends BaseAdapter{

    private List<Comida> mProductList;
    private LayoutInflater mInflater;
    private boolean mShowCheckbox;

    public AdaptadorProducto(List<Comida> list, LayoutInflater inflater, boolean showCheckbox) {
        mProductList = list;
        mInflater = inflater;
        mShowCheckbox = showCheckbox;
    }


    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewItem item;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item,
                    null);
            item = new ViewItem();
            item.productImageView = (ImageView) convertView.findViewById(R.id.ImageViewItem);
            item.productTitle = (TextView) convertView.findViewById(R.id.TextViewItem);
            item.productCheckbox = (CheckBox) convertView.findViewById(R.id.CheckBoxSelected);

            convertView.setTag(item);
        } else {
            item = (ViewItem) convertView.getTag();
        }
        Comida curProduct = mProductList.get(position);

        Drawable itemImage = parent.getContext().getResources().getDrawable(curProduct.getIdDrawable(), null);
        item.productImageView.setImageDrawable(itemImage);
        StringBuilder productprice = new StringBuilder();
        productprice.append(curProduct.getNombre());
        productprice.append(" - $");
        productprice.append(Float.toString(curProduct.getPrecio()));
        item.productTitle.setText(productprice);

        if(!mShowCheckbox) {
            item.productCheckbox.setVisibility(View.GONE);
        } else {
            if(curProduct.selected)
                item.productCheckbox.setChecked(true);
            else
                item.productCheckbox.setChecked(false);
        }

        return convertView;
    }
}


class ViewItem {
    ImageView productImageView;
    TextView productTitle;
    CheckBox productCheckbox;
}

