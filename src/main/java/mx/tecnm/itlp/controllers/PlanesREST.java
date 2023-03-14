package mx.tecnm.itlp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.itlp.dao.PlanesJDBC;
import mx.tecnm.itlp.models.Plan;

@RestController
@RequestMapping("/planes")
public class PlanesREST {
    
    @Autowired
    PlanesJDBC repository;

    @GetMapping
    public List<Plan> consultar(){
        return repository.consultar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable int id){
        try {
            Plan planBuscado = repository.buscar(id);
            return new ResponseEntity<Plan>(planBuscado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Plan plan){
        try {
            repository.agregar(plan);
            return new ResponseEntity<Plan>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Plan plan){
        try {
            repository.actualizar(plan);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public void desactivar(@PathVariable int id) {
        repository.desactivar(id);
    }
}
