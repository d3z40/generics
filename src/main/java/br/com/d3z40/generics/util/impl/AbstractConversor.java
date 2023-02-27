package br.com.d3z40.generics.util.impl;

import br.com.d3z40.generics.model.Pessoa;
import br.com.d3z40.generics.util.Conversor;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AbstractConversor<T extends Pessoa> implements Conversor<T> {

    @Autowired
    private Gson gson;

    private Class<T> tClass;

    AbstractConversor(@Qualifier("clienteClass") Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public String objectToJson(T model) {
        return gson.toJson(model);
    }

    @Override
    public T jsonToModel(String json) {
        return gson.fromJson(json, tClass);
    }
}