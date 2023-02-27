package br.com.d3z40.generics.util;

import br.com.d3z40.generics.model.Pessoa;

public interface Conversor<T extends Pessoa> {

    String objectToJson(T model);

    T jsonToModel(String json);
}