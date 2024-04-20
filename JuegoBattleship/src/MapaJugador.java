import java.util.Scanner;

public class MapaJugador {
    private int[][] tableroM = new int[10][10];

    public MapaJugador() {
        inicializarTablero();
    }

    public void inicializarTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tableroM[i][j] = 0;
            }
        }
    }

    public void imprimirTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("[" + tableroM[i][j] + "]");
            }
            System.out.println();
        }
    }

    public void colocarBarco(int size) {
        Scanner scanner = new Scanner(System.in);
        boolean colocado = false;
        while (!colocado) {
            System.out.println("Ingrese la posición x (1-10) para el extremo superior izquierdo del barco:");
            int x = leerCoordenada(scanner);
            System.out.println("Ingrese la posición y (1-10) para el extremo superior izquierdo del barco:");
            int y = leerCoordenada(scanner);
            System.out.println("Ingrese la orientación del barco (0 para horizontal, 1 para vertical):");
            int orientacion = scanner.nextInt();

            if (orientacion == 0 && puedeColocarHorizontal(size, x, y)) {
                colocarEnTableroHorizontal(size, x, y);
                colocado = true;
            } else if (orientacion == 1 && puedeColocarVertical(size, x, y)) {
                colocarEnTableroVertical(size, x, y);
                colocado = true;
            } else {
                System.out.println("No se puede colocar el barco en esa posición. Intente de nuevo.");
            }
        }
    }

    private int leerCoordenada(Scanner scanner) {
        while (true) {
            int coord = scanner.nextInt();
            if (coord >= 1 && coord <= 10) {
                return coord - 1; // Restar 1 para que vaya de 0 a 9 internamente
            } else {
                System.out.println("Por favor, ingrese un número entre 1 y 10.");
            }
        }
    }

    private boolean puedeColocarHorizontal(int size, int x, int y) {
        if (y + size > 10) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (tableroM[x][y + i] != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean puedeColocarVertical(int size, int x, int y) {
        if (x + size > 10) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (tableroM[x + i][y] != 0) {
                return false;
            }
        }
        return true;
    }

    private void colocarEnTableroHorizontal(int size, int x, int y) {
        for (int i = 0; i < size; i++) {
            tableroM[x][y + i] = 1;
        }
    }

    private void colocarEnTableroVertical(int size, int x, int y) {
        for (int i = 0; i < size; i++) {
            tableroM[x + i][y] = 1;
        }
    }
/*
    public static void main(String[] args) {
        MapaJugador mapa = new MapaJugador();
        System.out.println("Mapa del Jugador:");
        mapa.imprimirTablero();
        System.out.println("Colocar barcos:");
        for (int i = 2; i <= 5; i++) {
            System.out.println("Colocar barco de tamaño " + i);
            mapa.colocarBarco(i);
            mapa.imprimirTablero();
        }
    }*/
}