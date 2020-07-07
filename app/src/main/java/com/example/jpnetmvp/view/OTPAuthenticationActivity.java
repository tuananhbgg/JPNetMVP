package com.example.jpnetmvp.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.jpnetmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OTPAuthenticationActivity extends AppCompatActivity {

    @BindView(R.id.tvToolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvNotification)
    TextView tvNotification;
    @BindView(R.id.edtOTP)
    EditText edtOTP;
    @BindView(R.id.edtPass)
    EditText edtPass;
    @BindView(R.id.edtConfirmPass)
    EditText edtConfirmPass;
    @BindView(R.id.btnGui)
    Button btnGui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_authentication);
        ButterKnife.bind(this);
    }
}
