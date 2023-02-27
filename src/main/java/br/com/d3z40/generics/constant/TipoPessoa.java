package br.com.d3z40.generics.constant;

public enum TipoPessoa {

    CLIENTE("cliente"),
    FORNECEDOR("fornecedor");

    private String tipo;

    TipoPessoa(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}