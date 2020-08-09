package com.unitins.projetointegrador2.repository;

import com.unitins.projetointegrador2.model.AreaConhecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AreaConhecimentoRepository extends JpaRepository<AreaConhecimento, String> {

    Optional<List<AreaConhecimento>> findByDescricao(String descricao);

    Optional<List<AreaConhecimento>> findById(Integer id);

    void deleteById(Integer id);

    List<AreaConhecimento> findAreaConhecimentoByNome(String nome);

}
