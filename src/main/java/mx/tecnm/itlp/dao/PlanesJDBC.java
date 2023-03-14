package mx.tecnm.itlp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.itlp.models.Plan;

@Repository
public class PlanesJDBC {
    
    @Autowired
    JdbcTemplate conexion; 

    public List<Plan> consultar(){
        String sql = "SELECT * FROM planes";
        return conexion.query(sql, new PlanesRM());
    }

    public void agregar(Plan plan){
        String sql = "INSERT INTO planes (descripcion, precio_mensual, calidad_video, resolucion, cantidad_dispositivos) "
        +" VALUES (?, ?, ?, ?, ?)";
        conexion.update(sql, plan.getDescripcion(), plan.getPrecioMensual(), 
        plan.getCalidadVideo(), plan.getResolucionVideo(), plan.getCantidadDispositivos());
    }

    public void actualizar(Plan plan){
        String sql = "UPDATE planes SET descripcion = ?, precio_mensual = ?, calidad_video = ?, resolucion = ?, "
        +" cantidad_dispositivos = ? WHERE id = ?";
        conexion.update(sql, plan.getDescripcion(), plan.getPrecioMensual(), 
        plan.getCalidadVideo(), plan.getResolucionVideo(), plan.getCantidadDispositivos(), plan.getId());
    }

    public Plan buscar(int id){
        String sql = "SELECT * FROM planes WHERE id = ?";
        return conexion.queryForObject(sql, new PlanesRM(), id);
    }

    public void desactivar(int id){
        String sql = "UPDATE planes SET activo = 0 WHERE id = ?";
        conexion.update(sql, id);
    }
}
