package productos;

public class Limpieza extends Productos{
    private static int contador=0;
    public enum tipoProdLimp {
        Baño, Cocina, Ropa, Multiuso
    }
    private tipoProdLimp tipoProdLimp;
    public Limpieza(String descripcion, float precioUnidad, float porcentajeGanancia, boolean disponibilidad, tipoProdLimp tipoProdLimp, float descuento) {
        super(descripcion, precioUnidad, porcentajeGanancia, disponibilidad, descuento);
        setIdentificador(generarIdentificador());
        this.tipoProdLimp = tipoProdLimp;
        calcularPrecioFinal(porcentajeGanancia);
        calcularDescuentoFinal(descuento);
    }
    public void calcularDescuentoFinal(float descuento) {
        if(descuento>20){
            System.out.println("El descuento de productos de limpieza no puede ser mayor al 20% no se aplico descuento");
            this.descuento= 0;
        } else {
            this.descuento = descuento;
            super.calcularDescuentoFinal();
        }
    }
    public void calcularPrecioFinal(float porcentajeGanancia){
        if (porcentajeGanancia > 25) {
            System.out.println("El porcentaje de ganancia para productos de limpieza no puede superar el 25% no se cambio el precio");
            this.descuento= 0;
        } else if (tipoProdLimp == tipoProdLimp.Ropa || tipoProdLimp == tipoProdLimp.Baño && porcentajeGanancia<10) {
            System.out.println("El porcentaje minimo de ganancia para los productos de tipo Ropa y Baño es de 10%");
            this.descuento= 0;
        } else {
            this.porcentajeGanancia = porcentajeGanancia;
            super.calcularPrecioFinal();
        }
    }
    public Limpieza.tipoProdLimp getTipoProdLimp() {
        return tipoProdLimp;
    }
    public void setTipoProdLimp(tipoProdLimp tipoProdLimp) {
        this.tipoProdLimp = tipoProdLimp;
    }

    public String generarIdentificador(){
        contador++;
        return String.format("AZ%03d", contador);
    }

}