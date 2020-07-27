package com.example.quanlydathangsanpham.Interface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.quanlydathangsanpham.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ListView listView;
    Button btnSP, btnKH, btnHD, btnCTHD, btnLogout, btnExit ;

    private BillFragment billFragment;
    private  ListBillFragment listBillFragment;
    private TextView tvQLDHSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        actionToolBar();
        setEvent();
    }


    private  void setEvent(){

        tvQLDHSP = findViewById(R.id.tvQLDHSP);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale);
        tvQLDHSP.startAnimation(animation);

        btnHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BillActivity.class);
                startActivity(intent);
            }
        });
        btnCTHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnKH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    private void actionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void setControl() {
        toolbar = findViewById(R.id.toolBar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
//        listView = findViewById(R.id.lvNavigation);

        btnSP = findViewById(R.id.btnSanPham);
        btnKH = findViewById(R.id.btnKhachHang);
        btnHD = findViewById(R.id.btnHoaDon);
        btnCTHD = findViewById(R.id.btnChiTietHoaDon);
        btnLogout = findViewById(R.id.btnLogout);
        btnExit = findViewById(R.id.btnExit);
    }


}
