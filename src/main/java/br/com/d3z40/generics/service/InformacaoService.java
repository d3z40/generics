package br.com.d3z40.generics.service;

import br.com.d3z40.generics.constant.TipoPessoa;
import br.com.d3z40.generics.model.Cliente;
import br.com.d3z40.generics.model.Fornecedor;
import br.com.d3z40.generics.model.Informacao;
import br.com.d3z40.generics.repository.InformacaoRepository;
import br.com.d3z40.generics.util.impl.AbstractConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformacaoService {

    @Autowired
    private InformacaoRepository repository;

    @Autowired
    private AbstractConversor<Cliente> clienteConv;

    @Autowired
    private AbstractConversor<Fornecedor> fornecedorConv;

    public ResponseEntity<Informacao> saveCliente(Cliente cliente) {

        String json = clienteConv.objectToJson(cliente);

        Informacao informacao = Informacao.builder()
                .origem(TipoPessoa.CLIENTE.getTipo())
                .conteudo(json)
                .build();

        return saveInfo(informacao);
    }

    public ResponseEntity<Informacao> saveFornecedor(Fornecedor fornecedor) {

        String json = fornecedorConv.objectToJson(fornecedor);

        Informacao informacao = Informacao.builder()
                .origem(TipoPessoa.FORNECEDOR.getTipo())
                .conteudo(json)
                .build();

        return saveInfo(informacao);
    }

    private ResponseEntity<Informacao> saveInfo(Informacao informacao) {
        return new ResponseEntity<>(repository.save(informacao), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Informacao>> findAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> findConteudo(Long id) {
        Optional<Informacao> optional = repository.findById(id);

        if (optional.isPresent()) {
            Informacao informacao = optional.get();

            if (informacao.getOrigem().equals(TipoPessoa.CLIENTE.getTipo())) {
                return new ResponseEntity<>(clienteConv.jsonToModel(informacao.getConteudo()), HttpStatus.OK);
            } else if (informacao.getOrigem().equals(TipoPessoa.FORNECEDOR.getTipo())) {
                return new ResponseEntity<>(fornecedorConv.jsonToModel(informacao.getConteudo()), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}