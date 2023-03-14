package mx.tecnm.itlp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.Genero;

@Repository
public class GenerosJDBC {
    
    @Autowired
    JdbcTemplate conexion; 

    public List<Genero> consultar(){
        String sql = "SELECT * FROM generos";
        return conexion.query(sql, new GenerosRM());
    }

    public void agregar(Genero genero){
        String sql = "INSERT INTO generos (nombre) VALUES (?)";
        conexion.update(sql, genero.getNombre());
        System.out.println("genero agregado correctamente");
    }
}
