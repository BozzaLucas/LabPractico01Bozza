package validadores;
import productos.Productos;

//clases para validar cargas
public class Validacion {
   //validacion de 5 caracteres alfanumericos
    public static void validarIdentificador(String identificador, int longitud ) {
       if (identificador.length() > longitud) {
           throw new IllegalArgumentException("El identificador no puede ser mayor que " + longitud);
       }
    }
    public static void stockProducto(boolean disponibilidad){
        if (disponibilidad==false) {
            System.out.println("el producto no se encuentra disponible");
        } else {
            System.out.println("el producto se encuentra disponible");
        }
    }
    public static void prodEsImportado(boolean prodImportado){
        if (prodImportado==false) {
            System.out.println("el producto no es importado");
        } else {
            System.out.println("el producto es importado");
        }
    }
}
