package mx.tecnm.itlp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.itlp.dao.DirectoresJDBC;
import mx.tecnm.itlp.models.Director;

@RestController
@RequestMapping("/directores")
public class DirectoresREST {
    
    @Autowired
    DirectoresJDBC repository;

    @GetMapping
    public List<Director> consultar(){
        return repository.consultar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable int id){
        try{
            Director directorBuscado = repository.buscar(id);
            return new ResponseEntity<Director>(directorBuscado, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Director director){
        try{
            repository.agregar(director);
            return new ResponseEntity<Director>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

}
