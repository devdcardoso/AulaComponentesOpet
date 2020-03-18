package com.example.exemplo02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textRateio, textProgresso;
    private CheckBox checkTaxa;
    private EditText editValor;
    private SeekBar seekPessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textRateio = findViewById(R.id.textRateio);
        textProgresso = findViewById(R.id.textProgresso);
        editValor = findViewById(R.id.editValor);
        seekPessoas = findViewById(R.id.seekPessoas);
        checkTaxa = findViewById(R.id.checkTaxa);

        seekPessoas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textProgresso.setText(String.valueOf(i));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    public void calcularRateio(View view) {
        float valor = Float.parseFloat(editValor.getText().toString());
        float pessoas = seekPessoas.getProgress();

        if(checkTaxa.isChecked()){
            valor = valor * 1.10f;
        }

        float rateio = valor / pessoas;

        String texto = String.format("Rateio por pessoa: %.2f",rateio);

        textRateio.setText(texto);
    }
}
