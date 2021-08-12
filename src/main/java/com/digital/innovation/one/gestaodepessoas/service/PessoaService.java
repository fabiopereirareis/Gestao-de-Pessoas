package com.digital.innovation.one.gestaodepessoas.service;

import com.digital.innovation.one.gestaodepessoas.dto.MessageResponseDTO;
import com.digital.innovation.one.gestaodepessoas.dto.request.PessoaDTO;
import com.digital.innovation.one.gestaodepessoas.entity.Pessoa;
import com.digital.innovation.one.gestaodepessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

//    public MessageResponseDTO createPessoa(PessoaDTO pessoaDTO){
//        PessoaDTO savedPessoa = pessoaRepository.save(pessoaDTO);
//        return MessageResponseDTO
//                .builder()
//                .message("Pessoa criada com id " + savedPessoa.getId())
//                .build();
//    }
}
