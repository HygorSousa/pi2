package com.unitins.projetointegrador2.model;

public enum TipoProcessoOrientacao {

    PCC(1, "Projeto de Conclusão de Curso"),
    TCC(2, "Trabalho de Conclusão de Curso");

    private int valor;
    private String label;

    TipoProcessoOrientacao(int valor, String label) {
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
