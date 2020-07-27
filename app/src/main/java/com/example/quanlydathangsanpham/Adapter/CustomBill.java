package com.example.quanlydathangsanpham.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlydathangsanpham.Model.Bill;
import com.example.quanlydathangsanpham.R;

import java.util.ArrayList;
import java.util.List;

public class CustomBill extends ArrayAdapter {

    Context context;
    int resource;
    ArrayList<Bill> listBill;

    public CustomBill(@NonNull Context context, int resource, @NonNull ArrayList<Bill> listBill) {
        super(context, resource, listBill);
        this.context = context;
        this.resource = resource;
        this.listBill = listBill;
    }

    private static class Holder{
        TextView tvCodeBill;
        TextView tvCodeCustomer;
        TextView tvdateBill;
        TextView tvTotalMoney;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder = null;
        if(convertView == null){
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(resource,null);
            holder.tvCodeBill = convertView.findViewById(R.id.tvCodeBill);
            holder.tvCodeCustomer = convertView.findViewById(R.id.tvCodeCutomer);
            holder.tvdateBill = convertView.findViewById(R.id.tvDateBill);
            holder.tvTotalMoney = convertView.findViewById(R.id.tvTotalMoney);
            convertView.setTag(holder);
        }else holder=(Holder) convertView.getTag();

        final Bill bill = listBill.get(position);
        holder.tvCodeBill.setText(bill.getCodeBill());
        holder.tvCodeCustomer.setText(bill.getCodeCustomer());
        holder.tvdateBill.setText(bill.getDateBill());
        String totalMoney = Integer.toString(bill.getTotalMoney());
        holder.tvTotalMoney.setText(totalMoney);

        return convertView;
    }


}
