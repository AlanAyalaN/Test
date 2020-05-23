package com.example.myexam.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myexam.R;

public class MainActivity extends AppCompatActivity {

private EditText edtUsuario, edtPassword;
private Button btnLogin;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LIMITS
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN && Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP ) {
            MainFlags();
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
        }
        else{
              MainFlags();
        }

        setContentView(R.layout.activity_main);

        //inicializa componentes
        initComponents();
        //inicializa eventos
        initEvents();

    }

    private void initEvents() {
btnLogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final String usuario = edtUsuario.getText().toString();
        final String pass = edtPassword.getText().toString();

        //Aqui va la parte donde se hará el request y todas las validaciones

        if(usuario.equals("testnaat@na-at.com.mx") && pass.equals("56Forj2018.")){
saveLoginSharedPreferences(usuario);

Intent intentEmpresas = new Intent(getApplicationContext(), EmpresasActivity.class);
startActivity(intentEmpresas);

        }else{
            Toast.makeText(MainActivity.this, R.string.datos, Toast.LENGTH_SHORT).show();
        }




    }
});

    }

    private void initComponents() {
        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword =  findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contextmenu, menu);
        return true;
    }

    private void MainFlags() {
        this.getSupportActionBar().setElevation(0);
        this.getSupportActionBar().hide();

    }

    private void saveLoginSharedPreferences(String usuario){
        SharedPreferences  sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("usuario",usuario);
        editor.apply();



    }

}
