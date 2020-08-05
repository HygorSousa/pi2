package com.unitins.projetointegrador2.model;

public enum Status {
    ANALISE(1, "Em Análise"),
    REJEITADOANALISE(2, "Rejeitado na Análise"),
    ENCAMINHADOORIENTADOR(3, "Encaminhado para o Orientador"),
    REJEITADO(4, "Rejeitado pelo Orientador"),
    ACEITO(5, "Aceito pelo Orientador"),
    ASSINARTERMOCOMPROMISSO(6, "Assinar Termo de Compromisso"),
    ASSINARTERMORESPONSABILIDADE(7, "Assinar Termo de Responsabilidade"),
    ANDAMENTO(8, "Projeto em Andamento"),
    APROVADO(9, "Projeto Aprovado"),
    BANCA(10, "Banca Definida"),
    CORRIGIDO(11, "Projeto Corrigido"),
    ENVIOATA(12, "Envio de Ata da Defesa"),
    ENVIOFICHA(13, "Envio da Ficha Bibliográfica"),
    FINALIZADO(14, "Processo Finalizado");

    private int valor;
    private String label;

    Status(int valor, String label) {
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
