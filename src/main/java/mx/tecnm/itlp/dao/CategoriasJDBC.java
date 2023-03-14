package mx.tecnm.itlp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.Categoria;

@Repository
public class CategoriasJDBC{

    @Autowired
    JdbcTemplate conexion; 

    public List<Categoria> consultar(){
        String sql = "SELECT * FROM categorias";
        return conexion.query(sql, new CategoriasRM());
    }

    public void agregar(Categoria categoria){
        String sql = "INSERT INTO categorias (clasificacion, descripcion) VALUES (?,?)";
        conexion.update(sql, categoria.getClasificacion(), categoria.getDescripcion());
        System.out.println("categoria agregada correctamente");
    }
}
