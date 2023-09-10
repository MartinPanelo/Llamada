package com.martintecno.llamada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.Manifest;
import com.martintecno.llamada.databinding.ActivityLoginBinding;
import com.martintecno.llamada.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    private LoginActivityViewModel VmLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);

        }


        ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        VmLogin = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginActivityViewModel.class);
        binding.BTNLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VmLogin.LogearUsuario(binding.ITUsuario.getText().toString(),binding.ITContraseA.getText().toString());
            }
        });

        VmLogin.CartelM().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.TVNotificaciones.setText(s);
            }
        });

    }
}