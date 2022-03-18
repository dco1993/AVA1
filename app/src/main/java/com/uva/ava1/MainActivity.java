package com.uva.ava1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int ACTIVITY_REQUEST_AV1 = 1;
    Button btnCalcAv1, btnCalvMedia;
    TextView lblNotaAv1;
    EditText txtNotaAv2, txtNotaAv3;
    CheckBox cbxRealizouAv3;
    Intent intent;
    float ava1;
    float media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcAv1 = (Button) findViewById(R.id.btnCalcAv1);
        btnCalvMedia = (Button) findViewById(R.id.btnCalcMedia);

        lblNotaAv1 = (TextView) findViewById(R.id.lblNotaAv1);
        lblNotaAv1.setVisibility(View.INVISIBLE);

        txtNotaAv2 = (EditText) findViewById(R.id.txtNotaAv2);
        txtNotaAv3 = (EditText) findViewById(R.id.txtNotaAv3);

        cbxRealizouAv3 = (CheckBox) findViewById(R.id.cbxRealizouAv3);

        cbxRealizouAv3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    txtNotaAv3.setEnabled(true);
                    txtNotaAv2.setEnabled(false);
                } else {
                    txtNotaAv3.setEnabled(false);
                    txtNotaAv2.setEnabled(true);
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            ava1 = data.getFloatExtra("notaAv1",0);
            lblNotaAv1.setText("Sua nota da AV1: " + String.format("%.1f", ava1));
            lblNotaAv1.setVisibility(View.VISIBLE);
        }
    }

    public void onClickCalculaAv1 (View view){
        intent = new Intent(getApplicationContext(), CalculaAv1.class);
        startActivityForResult(intent, ACTIVITY_REQUEST_AV1);
    }

    public void onClickCalculaMedia (View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Sua Média:");

        if(cbxRealizouAv3.isChecked()){
            media = (ava1 + Float.parseFloat(txtNotaAv3.getText().toString())) / 2;
            dialog.setMessage("Sua média ficou: " + String.format("%.1f", media) + "\n"
                    + "Composição: " + String.format("%.1f", ava1) + " + " + txtNotaAv3.getText().toString()
                    + " / 2 = " + String.format("%.1f", media) + "\nSua nota da AV2 foi desconsiderada!");
        } else {
            media = (ava1 + Float.parseFloat(txtNotaAv2.getText().toString())) / 2;
            dialog.setMessage("Sua média ficou: " + String.format("%.1f", media) + "\n"
                    + "Composição: " + String.format("%.1f", ava1) + " + " + txtNotaAv2.getText().toString()
                    + " / 2 = " + String.format("%.1f", media));
        }

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        dialog.create();
        dialog.show();

    }
}