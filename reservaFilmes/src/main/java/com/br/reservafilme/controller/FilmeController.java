package com.br.reservafilme.controller;

import com.br.reservafilme.entity.Filme;
import com.br.reservafilme.service.FilmeService;
import com.br.reservafilmes.entity.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    FilmeService service;

    @GetMapping("/listar-filmes")
    @ResponseStatus(HttpStatus.OK)
    public List<Filme> findAll() {
        return service.listaTodos();
    }

    @GetMapping("/listar-por-nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Filme> buscarNome(@PathVariable String nome) {
        return service.listaPorNome(nome);
    }

    @GetMapping("/listar-filme-genero/{idGenero}")
    @ResponseStatus(HttpStatus.OK)
    public List<Filme> listarFilmesGenero(@PathVariable Long idGenero) {
        return service.listaFilmesGenero(idGenero);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Filme> create(@RequestBody Filme filme) {
        Filme filmeCreated = service.create(filme);

        return ResponseEntity.status(201).body(filmeCreated);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Filme> update(@RequestBody Filme filme) {
        Filme filmeCreated = service.create(filme);

        return ResponseEntity.status(201).body(filmeCreated);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Filme> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
