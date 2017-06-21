package com.pdcasper.springboot.controllers;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;
import com.pdcasper.springboot.domain.Atleta;
import com.pdcasper.springboot.repository.AtletaRepository;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/atletas")
public class AtletaController {

    private final AtletaRepository atletaRepository;

    public AtletaController(AtletaRepository repository) {
        this.atletaRepository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Atleta>
    getAtleta(@PathVariable("id") Long id) {
        Atleta result = new Atleta();
        Atleta tmp = this.atletaRepository.getOne(id);
        result.setId(tmp.getId());
        result.setNombre(tmp.getNombre());
        result.setSexo(tmp.getSexo());
        result.setFechaNacimiento(tmp.getFechaNacimiento());
        return new ResponseEntity<Atleta>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Atleta input) {
        Atleta result = this.atletaRepository.save(input);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
