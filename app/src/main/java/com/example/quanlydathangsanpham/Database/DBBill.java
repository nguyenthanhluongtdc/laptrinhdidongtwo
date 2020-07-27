package com.example.quanlydathangsanpham.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.quanlydathangsanpham.Model.Bill;
import com.example.quanlydathangsanpham.Model.CardViewModel;
import com.example.quanlydathangsanpham.R;

import java.util.ArrayList;

public class DBBill {
    private  DBHelper dbHelper;

    public  DBBill(Context context){
        dbHelper = new DBHelper(context);
    }

    public void InsertBill(Bill bill){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("CodeBill",bill.getCodeBill());
        values.put("CodeCutomer",bill.getCodeCustomer());
        values.put("DateBill",bill.getDateBill());
        values.put("TotalMoney",bill.getTotalMoney());
        db.insert("Bill",null,values);
    }

    public ArrayList<Bill> GetDataBill(){
        ArrayList<Bill> listBill = new ArrayList<>();
        String sql = "select * from Bill";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        try{
            cursor. moveToFirst();
            do{
                Bill bill = new Bill();
                bill.setCodeBill(cursor.getString(0));
                bill.setCodeCustomer(cursor.getString(1));
                bill.setDateBill(cursor.getString(2));
                bill.setTotalMoney(cursor.getInt(3));
                listBill.add(bill);
            }while (cursor.moveToNext());

        }catch (Exception ex){
        }

        return listBill;
    }

    public ArrayList<CardViewModel> GetDataCardBill(){
        ArrayList<CardViewModel> listBill = new ArrayList<>();
        String sql = "select * from Bill";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        try{
            cursor. moveToFirst();
            do{
                CardViewModel card = new CardViewModel();
                card.setImgBill(R.drawable.hoadon);
                card.setcCodeBill(cursor.getString(0));
                card.setcTotalBill(cursor.getString(3));
                listBill.add(card);
            }while (cursor.moveToNext());

        }catch (Exception ex){
        }

        return listBill;
    }
}
