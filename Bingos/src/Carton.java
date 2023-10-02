import java.util.*;

class Carton {
    private final int id;
    private final Set<Integer> numeros;

    public Carton(int id) {
        this.id = id;
        this.numeros = new HashSet<>();
        generarNumerosUnicos();
    }

    private void generarNumerosUnicos() {
        Random random = new Random();
        while (numeros.size() < 15) {
            int numero = random.nextInt(99) + 1;
            numeros.add(numero);
        }
    }

    public int getId() {
        return id;
    }

    public Set<Integer> getNumeros() {
        return numeros;
    }
}




