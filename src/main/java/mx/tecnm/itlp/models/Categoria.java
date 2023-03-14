package mx.tecnm.itlp.models;

public class Categoria {

    private int id;
    private String clasificacion;
    private String descripcion;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

}
