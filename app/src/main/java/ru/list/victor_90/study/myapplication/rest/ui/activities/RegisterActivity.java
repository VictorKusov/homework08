package ru.list.victor_90.study.myapplication.rest.ui.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import ru.list.victor_90.study.myapplication.R;
import ru.list.victor_90.study.myapplication.rest.models.RegisterRequest;
import ru.list.victor_90.study.myapplication.rest.networks.ServiceBroker;
import ru.list.victor_90.study.myapplication.rest.networks.listeners.RegisterCallback;

public class RegisterActivity extends Activity implements View.OnClickListener {

    EditText edLogin,edPassword,edEmail,edName;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        findViewById(R.id.btn_back).setOnClickListener(this);
        findViewById(R.id.btn_reg).setOnClickListener(this);

        edEmail = (EditText) findViewById(R.id.ed_email);
        edLogin = (EditText) findViewById(R.id.ed_login);
        edPassword = (EditText) findViewById(R.id.ed_pass);
        edName = (EditText) findViewById(R.id.ed_name);
        progressBar = (ProgressBar) findViewById(R.id.pb_bar_reg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_reg:{
                RegisterRequest registerRequest = new RegisterRequest(
                        String.valueOf(edEmail.getText()),
                        String.valueOf(edLogin.getText()),
                        String.valueOf(edPassword.getText()),
                        String.valueOf(edName.getText())
                );

                progressBar.setVisibility(View.VISIBLE);
                ServiceBroker.getInstance().register(registerRequest, new RegisterCallback() {
                    @Override
                    public void response(boolean isError) {
                        progressBar.setVisibility(View.GONE);
                        if(isError){
                            Toast.makeText(RegisterActivity.this,"Register failure",Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(RegisterActivity.this,LoginSuccessfulActivity.class));
                        }
                    }
                });
                break;
            }
            case R.id.btn_back:{
                finish();
                break;
            }
        }
    }
}
