import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Barco {
    private double posX;
    private double posY;
    private double altura;
    private double ancho;
    private int size;
    private ImageIcon imagen;
    private JPanel panel;
    private boolean dragging = false;
    private Point mouseOffset;
    private boolean rotated = false;

    public Barco(int size) {
        this.size = size;
    }

    public Barco(double posX, double posY, double altura, double ancho, int size, String rutaImagen, JPanel panel) {
        this.altura = altura;
        this.ancho = ancho;
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.imagen = new ImageIcon(rutaImagen);
        this.panel = panel;

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (contains(e.getPoint())) {
                        dragging = true;
                        mouseOffset = new Point((int) (e.getX() - posX), (int) (e.getY() - posY));
                    }
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    if (contains(e.getPoint())) {
                        rotated = !rotated;
                        panel.repaint();
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
                actualizarPosicionEnTablero();
            }

        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging) {
                    double newX = e.getX() - mouseOffset.getX();
                    double newY = e.getY() - mouseOffset.getY();
                    newX = Math.round(newX / 31.09) * 31.09;
                    newY = Math.round(newY / 31.09) * 31.09;
                    if (size % 2 == 0 && rotated) {
                        newY += 16;
                        newX += 16;
                    }
                    setPosX(newX);
                    setPosY(newY);
                    panel.repaint();
                }
            }
        });

    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public boolean contains(Point p) {
        int x = (int) posX;
        int y = (int) posY;
        int width = imagen.getIconWidth();
        int height = imagen.getIconHeight();
        Rectangle bounds = new Rectangle(x, y, width, height);
        return bounds.contains(p);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        if (rotated) {
            g2d.rotate(Math.toRadians(90), posX + imagen.getIconWidth() / 2, posY + imagen.getIconHeight() / 2);
        }
        g2d.drawImage(imagen.getImage(), (int) posX, (int) posY, null);
        g2d.dispose();
    }

    private void actualizarPosicionEnTablero() {
        int x = (int) (posX / 31.09);
        int y = (int) (posY / 31.09);
        System.out.println("Posición en el tablero: [" + x + ", " + y + "]");
    }
}
