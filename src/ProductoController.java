import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * {@code ProductoController} Actúa como intermediario entre la vista y el modelo
 **/
public class ProductoController {

    static final String RUTA = "datos/inventario.dat";

    public static void agregar(Producto p) {
        try (RandomAccessFile fichero = new RandomAccessFile(RUTA, "rw")) {
            int posicion = (p.getId() - 1) * p.getTamreg();
            fichero.seek(posicion);
            fichero.writeInt(p.getId());
            fichero.writeUTF(p.getNombre());
            fichero.writeDouble(p.getPrecio());
            fichero.writeInt(p.getCantidad());
        } catch (IOException e) {
            System.out.println("Error al acceder al fichero.");
        }

    }

    public static Producto buscar(int id) {
        try (RandomAccessFile fichero = new RandomAccessFile(RUTA, "rw")) {
            Producto p = new Producto();
            int posicion = (id - 1) * p.getTamreg();
            fichero.seek(posicion);
            p.setId(fichero.readInt());
            p.setNombre(fichero.readUTF());
            p.setPrecio(fichero.readDouble());
            p.setCantidad(fichero.readInt());
            return p;
        } catch (Exception e) {
            System.out.println("Error al acceder al fichero");
            return null;
        }
    }

    public static void borrar(Producto p) {
        try (RandomAccessFile fichero = new RandomAccessFile(RUTA, "rw")) {
            int posicion = (p.getId() - 1) * p.getTamreg();
            fichero.seek(posicion);
            fichero.writeInt(-1);
            fichero.writeUTF("");
            fichero.writeDouble(0);
            fichero.writeInt(0);
        } catch (IOException e) {
            System.out.println("Error al acceder al fichero.");
        }

    }

    public static void actualizarPrecio(Producto p, double precio) {
        try (RandomAccessFile fichero = new RandomAccessFile(RUTA, "rw")) {
            int posicion = (p.getId() - 1) * p.getTamreg();
            fichero.seek(posicion);
            fichero.writeInt(p.getId());
            fichero.writeUTF(p.getNombre());
            fichero.writeDouble(precio);
            fichero.writeInt(p.getCantidad());
        } catch (IOException e) {
            System.out.println("Error al acceder al fichero.");
        }
    }

    public static Producto[] lista() {
        ArrayList<Producto> productos = new ArrayList<>();
        try (RandomAccessFile fichero = new RandomAccessFile(RUTA, "rw")) {


                while (fichero.getFilePointer() < fichero.length()) {
                    if (fichero.getFilePointer() + 4 > fichero.length()) break;
                    int id = fichero.readInt();
                    if (fichero.getFilePointer() + 2 > fichero.length()) break;
                    String nombre = fichero.readUTF();
                    if (fichero.getFilePointer() + 8 > fichero.length()) break;
                    double precio = fichero.readDouble();
                    if (fichero.getFilePointer() + 4 > fichero.length()) break;
                    int cantidad = fichero.readInt();
                    productos.add(new Producto(id, nombre, precio, cantidad));

                }
                } catch (Exception e) {
            System.out.println("Error al listar los productos.");
            e.printStackTrace();
        }
        return productos.toArray(new Producto[0]);
    }

}
