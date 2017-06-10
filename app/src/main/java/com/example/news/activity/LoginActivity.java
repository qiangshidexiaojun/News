package com.example.news.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.news.R;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;

public class LoginActivity extends AppCompatActivity {

    private EditText edtPhone;
    private EditText edtCode;
    private Button btnGetcode;
    private Button btnLog;
    private TextView mLogin;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        mLogin = (TextView) findViewById(R.id.login);
        mLogin.setText("登陆");
        mLogin.setVisibility(View.VISIBLE);
    }

    private void initViews() {
        edtPhone = (EditText) findViewById(R.id.edt_phone);
        edtCode = (EditText) findViewById(R.id.edt_code);
        btnGetcode = (Button) findViewById(R.id.btn_getcode);
        btnLog = (Button) findViewById(R.id.btn_log);


        btnGetcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = edtPhone.getText().toString();
                BmobSMS.requestSMSCode(phone, "News", new QueryListener<Integer>() {

                    @Override
                    public void done(Integer smsId, BmobException ex) {
                        if (ex == null) {//验证码发送成功
                            Log.i("smile", "短信id：" + smsId);//用于查询本次短信发送详情
                        }
                    }
                });
            }
        });

        final String code = edtCode.getText().toString();
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser.loginBySMSCode(phone, code, new LogInListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if (e == null) {
                            Log.e("AAA", "log success" + BmobUser.getCurrentUser().getMobilePhoneNumber());
                        }
                    }
                });
            }
        });

    }
}
