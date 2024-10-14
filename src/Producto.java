/**
 *  {@code Producto} almacena los productos del inventario
 * **/

public class Producto {

    static private final int TAMREG=80;

    int id;
    String nombre;
    double precio;
    int cantidad;

    public Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTamreg(){
        return TAMREG;
    }

    @Override
    public String toString() {
        return "Datos del Producto:   " +
                "id: " + id +
                ", nombre: '" + nombre + '\'' +
                ", precio: " + precio +
                ", cantidad: " + cantidad;
    }
}
