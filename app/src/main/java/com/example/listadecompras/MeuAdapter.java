package com.example.listadecompras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;

public class MeuAdapter extends ArrayAdapter<ItemDaLista> {

    public MeuAdapter(Context context, List<ItemDaLista> itens) {
        super(context, 0, itens);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_item_lista, parent, false);
        }

        TextView tituloTextView = convertView.findViewById(R.id.tituloTextView);
        TextView descricaoTextView = convertView.findViewById(R.id.descricaoTextView);
        TextView quantidadeTextView = convertView.findViewById(R.id.quantidadeTextView);
        TextView compradoTextView = convertView.findViewById(R.id.compradoTextView);

        ItemDaLista item = getItem(position);

        if (item != null) {
            tituloTextView.setText(item.getTitulo());
            descricaoTextView.setText(item.getDescricao());
            quantidadeTextView.setText("(" + item.getQuantidade() + ")");

            if (item.isComprado()) {
                compradoTextView.setText("Concluído");
            } else {
                compradoTextView.setText("");
            }
        }

        return convertView;
    }
}
