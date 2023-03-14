package mx.tecnm.itlp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import mx.tecnm.itlp.models.Plan;

public class PlanesRM implements RowMapper<Plan>{

    @Override
    @Nullable
    public Plan mapRow(ResultSet rs, int rowNum) throws SQLException {
        Plan plan = new Plan();
        plan.setId(rs.getInt("id"));
        plan.setDescripcion(rs.getString("descripcion"));
        plan.setPrecioMensual(rs.getDouble("precio_mensual"));
        plan.setCalidadVideo(rs.getString("calidad_video"));
        plan.setResolucionVideo(rs.getString("resolucion"));
        plan.setCantidadDispositivos(rs.getInt("cantidad_dispositivos"));
        plan.setActivo(rs.getInt("activo"));
        return plan;
    }
    
}
