package com.example.login.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.login.R;

public class Register extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    public static final String Address = "addressKey";
    public static final String Password = "passwordKey";

    SharedPreferences sharedpreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText username = findViewById(R.id.rusername);
        final EditText email = findViewById(R.id.email);
        final EditText number = findViewById(R.id.phone);
        final EditText address = findViewById(R.id.address);
        final EditText password = findViewById(R.id.rpassword);
        final Button registerb = findViewById(R.id.register);

        registerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!username.getText().toString().equals("") &&
                        !password.getText().toString().equals("") && !email.getText().toString().equals("") &&
                        !number.getText().toString().equals("") && !address.getText().toString().equals("")) {


                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString(Name, username.getText().toString());
                    editor.putString(Phone, number.getText().toString());
                    editor.putString(Email, email.getText().toString());
                    editor.putString(Address, address.getText().toString());
                    editor.putString(Password, password.getText().toString());

                    editor.commit();

                    Toast.makeText(getApplicationContext(), "WELCOME", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, LoginActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Must fill all required data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                registerb.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getPasswordError() != null) {
                    password.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(username.getText().toString(),
                        password.getText().toString());
            }
        };

        username.addTextChangedListener(afterTextChangedListener);
        password.addTextChangedListener(afterTextChangedListener);
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(username.getText().toString(),
                            password.getText().toString());
                }
                return false;
            }
        });
    }
}
