package com.unitins.projetointegrador2.model;

public enum TipoDocumento {

    ACEITEORIENTACAO(1, "Declaração de Aceite de Orientação"),
    COMPROMISSOORIENTACAO(2, "Termo de Compromisso de Orientação de Monografia"),
    RESPONSABILIDADEPLAGIO(3, "Termo de Responsabilidade de Plágio");

    private int valor;
    private String label;

    TipoDocumento(int valor, String label) {
        this.valor = valor;
        this.label = label;
    }

    public int getValor() {
        return valor;
    }

    public String getLabel() {
        return label;
    }
}
