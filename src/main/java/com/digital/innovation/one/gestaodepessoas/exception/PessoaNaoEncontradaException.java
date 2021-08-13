package com.digital.innovation.one.gestaodepessoas.exception;

public class PessoaNaoEncontradaException extends Exception {
    public PessoaNaoEncontradaException(Long id) {
        super("Pessoa com id: " + " não encontrada :(");
    }
}
