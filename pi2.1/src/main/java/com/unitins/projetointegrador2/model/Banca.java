package com.unitins.projetointegrador2.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Banca extends AuditoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date data;

    @Temporal(TemporalType.TIME)
    private Date hora;

    @OneToMany
    @JoinTable(name = "ProfessorBanca",
            joinColumns = @JoinColumn(name = "idBanca"),
            inverseJoinColumns = @JoinColumn(name = "idProfessor"))
    private List<Professor> professores;
}
