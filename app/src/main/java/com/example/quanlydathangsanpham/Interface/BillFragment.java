package com.example.quanlydathangsanpham.Interface;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlydathangsanpham.Adapter.CustomRecyclerViewListBill;
import com.example.quanlydathangsanpham.Database.DBBill;
import com.example.quanlydathangsanpham.Model.Bill;
import com.example.quanlydathangsanpham.Model.CardViewModel;
import com.example.quanlydathangsanpham.R;

import java.util.ArrayList;

public class BillFragment extends Fragment {
    private View rootView;
    private OnClickButtonListener listener;
    private DBBill dbBill;
    RecyclerView rcvListBill;
    ArrayList<CardViewModel> listData = new ArrayList<>();


    private Button btnListBill; Button btnSave, btnClear, btnPrint, btnExit, btnChoose;
    EditText txtCodeBill, txtCodeCutomer, txtDateBill, txtTotalMoney;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_bill,container,false);
        setControl();
        setEvent();
        LoadRecyclerView();
        return rootView;
    }

    private  void LoadRecyclerView(){
        //Setup Recycler View
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        rcvListBill.setLayoutManager(layoutManager);

        DBBill dbBill = new DBBill(getContext());

        listData = dbBill.GetDataCardBill();
        CustomRecyclerViewListBill customRecyclerViewListBill = new CustomRecyclerViewListBill(listData);
        rcvListBill.setAdapter(customRecyclerViewListBill);
        customRecyclerViewListBill.notifyDataSetChanged();
    }

    private void setEvent() {

        btnListBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clickButton();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbBill = new DBBill(getContext());
                Bill bill = new Bill();
                bill.setCodeBill(txtCodeBill.getText().toString());
                bill.setCodeCustomer(txtCodeCutomer.getText().toString());
                bill.setDateBill(txtDateBill.getText().toString());
                int totalMoney = Integer.parseInt(txtTotalMoney.getText().toString());
                bill.setTotalMoney(totalMoney);

                dbBill.InsertBill(bill);
                LoadRecyclerView();


                Toast.makeText(getContext(),"Save successfully",Toast.LENGTH_LONG).show();

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Notification");
                builder.setMessage("Are you sure you want to exit");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }

    private void setControl() {
        btnListBill = rootView.findViewById(R.id.btnListBill);
        rcvListBill = rootView.findViewById(R.id.rcvListBill);

        btnSave = rootView.findViewById(R.id.btnSave);
        btnClear = rootView.findViewById(R.id.btnClear);
        btnPrint = rootView.findViewById(R.id.btnPrint);
        btnExit = rootView.findViewById(R.id.btnExit);
        btnChoose = rootView.findViewById(R.id.btnChoose);

        txtCodeBill = rootView.findViewById(R.id.txtCodeBill);
        txtCodeCutomer = rootView.findViewById(R.id.txtCodeCustomer);
        txtDateBill = rootView.findViewById(R.id.txtDateBill);
        txtTotalMoney = rootView.findViewById(R.id.txtTotalMoney);
    }

    public void setListener(OnClickButtonListener listener) {
        this.listener = listener;
    }

    public interface OnClickButtonListener{
        void clickButton();
    }
}
