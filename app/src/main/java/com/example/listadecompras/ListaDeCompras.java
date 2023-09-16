package com.example.listadecompras;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCompras {
    private static final ListaDeCompras instance = new ListaDeCompras();
    private List<ItemDaLista> itens = new ArrayList<>();

    private ListaDeCompras() {
    }

    public static ListaDeCompras getInstance() {
        return instance;
    }

    public List<ItemDaLista> getItens() {
        return itens;
    }

    public void adicionarItem(ItemDaLista item) {
        itens.add(item);
    }
}
