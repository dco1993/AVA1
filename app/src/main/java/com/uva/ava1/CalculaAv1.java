package com.uva.ava1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculaAv1 extends AppCompatActivity {

    EditText txtNotaAva1, txtNotaAva2;
    Button btnEnviarAv1;
    float ava1, ava2, av1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula_av1);

        txtNotaAva1 = (EditText) findViewById(R.id.txtNotaAva1);
        txtNotaAva2 = (EditText) findViewById(R.id.txtNotaAva2);

        btnEnviarAv1 = (Button) findViewById(R.id.btnEnviarAv1);
    }

    public void retornaAv1(View view){
        intent = new Intent();
        ava1 = Float.parseFloat(txtNotaAva1.getText().toString());
        ava2 = Float.parseFloat(txtNotaAva2.getText().toString());
        av1 = (ava1 + ava2) / 2;
        intent.putExtra("notaAv1",av1);
        setResult(RESULT_OK, intent);
        finish();
    }
}