import productos.Envasados;
import productos.Bebidas;
import productos.Limpieza;
import tienda.Tienda;

import java.time.LocalDate;
import java.util.ArrayList;
/*
* Notas: El sistema es ambiguo a la hora de decir donde se tiene que controlar el stock si en el producto mismo o el de la tienda
* y que producto es comestible o no a su vez de decir cual es el limite del stock
*
*  */
public class TestTienda {
    public static void main(String[] args) {
   /* Bebidas Coca = new Bebidas("Gas", 3, 3,true, "No", true, 32, LocalDate.of(2002, 12, 12));
    Validacion.validarIdentificador(Coca.getIdentificador(), 5);
        System.out.println("El identificador de producto es " + Coca.getIdentificador() + Coca.isDisponibilidad());
        Validacion.stockProducto(Coca.isDisponibilidad());
        System.out.println(Coca.getFechaVencimiento());*/
        Limpieza Trapo = new Limpieza("Trapo", 12, 5, true, Limpieza.tipoProdLimp.Baño, 3);
        Tienda miTienda = new Tienda("shalu", 0, 1500);
        Bebidas fanta = new Bebidas("fanta", 10, 15, true, 3f, true, 5, LocalDate.of(2025, 12, 23));
        Bebidas coca = new Bebidas("coca", 1, 0, true, 6f,true , 0, LocalDate.of(2015, 12, 23));
        Envasados fentis = new Envasados("Coke", 1, 0, false, "vidrio", false, 9, LocalDate.of(2020, 10, 12));
        Envasados pepsi = new Envasados("pepsi", 1, 10, true, "embotellado", false, 7, LocalDate.of(2014, 12, 23));
        miTienda.agregarProducto(fentis, 3);
        miTienda.agregarProducto(coca, 99);
        miTienda.agregarProducto(pepsi, 20);
        miTienda.agregarProducto(Trapo, 3);
        System.out.println(pepsi.isDisponibilidad());
        miTienda.getListaProductos();
        miTienda.agregarProducto(coca, 1);
        miTienda.getListaProductos();
        miTienda.getClasificacionDeDroductos();
        pepsi.setDisponibilidad(true);
        ArrayList<String> identificadores = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();
        identificadores.add(coca.getIdentificador());
        identificadores.add(pepsi.getIdentificador());
        cantidades.add(5);
        cantidades.add(3);
        System.out.println(coca.calcularPrecioFinal());
        System.out.println(coca.getPrecioUnidad());
        pepsi.setProdImportado(true);
        coca.setProdImportado(true);
        System.out.println(coca.getPrecioUnidad());
        coca.setPrecioFinal();
        coca.setDescuentoFinal();
        System.out.println(coca.getPrecioUnidad());
        miTienda.venderProductos(identificadores, cantidades);
        miTienda.getListaProductos();
        System.out.println(fanta.getPrecioUnidad());
        System.out.println(coca.getPrecioUnidad());
        System.out.println(pepsi.getPrecioUnidad());
        System.out.println(miTienda.getSaldoCaja());
        System.out.println(fanta.getPrecioUnidad());
        fentis.setProdImportado(true);
        pepsi.setProdImportado(false);
        System.out.println(pepsi.isProdImportado());
        miTienda.obtenerComestiblesConMenorDescuento(15.0f);
    }
}