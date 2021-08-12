package com.digital.innovation.one.gestaodepessoas.controller;

import com.digital.innovation.one.gestaodepessoas.dto.MessageResponseDTO;
import com.digital.innovation.one.gestaodepessoas.dto.request.PessoaDTO;
import com.digital.innovation.one.gestaodepessoas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v0/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    private PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public MessageResponseDTO createPessoa(@RequestBody @Valid PessoaDTO pessoaDTO){
//       return pessoaService.createPessoa(pessoaDTO);
//    }
}
