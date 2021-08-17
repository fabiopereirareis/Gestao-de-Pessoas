package com.digital.innovation.one.gestaodepessoas.controller;

import com.digital.innovation.one.gestaodepessoas.dto.MessageResponseDTO;
import com.digital.innovation.one.gestaodepessoas.dto.request.PessoaDTO;
import com.digital.innovation.one.gestaodepessoas.entity.Pessoa;
import com.digital.innovation.one.gestaodepessoas.exception.PessoaNaoEncontradaException;
import com.digital.innovation.one.gestaodepessoas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v0/pessoa")
public class PessoaController {

    @GetMapping
    public String getBook(){
        return "Aplicação ok";
    }

    private PessoaService pessoaService;

    @Autowired
    private PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPessoa(@RequestBody @Valid PessoaDTO pessoaDTO){
       return pessoaService.createPessoa(pessoaDTO);
    }

    @GetMapping("/listar")
    public List<PessoaDTO> getAllPessoas(){
        return pessoaService.getAllPessoas();
    }

    @GetMapping("/listarid/{id}")
    public PessoaDTO findPessoaDTO(@PathVariable Long id) throws PessoaNaoEncontradaException {
        return pessoaService.findById(id);
    }

    @DeleteMapping("/apagarid/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePessoa(@PathVariable Long id) throws PessoaNaoEncontradaException {
        pessoaService.deleteById(id);
    }

    @PutMapping("/atualizarid/{id}")
    public MessageResponseDTO updatePessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
        return pessoaService.updatePessoa(id,pessoaDTO);
    }
}
