package com.example.listadecompras;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ItemDaLista> itens =  new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button meuBotao = findViewById(R.id.botao);
        ListView lista = findViewById(R.id.lista);

        List<ItemDaLista> itens = ListaDeCompras.getInstance().getItens();
        MeuAdapter adapter = new MeuAdapter(this, itens);
        lista.setAdapter(adapter);

        meuBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DigitaActivity.class);
                startActivity(intent);
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemDaLista itemClicado = itens.get(position);
                itemClicado.setComprado(!itemClicado.isComprado());
                adapter.notifyDataSetChanged();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ItemDaLista itemRemovido = itens.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

}