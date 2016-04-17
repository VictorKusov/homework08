package ru.list.victor_90.study.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtLogin,txtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogin = (EditText) findViewById(R.id.txt_login);
        txtPassword = (EditText) findViewById(R.id.txt_pass);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        LoginRequest request = new LoginRequest(
                String.valueOf(txtLogin.getText()),
                String.valueOf(txtPassword.getText()));

        // тут можно запустить ProgressBar
        ServiceBroker.getInstance().login(request, new LoginCallback() {
            @Override
            public void response(boolean isError) {
                // а тут остановить ProgressBar
                if (isError) {
                    Toast.makeText(MainActivity.this,"Ошибка", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"Все ок", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
