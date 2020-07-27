package com.example.quanlydathangsanpham.Interface;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quanlydathangsanpham.Adapter.CustomBill;
import com.example.quanlydathangsanpham.Database.DBBill;
import com.example.quanlydathangsanpham.Model.Bill;
import com.example.quanlydathangsanpham.R;

import java.util.ArrayList;

public class ListBillFragment extends Fragment {
    private  View rootView;
    GridView gvListBill;
    ArrayList<Bill> listBill = new ArrayList<>();
    CustomBill customBill;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list_bill,container,false);

        setControl();
        setEvent();
        return rootView;
    }

    private void setEvent() {
        loadDataListBill();
    }

    public void loadDataListBill(){
        DBBill dbBill = new DBBill(getContext());
        listBill = dbBill.GetDataBill();
        customBill = new CustomBill(getContext(),R.layout.layout_custom_listbill,listBill);
        gvListBill.setAdapter(customBill);
        customBill.notifyDataSetChanged();
    }

    private void setControl() {
        gvListBill = rootView.findViewById(R.id.gvListBill);
    }
}
