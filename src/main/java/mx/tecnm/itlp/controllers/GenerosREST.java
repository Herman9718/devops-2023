package mx.tecnm.itlp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.itlp.dao.GenerosJDBC;
import mx.tecnm.itlp.models.Genero;

@RestController
@RequestMapping("/generos")
public class GenerosREST {
    
    @Autowired
    GenerosJDBC repository;

    @GetMapping
    public List<Genero> consultar() {

        return repository.consultar();
    }

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Genero genero){
        try{
            repository.agregar(genero);
            return new ResponseEntity<Genero>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

}
