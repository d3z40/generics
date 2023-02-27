package br.com.d3z40.generics.controller;

import br.com.d3z40.generics.model.Cliente;
import br.com.d3z40.generics.model.Fornecedor;
import br.com.d3z40.generics.model.Informacao;
import br.com.d3z40.generics.service.InformacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InformacaoController {

    @Autowired
    private InformacaoService service;

    @PostMapping("/cliente")
    public ResponseEntity<Informacao> saveCliente(@RequestBody Cliente cliente) {
        return service.saveCliente(cliente);
    }

    @PostMapping("/fornecedor")
    public ResponseEntity<Informacao> saveFornecedor(@RequestBody Fornecedor fornecedor) {
        return service.saveFornecedor(fornecedor);
    }

    @GetMapping
    public ResponseEntity<List<Informacao>> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return service.findConteudo(id);
    }
}