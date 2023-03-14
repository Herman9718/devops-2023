package mx.tecnm.itlp.controllers;
import mx.tecnm.itlp.dao.CategoriasJDBC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.itlp.models.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriasRest {
    
    @Autowired
    CategoriasJDBC repository;

    @GetMapping
    public List<Categoria> consultar() {

        return repository.consultar();
    }

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Categoria categoria){
        try{
            repository.agregar(categoria);
            return new ResponseEntity<Categoria>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }
}
