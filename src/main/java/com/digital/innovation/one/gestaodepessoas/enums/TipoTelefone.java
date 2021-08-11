package com.digital.innovation.one.gestaodepessoas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {
    Casa("Casa"),
    Celular ("Celular"),
    Comercial("Comercial");

    private final String descricao;
}
