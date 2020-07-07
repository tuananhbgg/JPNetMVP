package com.example.jpnetmvp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.jpnetmvp.R;
import com.example.jpnetmvp.view.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    HomeFragment homefragment;
    FragmentTransaction transaction;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_trangchu:
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.show(homefragment);
                   transaction.commit();
                    return true;
                case R.id.nav_tinnhan:
                    return true;
                case R.id.nav_thaoluan:
                    return true;
                case R.id.nav_thongbao:
                    return true;
                case R.id.nav_taikhoan:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        homefragment = new HomeFragment();
        toolbar = findViewById(R.id.toolbar);
        transaction = getSupportFragmentManager().beginTransaction();
       transaction.add(R.id.contentPanel, homefragment, "HomeFragment");
        transaction.commit();
        setSupportActionBar(toolbar);

    }
}
