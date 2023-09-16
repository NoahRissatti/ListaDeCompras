package com.example.listadecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DigitaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digita);

        Button botaoCancelar = findViewById(R.id.botaoCancelar);
        Button botaoAdicionar = findViewById(R.id.botaoAdicionar);
        EditText editTextNome = findViewById(R.id.editTextNome);
        EditText editTextMarca = findViewById(R.id.editTextMarca);
        EditText editTextQuantidade = findViewById(R.id.editTextQuantidade);

        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DigitaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();
                String marca = editTextMarca.getText().toString();
                String quantidade = editTextQuantidade.getText().toString();

                ItemDaLista novoItem = new ItemDaLista(nome, marca, quantidade);

                ListaDeCompras.getInstance().adicionarItem(novoItem);
                Intent intent = new Intent(DigitaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}