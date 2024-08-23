package productos;
import validadores.Validacion;

public abstract class Productos {
    protected String identificador;
    protected String descripcion;
    protected float precioUnidad;
    protected float porcentajeGanancia;
    protected boolean disponibilidad;
    protected float descuento;
    protected int cantidad;
    public Productos(String descripcion, float precioUnidad, float porcentajeGanancia, boolean disponibilidad, float descuento) {
        this.descripcion = descripcion;
        this.precioUnidad = precioUnidad;
        this.porcentajeGanancia = porcentajeGanancia;
        this.disponibilidad = disponibilidad;
        this.descuento= descuento;
        this.cantidad=0;
    }
    public float calcularPrecioFinal() {
        return precioUnidad + (precioUnidad * (porcentajeGanancia / 100));
    }
    public void setPrecioFinal(){
        this.precioUnidad=calcularPrecioFinal();
    }
    public float calcularDescuentoFinal() {
        return precioUnidad - (precioUnidad * (descuento / 100));
    }
    public void setDescuentoFinal(){
        this.precioUnidad=calcularDescuentoFinal();
    }
    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public String generarIdentificador() {
        return "ID000";
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public float getPrecioUnidad() {
        return precioUnidad;
    }
    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }
    public float getPorcentajeGanancia() {
        return porcentajeGanancia;
    }
    public void setPorcentajeGanancia(float porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }
    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public float getDescuento(){
        return descuento;
    }
    public void setDescuento(float descuento){
        this.descuento = descuento;
    }
    public void incrementarCantidad(int cantidad){
        this.cantidad += cantidad;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void reducirCantidad(int cantidad){
        if(this.cantidad >= cantidad){
            this.cantidad -= cantidad;
        } else {
            this.cantidad=0;
        }
    }

}
