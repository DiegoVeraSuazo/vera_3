import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayListAtomico {


    public static void main(String[] args) {


        System.out.println("\nBienvenido a textiles Raptor, ¿Cual va a ser su pedido de polera?");
        ArrayList pedidos = new ArrayList();
        String inicializacion = "Tipo,Talla,Estampado";
        pedidos.add(inicializacion);
        menu(pedidos);

    }


    /**
     *Metodo que muestra los pedidos ingresados.
     * @param ArrayList con todos los pedidos.
     * @return Texto que posee los pedidos con su respectiva informacion.
     */
    private static void mostrarPedidos(ArrayList pedidos) {
        System.out.println("\nEstos son los pedidos actuales:");
        for (int i = 0; i < pedidos.size() ; i++) {
            System.out.println("============================");
            System.out.println(pedidos.get(i));
        }
    }

    /**
     * Metodo que crea un String llamado polera que se usara.
     * para ingresarlo el ArrayList de Pedidos.
     * @param Ingresa con el ArrayList de pedidos para llamar a mas metodos.
     * @return Regresa el ArrayList de pedidos pero con la informacion de la polera
     */
    public static ArrayList creacionPedidos(ArrayList pedidos){
        String polera = elaboracionPolera();
        pedidos.add(polera);
        return pedidos;
    }


    /**
     * Metodo que elabora la polera
     * @return String con toda la informacion de la polera.
     */
    private static String elaboracionPolera() {
        ArrayList<String> tipo = new ArrayList<>();
        ArrayList<String> talla = new ArrayList<>();
        talla.add("S");
        talla.add("M");
        talla.add("L");
        talla.add("XL");
        tipo.add("Algodon");
        tipo.add("Polyester");
        tipo.add("Spandex");

        return eleccionTipo(tipo)+","+eleccionTalla(talla)+","+eleccionEstampado();
    }

    /**
     * Metodo que escoge si va a tener estampado la polera o no
     * @return Retorna un String de Si o No para la informacion del metodo elaboracionPolera
     */
    private static String eleccionEstampado() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Quiere que la polera tenga estampado(Si/No escriba su respuesta)");
        Boolean bandera;
        String respuesta;
        do {
            respuesta = teclado.nextLine();

            if (respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("no")) {
                bandera = false;
            } else {
                System.out.println("Escriba (Si) o (No) ");
                bandera = true;
            }

        } while (bandera);
        return respuesta;
    }

    /**
     * Metodo que sortea a traves de eleccion del usuario la talla de la polera
     * @param Ingresa con un ArrayList llamado talla para ver si lo que ingreso el usuario es correcto
     * @return Retorna un String que es llamado en elaboracionPolera
     */
    private static String eleccionTalla(ArrayList<String> talla) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escriba la talla, o escoja el numero de la opcion:");
        Boolean bandera1;
        String tallaEscrita;
        do {
            for (int i = 0; i < talla.size(); i++) {
                System.out.println((i+1)+"°"+talla.get(i));
            }
            tallaEscrita = teclado.nextLine();

            if (tallaEscrita.equals("1")){tallaEscrita="S";}
            if (tallaEscrita.equals("2")){tallaEscrita="M";}
            if (tallaEscrita.equals("3")){tallaEscrita="L";}
            if (tallaEscrita.equals("4")){tallaEscrita="XL";}

            if (talla.contains(tallaEscrita)) {
                bandera1 = false;
            } else {
                bandera1 = true;
            }
        } while (bandera1);
        return tallaEscrita;
    }

    /**
     * etodo que sortea a traves de eleccion del usuario el tipo de polera
     * @param Ingresa con un ArrayList llamado tipo para ver si lo que ingreso el usuario es correcto
     * @return Retorna un String que es llamado en elaboracionPolera
     */
    private static String eleccionTipo(ArrayList<String> tipo) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escriba el tipo, o escoja el numero de la opcion:");
        Boolean bandera1;
        String tipoElegido;
        do {
            for (int i = 0; i < tipo.size(); i++) {
                System.out.println((i+1)+"°"+tipo.get(i));
            }

            tipoElegido = teclado.nextLine();

            if (tipoElegido.equals("1")) {tipoElegido = "Algodon";}
            if (tipoElegido.equals("2")) {tipoElegido = "Polyester";}
            if (tipoElegido.equals("3")) {tipoElegido = "Spandex";}

            if (tipo.contains(tipoElegido)) {
                bandera1 = false;
            } else {
                bandera1 = true;
            }
        } while (bandera1);
        return tipoElegido;
    }

    /**
     * Metodo que elimina pedidos
     * @param Llama al ArrayList pedidos para eliminar un pedido atraves del .remove();
     */
    private static void eliminarPedidos(ArrayList pedidos) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("De todos los pedidos cual desea eliminar");
        System.out.println(pedidos.size());
        int eleccion = validarNumero();
        if (eleccion >= 1 && eleccion < pedidos.size()){
            pedidos.remove(eleccion);
            System.out.println("Su pedido fue eliminado");
        } else {
            System.out.println("No existe tal pedido ingrese de nuevo o agregue un pedido");
        }

    }

    /**
     * Metodo que llama a un menu clasico
     * @param pedidos es ingresado para poder llamar a todos los demas metodos
     */
    public static void menu(ArrayList pedidos){
        Scanner teclado = new Scanner(System.in);
        boolean ejec = true;
        do {
            System.out.println("\nSelecciona la operacion a realizar");
            System.out.println("1 - Creacion Pedidos");
            System.out.println("2 - Muestra Pedidos");
            System.out.println("3 - Eliminar Pedidos");
            System.out.println("9 - Terminar");
            int opcion = validarNumero();
            if (opcion >= 1 && opcion <= 3 ) {
                seleccion(opcion, ejec, pedidos);

            } else if (opcion == 9) {
                ejec = false;
            } else {
                System.out.println("Opcion no valida");
            }

        } while (ejec);
    }

    /**
     * Extension del menu que usa un Switch para ir a cada metodo
     * @param opcion ingresado para saber a que caso ir
     * @param ejec usado para saber cuando esta activo
     * @param pedidos ingresado para usarlo en los demas metodos
     */
    private static void seleccion(int opcion, boolean ejec, ArrayList pedidos) {

        switch(opcion){
            case 1:
                creacionPedidos(pedidos);
                break;
            case 2:
                mostrarPedidos(pedidos);
                break;
            case 3:
                eliminarPedidos(pedidos);
                break;
            default:
                break;
        }

    }

    /**
     * Metodo que valida los numeros ingresados de letra y/o caracteres
     * @return Retorna una Variable de tipo int.
     */
    private static int validarNumero() {
        Scanner teclado = new Scanner(System.in);

        Integer entrada = 0;
        do {
            try {
                entrada = teclado.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("No ingrese letras u oraciones");
                teclado.next();
                entrada = -1;
            }
            if (entrada < 0){
                System.out.println("Opcion no valida");
            }
        } while (entrada < 0);
        return entrada;
    }

}
