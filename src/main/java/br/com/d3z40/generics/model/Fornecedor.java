package br.com.d3z40.generics.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fornecedor extends Pessoa {

    private String cnpj;
    private int prioridade;
}