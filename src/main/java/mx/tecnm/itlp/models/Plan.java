package mx.tecnm.itlp.models;

public class Plan {
    
    private int id;
    private String descripcion;
    private double precioMensual;
    private String calidadVideo;
    private String resolucionVideo;
    private int cantidadDispositivos;
    private int activo;
    
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
    public double getPrecioMensual() {
        return precioMensual;
    }
    public void setPrecioMensual(double precioMensual) {
        this.precioMensual = precioMensual;
    }
    public String getCalidadVideo() {
        return calidadVideo;
    }
    public void setCalidadVideo(String calidadVideo) {
        this.calidadVideo = calidadVideo;
    }
    public String getResolucionVideo() {
        return resolucionVideo;
    }
    public void setResolucionVideo(String resolucionVideo) {
        this.resolucionVideo = resolucionVideo;
    }
    public int getCantidadDispositivos() {
        return cantidadDispositivos;
    }
    public void setCantidadDispositivos(int cantidadDispositivos) {
        this.cantidadDispositivos = cantidadDispositivos;
    }

    public int getActivo() {
        return activo;
    }
    public void setActivo(int activo) {
        this.activo = activo;
    }
}
