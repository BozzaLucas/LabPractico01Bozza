package tienda;
import validadores.Validacion;
import productos.Bebidas;
import productos.Envasados;
import productos.Limpieza;
import productos.Productos;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tienda {
    protected String nombre;
    protected int stockProductos;
    protected float saldoCaja;
    protected ArrayList<Productos> listaProductos;
    protected ArrayList<String> identificadores;
    protected ArrayList<Integer> cantidades;
    public Tienda(String nombre, int stockProductos, float saldoCaja) {
        this.nombre = nombre;
        this.stockProductos = stockProductos;
        this.saldoCaja = saldoCaja;
        listaProductos= new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getStockProductos() {
        return stockProductos;
    }
    public void setStockProductos(int stockProductos) {
        this.stockProductos = stockProductos;
    }
    public float getSaldoCaja() {
        return saldoCaja;
    }
    public void setSaldoCaja(float saldoCaja) {
        this.saldoCaja = saldoCaja;
    }
    public void obtenerComestiblesConMenorDescuento(float porcentajeDescuento) {
        List<String> productosConDescuento = listaProductos.stream()
                .filter(producto -> producto instanceof Envasados)
                .map(producto -> (Envasados) producto)
                .filter(envasado -> envasado.getDescuento() < porcentajeDescuento && !envasado.isProdImportado())
                .map(Envasados::getDescripcion)
                .collect(Collectors.toList());
        if (productosConDescuento.isEmpty()) {
            System.out.println("No hay productos envasados que cumplan con los criterios.");
        } else {
            String resultado = String.join(", ", productosConDescuento);
            System.out.println("Productos envasados con descuento menor al " + porcentajeDescuento + "%: " + resultado);
        }
    }


    public void agregarProducto(Productos producto, int cantidad) {
        float valorTotal= producto.getPrecioUnidad()*cantidad;
            if (saldoCaja >= valorTotal) {
                producto.setDisponibilidad(true);
                for (Productos p : listaProductos) {
                    if (p.getIdentificador().equals(producto.getIdentificador())) {
                        if(p.getCantidad() + cantidad <= 99){
                            saldoCaja = saldoCaja - valorTotal;
                            p.incrementarCantidad(cantidad);
                            System.out.println("Compra exitosa, total pagado " + valorTotal + " total restante " + saldoCaja);
                            return;
                        } else {
                            System.out.println("Error maximo de productos alcanzado (max 99)");
                        }
                        return;
                    }
                }
                if(producto.getCantidad() + cantidad <= 99){
                saldoCaja = saldoCaja - valorTotal;
                System.out.println("Compra exitosa, total pagado " + valorTotal + " total restante " + saldoCaja);
                producto.incrementarCantidad(cantidad);
                listaProductos.add(producto);
                } else {
                    System.out.println("Error maximo de productos alcanzado (max 99)");
                }
            } else {
                System.out.println("No hay saldo suficiente en la caja el total a pagar es de " + valorTotal + " Y hay " + saldoCaja);
            }
    }
    public void getListaProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos cargados");
        } else {
            for (Productos producto : listaProductos) {
                System.out.println("Producto: " + producto.getDescripcion() + " ID " + producto.getIdentificador() + " Precio: " + producto.getPrecioUnidad() + " Cantidad: " + producto.getCantidad());
            }
        }
    }
    public void getClasificacionDeDroductos(){
        for(Productos producto: listaProductos){
            if(producto instanceof Bebidas){
                System.out.println("Bebida : Producto " + producto.getDescripcion() + " ID " + producto.getIdentificador());
            } else if (producto instanceof Envasados){
                System.out.println("Envasados : Producto " + producto.getDescripcion() + " ID " + producto.getIdentificador());
            } else {
                System.out.println("Limpieza : Producto " + producto.getDescripcion() + " ID " + producto.getIdentificador());
            }
        }
    }
    public void venderProductos(List<String> identificadores, List<Integer> cantidades) {
        int totalUnidadesVendidas = 0;
        if (identificadores.size() > 3) {
            System.out.println("Error no se puede vender mas de 3 productos");
            return;
        }
        boolean productoEncontrado=false;
        for (int i = 0; i < identificadores.size(); i++) {
            String identificador = identificadores.get(i);
            int cantidad = cantidades.get(i);
            if (cantidad > 12) {
                System.out.println("No se pueden vender mas de 12 unidades por producto");
                return;
            }
            for (Productos producto : listaProductos) {
                if (producto.getIdentificador().equals(identificador)) {
                    productoEncontrado = true;
                    if (!producto.isDisponibilidad()) {
                        System.out.println("Error: El producto con el identificador " + identificador + " no está disponible para la venta.");
                        return;
                    }
                    totalUnidadesVendidas += cantidad;
                    if (totalUnidadesVendidas > 12) {
                        System.out.println("No se pueden vender mas de 12 unidades por producto");
                        return;
                    } else if (producto.getCantidad() < cantidad) {
                        System.out.println("Advertencia hay productos con un stock disponible menor al solicitado");
                        saldoCaja += (producto.getPrecioUnidad() * cantidad);
                        producto.reducirCantidad(cantidad);
                        System.out.println("Producto vendido : ");
                        System.out.println(producto.getIdentificador() + " " + producto.getDescripcion() + " " + cantidad + " x " + producto.getPrecioUnidad());
                    } else {
                        saldoCaja += (producto.getPrecioUnidad() * cantidad);
                        producto.reducirCantidad(cantidad);
                        System.out.println("Producto vendido : ");
                        System.out.println(producto.getIdentificador() + " " + producto.getDescripcion() + " " + cantidad + " x " + producto.getPrecioUnidad());
                    }
                }
            }
        }
        if (!productoEncontrado){
            System.out.println("Producto no encontrado ");
        }
    }
}
