package com.digital.innovation.one.gestaodepessoas.controller;

import com.digital.innovation.one.gestaodepessoas.dto.MessageResponseDTO;
import com.digital.innovation.one.gestaodepessoas.dto.request.PessoaDTO;
import com.digital.innovation.one.gestaodepessoas.exception.PessoaNaoEncontradaException;
import com.digital.innovation.one.gestaodepessoas.service.PessoaService;
import io.swagger.annotations.ApiOperation;
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


    @ApiOperation(value = "Adicionar pessoa")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPessoa(@RequestBody @Valid PessoaDTO pessoaDTO){
       return pessoaService.createPessoa(pessoaDTO);
    }

    @ApiOperation(value = "Listar todas pessoas")
    @GetMapping("/listar")
    public List<PessoaDTO> getAllPessoas(){
        return pessoaService.getAllPessoas();
    }

    @ApiOperation(value = "Listar pessoa por ID")
    @GetMapping("/listarid/{id}")
    public PessoaDTO findPessoaDTO(@PathVariable Long id) throws PessoaNaoEncontradaException {
        return pessoaService.findById(id);
    }

    @ApiOperation(value = "Deletar pessoa")
    @DeleteMapping("/apagarid/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePessoa(@PathVariable Long id) throws PessoaNaoEncontradaException {
        pessoaService.deleteById(id);
    }

    @ApiOperation(value = "Atualizar pessoa")
    @PutMapping("/atualizarid/{id}")
    public MessageResponseDTO updatePessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
        return pessoaService.updatePessoa(id,pessoaDTO);
    }
}
