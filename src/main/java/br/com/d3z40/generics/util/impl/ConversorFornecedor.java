package br.com.d3z40.generics.util.impl;

import br.com.d3z40.generics.model.Pessoa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "ConversorFornecedor")
public class ConversorFornecedor<T extends Pessoa> extends AbstractConversor<T> {

    ConversorFornecedor(@Qualifier("fornecedorClass") Class<T> tClass) {
        super(tClass);
    }
}
