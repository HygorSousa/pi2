package com.unitins.projetointegrador2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer ano;

    private Integer semestre;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;
}
