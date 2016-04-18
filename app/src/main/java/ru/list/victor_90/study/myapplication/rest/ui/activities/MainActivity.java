package ru.list.victor_90.study.myapplication.rest.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import ru.list.victor_90.study.myapplication.rest.networks.listeners.LoginCallback;
import ru.list.victor_90.study.myapplication.R;
import ru.list.victor_90.study.myapplication.rest.networks.ServiceBroker;
import ru.list.victor_90.study.myapplication.rest.models.LoginRequest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtLogin,txtPassword;
    Button btnLogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogin = (EditText) findViewById(R.id.txt_login);
        txtPassword = (EditText) findViewById(R.id.txt_pass);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        findViewById(R.id.btn_register).setOnClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.pb_bar);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_login: {
                LoginRequest request = new LoginRequest(
                        String.valueOf(txtLogin.getText()),
                        String.valueOf(txtPassword.getText()));

                // тут можно запустить ProgressBar
                progressBar.setVisibility(View.VISIBLE);
                ServiceBroker.getInstance().login(request, new LoginCallback() {
                    @Override
                    public void response(boolean isError) {
                        // а тут остановить ProgressBar
                        progressBar.setVisibility(View.GONE);
                        if (isError) {
                            Toast.makeText(MainActivity.this, "Ошибка", Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(MainActivity.this,LoginSuccessfulActivity.class));
                        }
                    }
                });
                break;
            }
            case R.id.btn_register:{
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        }

    }
}
