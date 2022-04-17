package com.example.gridviewwithfragment;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class MyArrayAdapter extends BaseAdapter {
    private List<SanPham> listData;
    private Context context;
    private int positionSelected;
    NumberFormat formatter = new DecimalFormat("#0.00");

    public MyArrayAdapter(Context aContext,  List<SanPham> listData) {
        this.context = aContext;
        this.listData = listData;
        this.positionSelected = -1;
    }

    public void setPositionSelected(int positionSelected) {
        this.positionSelected = positionSelected;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.my_grid_item, null);
        TextView tv_Ten = convertView.findViewById(R.id.textView_Ten);
        TextView tv_Gia = convertView.findViewById(R.id.textView_Gia);
        ImageView iv_SanPham = convertView.findViewById(R.id.imageView_SP);

        SanPham sp = listData.get(position);

        tv_Gia.setText(formatter.format(sp.getPrice()));
        tv_Ten.setText(sp.getName());
        iv_SanPham.setImageResource(sp.getImgId());
        convertView.setLayoutParams(new ViewGroup.LayoutParams(GridView.AUTO_FIT, 710));

        if (this.positionSelected == position) {
            ConstraintLayout constraintLayout = convertView.findViewById(R.id.myGridItemContraint);
            constraintLayout.setBackgroundColor(convertView.getResources().getColor(R.color.itemSelected));
        }

        return convertView;
    }

}