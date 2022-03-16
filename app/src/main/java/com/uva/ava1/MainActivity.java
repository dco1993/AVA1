package com.uva.ava1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCalcAv1, btnCalvMedia;
    TextView lblNotaAv1;
    EditText txtNotaAv2, txtNotaAv3;
    CheckBox cbxRealizouAv3;
    Intent intent;
    float ava1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcAv1 = (Button) findViewById(R.id.btnCalcAv1);
        btnCalvMedia = (Button) findViewById(R.id.btnCalcMedia);

        lblNotaAv1 = (TextView) findViewById(R.id.lblNotaAv1);

        txtNotaAv2 = (EditText) findViewById(R.id.txtNotaAv2);
        txtNotaAv3 = (EditText) findViewById(R.id.txtNotaAv3);

        cbxRealizouAv3 = (CheckBox) findViewById(R.id.cbxRealizouAv3);

        cbxRealizouAv3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    txtNotaAv3.setEnabled(true);
                } else {
                    txtNotaAv3.setEnabled(false);
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            ava1 = data.getFloatExtra("notaAv1",0);
            lblNotaAv1.setText(String.format("*.2f", ava1));
        }
    }

    public void onClickCalculaAv1 (View view){
        intent = new Intent(getApplicationContext(), CalculaAv1.class);
        startActivity(intent);
    }
}