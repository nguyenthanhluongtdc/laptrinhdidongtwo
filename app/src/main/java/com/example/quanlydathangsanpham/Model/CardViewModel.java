package com.example.quanlydathangsanpham.Model;

public class CardViewModel  {

    private int imgBill;
    String cCodeBill;
    String cTotalBill;

    public void setImgBill(int imgBill) {
        this.imgBill = imgBill;
    }

    public void setcCodeBill(String cCodeBill) {
        this.cCodeBill = cCodeBill;
    }

    public void setcTotalBill(String cTotalBill) {
        this.cTotalBill = cTotalBill;
    }

    public int getImgBill() {
        return imgBill;
    }

    public String getcCodeBill() {
        return cCodeBill;
    }

    public String getcTotalBill() {
        return cTotalBill;
    }
}
