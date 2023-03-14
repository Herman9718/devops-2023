package mx.tecnm.itlp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import mx.tecnm.itlp.models.Categoria;

public class CategoriasRM implements RowMapper<Categoria> {

    @Override
    @Nullable
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt("id"));
        categoria.setClasificacion(rs.getString("clasificacion"));
        categoria.setDescripcion(rs.getString("descripcion"));
        return categoria;
    }
    
}
