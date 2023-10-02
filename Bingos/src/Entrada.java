import java.util.*;

class Entrada {
    private final List<Jugador> jugadores;
    private final List<Carton> cartones;
    private final Set<Integer> numerosSorteados;
    private boolean juegoEnCurso;

    public Entrada() {
        this.jugadores = new ArrayList<>();
        this.cartones = new ArrayList<>();
        this.numerosSorteados = new HashSet<>();
        this.juegoEnCurso = false;
    }

    public void agregarJugador(String nombre, String dni, double saldo) {
        Jugador jugador = new Jugador(nombre, dni, saldo);
        jugadores.add(jugador);
        System.out.println("Jugador " + nombre + " agregado.");
    }

    public void comprarCarton(String dni, int cantidad) {
        Jugador jugador = buscarJugadorPorDni(dni);
        if (jugador != null) {
            for (int i = 0; i < cantidad; i++) {
                Carton carton = new Carton(cartones.size() + 1);
                cartones.add(carton);
                jugador.getCartones().add(carton);
                jugador.restarSaldo(1.0);
                System.out.println("Cartón " + carton.getId() + " comprado por " + jugador.getNombre() + ".");
            }
        } else {
            System.out.println("Jugador con DNI " + dni + " no encontrado.");
        }
    }

    public void iniciarJuego() {
        if (cartones.isEmpty()) {
            System.out.println("No hay cartones comprados. Debes comprar al menos un cartón para jugar.");
            return;
        }

        System.out.println("Iniciando juego de Bingo...");
        juegoEnCurso = true;

        while (juegoEnCurso) {
            int numeroSorteado = sortearNumero();
            System.out.println("Número sorteado: " + numeroSorteado);

            for (Jugador jugador : jugadores) {
                for (Carton carton : jugador.getCartones()) {
                    if (carton.getNumeros().contains(numeroSorteado)) {
                        carton.getNumeros().remove(numeroSorteado);
                        if (carton.getNumeros().isEmpty()) {
                            System.out.println(jugador.getNombre() + " ha cantado BINGO en el cartón " + carton.getId() + "!");
                            jugador.restarSaldo(-50.0);
                            jugador.getCartones().remove(carton);
                            cartones.remove(carton);
                            if (jugador.getCartones().isEmpty()) {
                                System.out.println(jugador.getNombre() + " ha terminado el juego.");
                                jugadores.remove(jugador);
                            }
                            if (jugadores.isEmpty()) {
                                System.out.println("Fin del juego. Todos los jugadores han terminado.");
                                juegoEnCurso = false;
                            } else {
                                System.out.println("Presiona Enter para continuar");
                                new Scanner(System.in).nextLine();
                            }
                        } else if (carton.getNumeros().size() == 10) {
                            System.out.println(jugador.getNombre() + " ha cantado LÍNEA en el cartón " + carton.getId());
                            System.out.println("Presiona Enter para continuar");
                            new Scanner(System.in).nextLine();
                        }
                    }
                }
            }

        }
    }

    private int sortearNumero() {
        int numero;
        do {
            numero = new Random().nextInt(99) + 1;
        } while (numerosSorteados.contains(numero));
        numerosSorteados.add(numero);
        return numero;
    }

    private Jugador buscarJugadorPorDni(String dni) {
        for (Jugador jugador : jugadores) {
            if (jugador.getDni().equals(dni)) {
                return jugador;
            }
        }
        return null;
    }
}