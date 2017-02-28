package com.rupik.weddingplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;

/**
 * Created by macmin5 on 28/02/17.
 */

public class MenuItemsAdapter extends BaseAdapter {

    Context context;
    String dataSet[];
    private static LayoutInflater inflater=null;

    public MenuItemsAdapter(Context context, String dataSet[])
    {
        this.context = context;
        this.dataSet = dataSet;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataSet.length;
    }

    @Override
    public Object getItem(int i) {
        return dataSet[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public  class  Holder{
        TextView titleTextView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Holder holder = new Holder();

        View rowView;
        rowView = inflater.inflate(R.layout.menu_list_cell, null);

        holder.titleTextView = (TextView)rowView.findViewById(R.id.menuItemTV);

        String menuItem = (String) getItem(i);
        holder.titleTextView.setText(menuItem);

        holder.titleTextView.setTypeface(EasyFonts.caviarDreamsBold(context));

        return rowView;
    }
}
