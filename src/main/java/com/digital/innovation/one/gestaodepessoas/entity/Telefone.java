package com.digital.innovation.one.gestaodepessoas.entity;

import com.digital.innovation.one.gestaodepessoas.enums.TipoTelefone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTelefone tipoTelefone;

    @Column(nullable = false)
    private String numero;
}
