import java.util.*;

public class Main {
    public static void main(String[] args) {
        Entrada entrada = new Entrada();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear jugador");
            System.out.println("2. Comprar cartón");
            System.out.println("3. Iniciar juego");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre del jugador: ");
                    String nombre = scanner.nextLine();
                    System.out.print("DNI del jugador: ");
                    String dni = scanner.nextLine();
                    System.out.print("Saldo inicial del jugador: ");
                    double saldo = scanner.nextDouble();
                    entrada.agregarJugador(nombre, dni, saldo);
                    break;
                case "2":
                    System.out.print("DNI del jugador que quiere comprar cartones: ");
                    String dniCompra = scanner.nextLine();
                    System.out.print("Cantidad de cartones a comprar: ");
                    int cantidad = scanner.nextInt();
                    entrada.comprarCarton(dniCompra, cantidad);
                    break;
                case "3":
                    entrada.iniciarJuego();
                    break;
                case "4":
                    System.out.println("Saliendo del juego. ¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}