package com.example.scrolltext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class OtherActivity extends AppCompatActivity {

    private Button btnLogin;

    private final String spValueText = "SharedPreference_Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editUserId = findViewById(R.id.editTextUserId);
                EditText editPassword = findViewById(R.id.editTextPassword);
                if (editUserId.getText().toString().equals("user") && editPassword.getText().toString().equals("1234"))
                {
                    saveAutoLoginStatus();
                    startMainActivity();
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "로그인할 수 없습니다", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    private void saveAutoLoginStatus(){
        CheckBox cb = findViewById(R.id.cbAutoLogin);
        boolean isChecked = cb.isChecked();
        SharedPreferences sp = getSharedPreferences(spValueText, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isLogged", isChecked);
        editor.commit();
    }


    void startMainActivity()
    {
        Intent intent = new Intent(OtherActivity.this, MainActivity.class);
        startActivity(intent);
    }
}