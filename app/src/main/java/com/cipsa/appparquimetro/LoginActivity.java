package com.cipsa.appparquimetro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.cipsa.appparquimetro.models.UsuarioMo;
import com.cipsa.appparquimetro.utils.Constants;

public class LoginActivity extends AppCompatActivity {

    private UsuarioMo usuarioMo;
    private  Button btLoginIngresar;
    private  EditText etLoginUsuario;
    private  EditText etLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btLoginIngresar = (Button) findViewById(R.id.btLoginIngresar);
        etLoginUsuario = (EditText) findViewById(R.id.etLoginUsuario);
        etLoginPassword = (EditText)findViewById(R.id.etLoginPassword);

        btLoginIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            validar(etLoginUsuario.getText().toString(),etLoginPassword.getText().toString());
            }
        });

    }

    private  void validar(String usu , String pass)
    {
        String ur = Constants.URL_GET_VAL_USERS +"usu="+ usu +"&contra=" + pass;
        StringRequest request = new StringRequest(
                Request.Method.GET,
                ur,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        ver(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("URL_GET_VAL_USERS",error.toString());
                    }
            }
        );
        ((ParquimetroApp)getApplicationContext()).requestQueue.add(request);

    }

    private void ver(String response){
        usuarioMo = ((ParquimetroApp)getApplicationContext()).gson.fromJson(response,UsuarioMo.class);
        int num = usuarioMo.getValidarUsuarioResults().size();
        Log.i("infor","Numero de usuario"+ String.valueOf(num));
        if (num > 0){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }else 
        {
            Toast.makeText(this, "Usuario o Password incorrecto", Toast.LENGTH_SHORT).show();
        }


    }
}
