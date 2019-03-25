package com.alex7498.labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.alex7498.labo3.Utils.AppConstants;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private boolean f1,f2,f3;

    private String[] data = new String[4];

    private Button mButton;
    private EditText mUsername, mPassword, mEmail;
    private RadioButton mM, mF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = findViewById(R.id.User);
        mPassword = findViewById(R.id.Pass);
        mEmail = findViewById(R.id.mail);
        mM = findViewById(R.id.M);
        mF = findViewById(R.id.F);
        mButton = findViewById(R.id.send);



        mButton.setOnClickListener(v-> {
            Intent mIntent = new Intent(MainActivity.this, newActivity.class);

            if (mUsername.getText().toString().equals("")) {
                Toast.makeText(this, "Debe ingresar un nombre de usuario", Toast.LENGTH_LONG).show();
            } else {
                data[0] = mUsername.getText().toString();
                f1 = true;
            }

            if (mPassword.getText().toString().equals("")) {
                Toast.makeText(this, "Debe ingresar una contraseña", Toast.LENGTH_LONG).show();
            } else {
                data[1] = mPassword.getText().toString();
                f2 = true;
            }

            if (mEmail.getText().toString().equals("")) {
                Toast.makeText(this, "Debe ingresar una direccion de correo", Toast.LENGTH_LONG).show();
            } else {
                if (Patterns.EMAIL_ADDRESS.matcher(mEmail.getText()).matches()) {
                    data[2] = mEmail.getText().toString();
                    f3 = true;
                } else {
                    Toast.makeText(this, "Debe ingresar una direccion de correo valida", Toast.LENGTH_LONG).show();
                }
            }

            if (mM.isChecked()){
                data[3] = "Masculino";
            } else {
                if (mF.isChecked()){
                    data[3] = "Femenino";
                }else{
                    Toast.makeText(this, "Seleccione un genero.", Toast.LENGTH_LONG).show();
                }

            }

            if(f1 && f2 && f3){
                Toast.makeText(this, "funciona", Toast.LENGTH_LONG).show();
                mIntent.putExtra(AppConstants.T1, data);
                startActivity(mIntent);
            }
        });
    }

}
