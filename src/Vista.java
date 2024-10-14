import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {@code Vista} Crea la interfaz de usuario en consola
 **/

public class Vista {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Producto p = new Producto();
        int opcion;
        int id;
        double precio;

        while ((opcion = mostrarMenu()) != 0) {
            switch (opcion) {
                case 1:
                    ProductoController.agregar(recogeDatosProducto());


                    break;
                case 2:
                    Producto[] productos = ProductoController.lista();
                    for(Producto prod : productos){
                        System.out.println(p.toString());
                    }
                    break;
                case 3: // Buscar por ID
                    System.out.println("Introduce el id: ");
                    id = Integer.parseInt(teclado.nextLine());
                    System.out.println(ProductoController.buscar(id).toString());
                    break;
                case 4: // Modificar precio
                    System.out.println("Introduce el id: ");
                    id = Integer.parseInt(teclado.nextLine());
                    p = ProductoController.buscar(id);
                    System.out.println("Precio:  " + p.getPrecio());
                    System.out.println("Introduce el nuevo precio: ");
                    precio = Double.parseDouble(teclado.nextLine());
                    ProductoController.actualizarPrecio(p, precio);
                    break;

                case 5: // Eliminar produicto
                    System.out.println("Introduce el id: ");
                    id = Integer.parseInt(teclado.nextLine());
                    ProductoController.borrar(ProductoController.buscar(id));
                    break;

            }
        }


    }

    public static int mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
        String inputOpcion;
        int opcion = -1;
        while (opcion == -1) {
            System.out.println("Menú de Productos: ");
            System.out.println("1. Añadir producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto por ID");
            System.out.println("4. Modificar precio de un producto");
            System.out.println("5. Eliminar producto");
            System.out.println("0. Salir");
            System.out.println("Elige una opción: ");
            inputOpcion = teclado.nextLine();
            Pattern pattern = Pattern.compile("\\d");
            Matcher matcher = pattern.matcher(inputOpcion);
            if (matcher.matches() && Integer.parseInt(inputOpcion) < 6) {
                opcion = Integer.parseInt(inputOpcion);
                System.out.println("OPCION : " + opcion);
                return opcion;
            }
        }
        return -1;
    }

    public static Producto recogeDatosProducto() {
        Scanner teclado = new Scanner(System.in);
        int id;
        String nombre;
        int cantidad;
        double precio;

        System.out.println("Introduce el ID: ");
        id = Integer.parseInt(teclado.nextLine());
        System.out.println("Introduce el nombre: ");
        nombre = teclado.nextLine();
        System.out.println("Introduce el precio");
        precio = Double.parseDouble(teclado.nextLine());
        System.out.println("Introduce la cantidad: ");
        cantidad = Integer.parseInt(teclado.nextLine());

        return new Producto(id, nombre, precio, cantidad);
    }
}