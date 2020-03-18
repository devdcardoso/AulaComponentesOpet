package com.example.aulacomponentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textCategoria;
    private EditText editIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCategoria = findViewById(R.id.textCategoria);
        editIdade = findViewById(R.id.editIdade);
    }

    public void definirCategoria(View view) {
        int idade = Integer.parseInt(editIdade.getText().toString());

        String categoria = "";
        if(idade >= 5 && idade <= 12){
            categoria = "INFANTIL";
        }
        else if(idade > 12 && idade < 18){
            categoria = "JUVENIL";
        }
        else if(idade >= 18){
            categoria = "ADULTO";
        }
        else{
            categoria = "NÃO REGISTRADA";
        }
        textCategoria.setText(categoria);
    }
}
