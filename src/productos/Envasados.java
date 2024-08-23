package productos;
import java.time.LocalDate;

public class Envasados extends Productos{
    private static int contador=0;
    private String tipoEnvase;
    protected boolean prodImportado;
    private LocalDate fechaVencimiento;
    public Envasados(String descripcion, float precioUnidad, float porcentajeGanancia, boolean disponibilidad, String tipoEnvase, boolean prodImportado, float descuento, LocalDate fechaVencimiento) {
        super(descripcion, precioUnidad, porcentajeGanancia, disponibilidad, descuento);
        setIdentificador(generarIdentificador());
        this.tipoEnvase = tipoEnvase;
        this.prodImportado = prodImportado;
        this.fechaVencimiento = fechaVencimiento;
        calcularPrecioFinal(porcentajeGanancia);
        calcularDescuentoFinal(descuento);
        agregarImpuesto(prodImportado);
    }

    public void agregarImpuesto(boolean prodImportado) {
        if(prodImportado){
            precioUnidad = precioUnidad * 1.12f;
        }
    }
    public void calcularDescuentoFinal(float descuento) {
        if(descuento>15){
            System.out.println("El descuento de productos comestibles no puede ser mayor al 15% no se aplico descuento");
            this.descuento= 0;
        } else {
            this.descuento = descuento;
            super.calcularDescuentoFinal();
        }
    }
    public void calcularPrecioFinal(float porcentajeGanancia){
        if (porcentajeGanancia > 20) {
            System.out.println("El porcentaje de ganancia para productos comestibles no puede superar el 20% no se cambio el precio");
            this.porcentajeGanancia=0;
        } else {
        this.porcentajeGanancia = porcentajeGanancia;
        super.calcularPrecioFinal();
        }
    }
    private void setEnvase(String tipoEnvase){
        this.tipoEnvase= tipoEnvase;
    }
    public String getEnvase(){
        return tipoEnvase;
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
    public String generarIdentificador(){
    contador++;
    return String.format("AB%03d", contador);
    }

}
