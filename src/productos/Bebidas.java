package productos;
import java.time.LocalDate;

public class Bebidas extends Productos{
    private static int contador=0;
    private float gradAlcoholica;
    protected boolean prodImportado;
    private LocalDate fechaVencimiento;
    public Bebidas(String descripcion, float precioUnidad, float porcentajeGanancia, boolean disponibilidad, float gradAlcoholica, boolean prodImportado, float descuento, LocalDate fechaVencimiento) {
        super(descripcion, precioUnidad, porcentajeGanancia, disponibilidad, descuento);
        setIdentificador(generarIdentificador());
        this.gradAlcoholica = gradAlcoholica;
        this.prodImportado = true;
        this.fechaVencimiento = fechaVencimiento;
        this.precioUnidad = calcularPrecio();
        calcularDescuentoFinal(descuento);
        agregarImpuesto(prodImportado);
    }
    public void agregarImpuesto(boolean prodImportado) {
        if(prodImportado){
            precioUnidad = precioUnidad * 1.12f;
        }
    }
    public void calcularDescuentoFinal(float descuento) {
        if(descuento>10){
            System.out.println("El descuento de bebidas no puede ser mayor al 10% no se aplico descuento");
            this.descuento= 0;
        } else {
            this.descuento = descuento;
            super.calcularDescuentoFinal();
        }
    }
    private void setGradAlcoholica(float gradAlcoholica){
        this.gradAlcoholica= gradAlcoholica;
    }
    private float getEnvase(){
        return gradAlcoholica;
    }
    public void setProdImportado(boolean prodImportado){
        this.prodImportado= prodImportado;
    }
    public boolean isProdImportado(){
        return prodImportado;
    }
    private void setFechaVencimiento(LocalDate fechaVencimiento){
        this.fechaVencimiento= fechaVencimiento;
    }
    public LocalDate getFechaVencimiento(){
        return fechaVencimiento;
    }
    public float calcularPrecio(){
        if(gradAlcoholica < 2 && gradAlcoholica > 0){
            return precioUnidad;
        } else if ( gradAlcoholica < 4.5 && gradAlcoholica > 2.1){
            precioUnidad *= 1.25;
            return precioUnidad;
        }else {
            precioUnidad *= 1.5;
            return precioUnidad;
        }
    }
    public String generarIdentificador(){
        contador++;
        return String.format("AC%03d", contador);
    }

}