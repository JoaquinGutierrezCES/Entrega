import java.util.*;



class Jugador {
    private final String nombre;
    private final String dni;
    private double saldo;
    private final List<Carton> cartones;

    public Jugador(String nombre, String dni, double saldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.saldo = saldo;
        this.cartones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Carton> getCartones() {
        return cartones;
    }

    public void restarSaldo(double cantidad) {
        saldo -= cantidad;
    }
}

