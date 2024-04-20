import javax.swing.*;
import java.awt.*;

public class Jugador {
    private Barco[] barcos;

    public Jugador() {
        this.barcos = new Barco[5];
    }

    public void crearBarcos(JPanel panel, String[] rutasImagenes, int[] posicionesX, int[] posicionesY) {
        /*for (int i = 0; i < 5; i++) {
            Barco barco = new Barco(posicionesX[i], posicionesY[i], 50, 100, 5, rutasImagenes[i], panel);
            barcos[i] = barco;
        }*/

        Barco barco = new Barco(posicionesX[0], posicionesY[0], 50, 100, 2, rutasImagenes[0], panel);
        barcos[0] = barco;

        Barco barco1 = new Barco(posicionesX[1], posicionesY[1], 50, 100, 3, rutasImagenes[1], panel);
        barcos[1] = barco1;

        Barco barco2 = new Barco(posicionesX[2], posicionesY[2], 50, 100, 3, rutasImagenes[2], panel);
        barcos[2] = barco2;

        Barco barco3 = new Barco(posicionesX[3], posicionesY[3], 50, 100, 4, rutasImagenes[3], panel);
        barcos[3] = barco3;

        Barco barco4 = new Barco(posicionesX[4], posicionesY[4], 50, 100, 5, rutasImagenes[4], panel);
        barcos[4] = barco4;

    }

    public Barco[] getBarcos() {
        return barcos;
    }

    public void setBarcos(Barco[] barcos) {
        this.barcos = barcos;
    }
}
