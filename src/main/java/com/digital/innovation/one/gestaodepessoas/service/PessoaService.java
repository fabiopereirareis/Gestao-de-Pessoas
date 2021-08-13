package com.digital.innovation.one.gestaodepessoas.service;

import com.digital.innovation.one.gestaodepessoas.dto.MessageResponseDTO;
import com.digital.innovation.one.gestaodepessoas.dto.request.PessoaDTO;
import com.digital.innovation.one.gestaodepessoas.entity.Pessoa;
import com.digital.innovation.one.gestaodepessoas.mapper.PessoaMapper;
import com.digital.innovation.one.gestaodepessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public MessageResponseDTO createPessoa(PessoaDTO pessoaDTO){
        Pessoa conversaoPessoa = pessoaMapper.toModel(pessoaDTO);
        Pessoa savedPessoa = pessoaRepository.save(conversaoPessoa);
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com id " + savedPessoa.getId())
                .build();
    }
    public List<PessoaDTO> getAllPessoas(){
        List<Pessoa> listAllPessoas = pessoaRepository.findAll();
        return listAllPessoas.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
