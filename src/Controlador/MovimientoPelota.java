package Controlador;

import Modelo.Animacion;
import Vista.Ventana;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovimientoPelota extends Thread {

    private Ventana ventana;
    private Animacion animado;

    public MovimientoPelota(Ventana ventana, Animacion elemento) {
        this.ventana = ventana;
        this.animado = elemento;
    }

    @Override
    public void run() {
        while (true) {
            animado.setImagen("./imagenes/kekis.png");
            ventana.repaint();
          //  System.out.println("pelota");
            try {
                sleep(100);
            } catch (InterruptedException ex) {
            }
        }

    }
}
