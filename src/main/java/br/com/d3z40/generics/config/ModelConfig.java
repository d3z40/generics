package br.com.d3z40.generics.config;

import br.com.d3z40.generics.model.Cliente;
import br.com.d3z40.generics.model.Fornecedor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {

    @Bean(value = "fornecedorClass")
    public Class<Fornecedor> getClassFornecedor() {
        return Fornecedor.class;
    }

    @Bean(value = "clienteClass")
    public Class<Cliente> getClassCliente() {
        return Cliente.class;
    }
}
