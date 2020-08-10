package com.unitins.projetointegrador2.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date data;

    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private Date hora;

    @OneToMany
    @JoinTable(name = "ProfessorBanca",
            joinColumns = @JoinColumn(name = "idBanca"),
            inverseJoinColumns = @JoinColumn(name = "idProfessor"))
    private List<Professor> professores;

    @OneToOne
    private ProcessoOrientacao processoOrientacao;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public ProcessoOrientacao getProcessoOrientacao() {
        return processoOrientacao;
    }

    public void setProcessoOrientacao(ProcessoOrientacao processoOrientacao) {
        this.processoOrientacao = processoOrientacao;
    }

    public Banca(Date data, Date hora, List<Professor> professores, ProcessoOrientacao processoOrientacao) {
        this.data = data;
        this.hora = hora;
        this.professores = professores;
        this.processoOrientacao = processoOrientacao;
    }

    public Banca() {
    }
}
