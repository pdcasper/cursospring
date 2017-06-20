package com.pdcasper.springboot.controllers;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;
import com.pdcasper.springboot.domain.Atleta;
import com.pdcasper.springboot.repository.AtletaRepository;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/atletas")
public class AtletaController {

    private final AtletaRepository atletaRepository;

    public AtletaController(AtletaRepository repository) {
        this.atletaRepository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Atleta getAtleta(@RequestParam(value = "id", required = true) Long id) {
        return this.atletaRepository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> add(@RequestBody Atleta input) {
        Atleta atleta = new Atleta(
                input.getNombre(),
                input.getApellidos(),
                input.getSexo(), input.getFechaNacimiento()
        );
        
        Atleta result = this.atletaRepository.save(atleta);
        URI location = ServletUriComponentsBuilder
						.fromCurrentRequest().path("/{id}")
						.buildAndExpand(result.getId()).toUri();

	return ResponseEntity.created(location).build();
    }
}
