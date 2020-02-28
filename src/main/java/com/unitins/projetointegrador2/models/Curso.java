package com.unitins.projetointegrador2.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;

    @OneToMany
    private List<Professor> professores;
}
