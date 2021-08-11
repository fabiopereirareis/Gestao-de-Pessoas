package com.digital.innovation.one.gestaodepessoas.repository;

import com.digital.innovation.one.gestaodepessoas.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
