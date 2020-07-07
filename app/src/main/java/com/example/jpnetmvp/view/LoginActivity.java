package com.example.jpnetmvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.jpnetmvp.presenter.LoginPresenter;
import com.example.jpnetmvp.R;
import com.example.jpnetmvp.presenter.ILoginActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements ILoginActivity {
    @BindView(R.id.tvToolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imgLogo)
    ImageView imgLogo;
    @BindView(R.id.edtUsername)
    EditText edtUsername;
    @BindView(R.id.edtPassWord)
    TextInputEditText edtPassWord;
    @BindView(R.id.edtPass)
    TextInputLayout edtPass;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.tvForgotpassword)
    TextView tvForgotpassword;
    @BindView(R.id.tvRegistration)
    TextView tvRegistration;
    @BindView(R.id.imgfacebook)
    ImageView imgfacebook;

    private LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        toolbar = findViewById(R.id.toolbar);
        tvToolbar = findViewById(R.id.tvToolbar);
        btnLogin = findViewById(R.id.btnLogin);
        tvToolbar.setText("Đăng nhập");
        tvForgotpassword = findViewById(R.id.tvForgotpassword);
        tvRegistration = findViewById(R.id.tvRegistration);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassWord = findViewById(R.id.edtPassWord);

        loginPresenter = new LoginPresenter(this, this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtUsername.getText().toString();
                String password = edtPassWord.getText().toString();
                loginPresenter.login(userName, password);
            }
        });
        tvForgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgotPassWordActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void loginSuccesful() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.compositeDisposable.dispose();
    }
}
