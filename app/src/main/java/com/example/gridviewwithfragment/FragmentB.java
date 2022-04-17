package com.example.gridviewwithfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FragmentB extends Fragment {
    ImageView img_SP;
    TextView tv_Ten, tv_Gia, tv_MoTa;
    NumberFormat formatter = new DecimalFormat("#0.00");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container,false);

        img_SP = view.findViewById(R.id.imageView_item);
        tv_Ten = view.findViewById(R.id.textView_Ten);
        tv_Gia = view.findViewById(R.id.textView_Gia);
        tv_MoTa = view.findViewById(R.id.textView_MoTa);

        Bundle bundle = getArguments();
        if (bundle != null) {
            SanPham sp = (SanPham) bundle.getSerializable("SanPham");
            tv_Gia.setText(formatter.format(sp.getPrice()));
            tv_Ten.setText(sp.getName());
            tv_MoTa.setText(sp.getDescription());
            img_SP.setImageResource(sp.getImgId());
        }

        return view;
    }

}
