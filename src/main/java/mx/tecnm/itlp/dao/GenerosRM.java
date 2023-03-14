package mx.tecnm.itlp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import mx.tecnm.itlp.models.Genero;

public class GenerosRM implements RowMapper<Genero> {

    @Override
    @Nullable
    public Genero mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genero genero = new Genero();
        genero.setId(rs.getInt("id"));
        genero.setNombre(rs.getString("nombre"));
        return genero;
    }
    
}
