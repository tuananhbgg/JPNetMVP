package com.example.jpnetmvp.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.jpnetmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ForgotPassWordActivity extends AppCompatActivity {


    @BindView(R.id.tvToolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imgLogo)
    ImageView imgLogo;
    @BindView(R.id.tvSuggestions)
    TextView tvSuggestions;
    @BindView(R.id.edtUsername)
    EditText edtUsername;
    @BindView(R.id.btnSend)
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass_word);
        ButterKnife.bind(this);
        toolbar = findViewById(R.id.toolbar);
        tvToolbar = findViewById(R.id.tvToolbar);

        setSupportActionBar(toolbar);
        tvToolbar.setText("Quên mật khẩu");
    }
}
