package mx.tecnm.itlp.controllers;
import mx.tecnm.itlp.dao.MiListaJDBC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.itlp.models.MiLista;

@RestController
@RequestMapping("/lista")
public class MiListaREST {
    
    @Autowired
    MiListaJDBC repository;


    @PostMapping("/postlist")
    public ResponseEntity<?> agregar(@RequestBody MiLista lista){
        try{
            repository.agregar(lista);
            return new ResponseEntity<MiLista>(HttpStatus.CREATED);
        }catch(Exception e){
        	e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public List<MiLista> consultar(){
        return repository.consultar();
    }

    @GetMapping("/getlistas/{id}")
    public ResponseEntity<?> buscar(@PathVariable int id){
        try{
            MiLista listaBuscada = repository.buscar(id);
            return new ResponseEntity<MiLista>(listaBuscada, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }
    
    @DeleteMapping("/dellista")
	public ResponseEntity<?> eliminarPelicula(@RequestParam int pelicula_id, @RequestParam int perfil_usuario_id) {
		try {
			repository.eliminarPelicula(pelicula_id, perfil_usuario_id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
    
    @GetMapping("/id")
    public int buscarPeliculas(@RequestParam int perfiles_usuarios_id){
    	try {
    		return  repository.buscarPeliculas(perfiles_usuarios_id);
    	}catch(Exception e) {
            return 0;

    	}
    	
    }


}