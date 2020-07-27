package com.example.quanlydathangsanpham.Interface;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quanlydathangsanpham.R;

public class BillActivity extends AppCompatActivity {
    private BillFragment billFragment;
    private  ListBillFragment listBillFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);


        initFragment();
        showBillFragment();
    }

    private void showBillFragment() {
        getSupportFragmentManager().beginTransaction().show(billFragment).hide(listBillFragment).commit();
    }

    private void showListBillFragment() {

        getSupportFragmentManager().beginTransaction().show(listBillFragment).hide(billFragment).addToBackStack(null).commit();

        listBillFragment.loadDataListBill();
    }

    private void initFragment() {
        billFragment = new BillFragment();
        billFragment.setListener(new BillFragment.OnClickButtonListener() {
            @Override
            public void clickButton() {
                showListBillFragment();
            }
        });

        listBillFragment = new ListBillFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.layout_bill_main,billFragment,BillFragment.class.getName())
                .add(R.id.layout_bill_main,listBillFragment,ListBillFragment.class.getName()).commit();
    }
}
