import javax.swing.*;
import java.awt.*;

public class Tablero extends JFrame {

    private Jugador jugador;
    private int [][] tableroJ = new int [10][10];
    private int [][] tableroM = new int [10][10];

    public Tablero() {
        setTitle("battleship");
        setSize(700, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(160, 160, 160));
                g.fillRect(0, 0, getWidth(), getHeight());

                // Dibujar las imágenes "R.png" y "O.png"
                ImageIcon imagenO = new ImageIcon("fotosBS/O.png");
                g.drawImage(imagenO.getImage(), 0, 0, imagenO.getIconWidth(), imagenO.getIconHeight(), null);

                ImageIcon imagenR = new ImageIcon("fotosBS/R.png");
                g.drawImage(imagenR.getImage(), 341, 0, imagenR.getIconWidth(), imagenR.getIconHeight(), null);

                // Dibujar los barcos
                for (Barco barco : jugador.getBarcos()) {
                    barco.paint(g);
                }
            }
        };
        panel.setLayout(null);
        add(panel);

        // Crear un objeto Jugador
        jugador = new Jugador();

        // Generar los barcos del jugador
        String[] rutasImagenes = {"fotosBS/B-2.png", "fotosBS/B-3.1.png", "fotosBS/B-3.2.png", "fotosBS/B-4.png", "fotosBS/B-5.png"};
        //int[] posicionesX = {360, 430, 500, 570, 630};
        //int[] posicionesX = {0, 32, 64, 96, 128};
        int[] posicionesX = {32, 64, 96, 128, 160};
        int[] posicionesY = {450, 450, 450, 450, 450};
        jugador.crearBarcos(panel, rutasImagenes, posicionesX, posicionesY);
    }

    public int[] obtenerPosicionEnCuadricula(double x, double y) {
        int[] posicion = new int[2];
        // Calcular la posición en la cuadrícula
        posicion[0] = (int) Math.round(x / 31.09) - 1;
        posicion[1] = (int) Math.round(y / 31.09) - 1;
        return posicion;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tablero frame = new Tablero();
            frame.setVisible(true);
        });
    }

}
