package br.com.d3z40.generics.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente extends Pessoa {

    private String cpf;
    private int idade;
}