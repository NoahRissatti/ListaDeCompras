package com.example.listadecompras;

import java.io.Serializable;

public class ItemDaLista implements Serializable {
    private String titulo;
    private String descricao;
    private String quantidade;
    private boolean comprado;

    public ItemDaLista(String titulo, String descricao, String quantidade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.comprado = false;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getQuantidade() {return quantidade;}
}

