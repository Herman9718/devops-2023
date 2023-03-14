package mx.tecnm.itlp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import mx.tecnm.itlp.models.Director;

public class DirectoresRM implements RowMapper<Director>{

    @Override
    @Nullable
    public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
        Director director = new Director();
        director.setId(rs.getInt("id"));
        director.setNombre(rs.getString("nombre_completo"));
        return director;
    }
    
}
