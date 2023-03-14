package mx.tecnm.itlp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.Director;

@Repository
public class DirectoresJDBC {
    
    @Autowired
    JdbcTemplate conexion; 

    public List<Director> consultar(){
        String sql = "SELECT * FROM directores";
        return conexion.query(sql, new DirectoresRM());
    }

    public Director buscar(int id){
        String sql = "SELECT * FROM directores WHERE id = ?";
        return conexion.queryForObject(sql, new DirectoresRM(), id);
    }

    public void agregar(Director director){
        String sql = "INSERT INTO directores (nombre_completo) VALUES (?)";
        conexion.update(sql, director.getNombre());
        System.out.println("director agregado correctamente");
    }

}
