import java.util.Random;

public class MapaComputadora {
    private int[][] tableroM = new int[10][10];
    private Barco barco2;
    private Barco barco3;
    private Barco barco32;
    private Barco barco4;
    private Barco barco5;

    public MapaComputadora() {
        barco2 = new Barco(2);
        barco3 = new Barco(3);
        barco32 = new Barco(3);
        barco4 = new Barco(4);
        barco5 = new Barco(5);

        colocarBarco(barco2);
        colocarBarco(barco3);
        colocarBarco(barco32);
        colocarBarco(barco4);
        colocarBarco(barco5);
    }

    private void colocarBarco(Barco barco) {
        Random rand = new Random();
        boolean colocado = false;
        while (!colocado) {
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            boolean horizontal = rand.nextBoolean();
            if (horizontal && puedeColocarHorizontal(barco, x, y)) {
                colocarEnTableroHorizontal(barco, x, y);
                colocado = true;
            } else if (!horizontal && puedeColocarVertical(barco, x, y)) {
                colocarEnTableroVertical(barco, x, y);
                colocado = true;
            }
        }
    }

    private boolean puedeColocarHorizontal(Barco barco, int x, int y) {
        if (x + barco.getSize() > 10) {
            return false;
        }
        for (int i = 0; i < barco.getSize(); i++) {
            if (tableroM[x + i][y] != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean puedeColocarVertical(Barco barco, int x, int y) {
        if (y + barco.getSize() > 10) {
            return false;
        }
        for (int i = 0; i < barco.getSize(); i++) {
            if (tableroM[x][y + i] != 0) {
                return false;
            }
        }
        return true;
    }

    private void colocarEnTableroHorizontal(Barco barco, int x, int y) {
        for (int i = 0; i < barco.getSize(); i++) {
            tableroM[x + i][y] = 1;
        }
    }

    private void colocarEnTableroVertical(Barco barco, int x, int y) {
        for (int i = 0; i < barco.getSize(); i++) {
            tableroM[x][y + i] = 1;
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
/*
    public static void main(String[] args) {
        MapaComputadora mapa = new MapaComputadora();
        mapa.imprimirTablero();
    }*/
}