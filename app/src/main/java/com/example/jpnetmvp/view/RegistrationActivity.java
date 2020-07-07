package com.example.jpnetmvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.jpnetmvp.R;
import com.example.jpnetmvp.model.UserModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;


public class RegistrationActivity extends AppCompatActivity {

    public static Realm myRealm;
    @BindView(R.id.tvToolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imgLogo)
    ImageView imgLogo;
    @BindView(R.id.edtDisplayName)
    TextInputEditText edtDisplayName;
    @BindView(R.id.LayoutuEdtDisplayName)
    TextInputLayout LayoutuEdtDisplayName;
    @BindView(R.id.edtEmailRegis)
    TextInputEditText edtEmailRegis;
    @BindView(R.id.LayoutEdtEmail)
    TextInputLayout LayoutEdtEmail;
    @BindView(R.id.edtPhoneRegis)
    TextInputEditText edtPhoneRegis;
    @BindView(R.id.LayoutEdtPhone)
    TextInputLayout LayoutEdtPhone;
    @BindView(R.id.edtPassRegis)
    TextInputEditText edtPassRegis;
    @BindView(R.id.LayoutEditPass)
    TextInputLayout LayoutEditPass;
    @BindView(R.id.btnRegistration)
    Button btnRegistration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        initControl();
        setSupportActionBar(toolbar);
        tvToolbar.setText("Đăng ký");

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("mydatabase.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();


        myRealm = Realm.getInstance(config);
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtDisplayName.getText().toString();
                String email = edtEmailRegis.getText().toString();
                String phone = edtPhoneRegis.getText().toString();
                String passRegistration = edtPassRegis.getText().toString();

                UserModel userModel = myRealm.where(UserModel.class).equalTo("email", email).equalTo("phone", phone).findFirst();
                if (userModel == null) {
                    myRealm.beginTransaction();
                    UserModel model = myRealm.createObject(UserModel.class);
                    model.setUserName(userName);
//                    model.setEmail(email);
//                    model.setPhone(phone);
                    model.setPassword(passRegistration);
                    Toast.makeText(RegistrationActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    myRealm.commitTransaction();
                    Intent intent = getIntent();
                    intent.putExtra("userName", model.getEmail());
                    intent.putExtra("pass", model.getPassword());
                    setResult(1, intent);
                    myRealm.close();
                    finish();
                } else {
                    Toast.makeText(RegistrationActivity.this, "Tài khoản đã tồn tại!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initControl() {
        edtDisplayName = findViewById(R.id.edtDisplayName);
        edtEmailRegis = findViewById(R.id.edtEmailRegis);
        edtPhoneRegis = findViewById(R.id.edtPhoneRegis);
        edtPassRegis = findViewById(R.id.edtPassRegis);
        btnRegistration = findViewById(R.id.btnRegistration);
        toolbar = findViewById(R.id.toolbar);
        tvToolbar = findViewById(R.id.tvToolbar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!myRealm.isClosed()) {
            myRealm.close();
        }
    }
}
