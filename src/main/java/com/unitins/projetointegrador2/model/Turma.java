package com.unitins.projetointegrador2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer ano;

    private Integer semestre;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;

    public Turma() {
    }

    public Turma(Integer ano, Integer semestre, List<Aluno> alunos) {
        this.ano = ano;
        this.semestre = semestre;
        this.alunos = alunos;
    }
}
