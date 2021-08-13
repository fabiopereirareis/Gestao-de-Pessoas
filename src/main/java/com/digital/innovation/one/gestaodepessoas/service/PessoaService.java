package com.digital.innovation.one.gestaodepessoas.service;

import com.digital.innovation.one.gestaodepessoas.dto.MessageResponseDTO;
import com.digital.innovation.one.gestaodepessoas.entity.Pessoa;
import com.digital.innovation.one.gestaodepessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public MessageResponseDTO createPessoa(Pessoa pessoa){
        Pessoa savedPessoa = pessoaRepository.save(pessoa);
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com id " + savedPessoa.getId())
                .build();
    }
    public List<Pessoa> getAllPessoas(){
        return pessoaRepository.findAll();
    }
}
