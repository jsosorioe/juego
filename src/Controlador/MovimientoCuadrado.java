package Controlador;

import Modelo.Animacion;
import Vista.Ventana;


public class MovimientoCuadrado extends Thread {

    private Ventana ventana;
    private Animacion animado;
    private int num;
    

    public MovimientoCuadrado(Ventana ventana, Animacion elemento, int num) {
        this.ventana = ventana;
        this.animado = elemento;
        this.num =num;
    }

    @Override
    public void run() {
        while (true) {
           // animado.setImagen("./imagenes/square.png");
            //animado.getPosX(animado.getPosX()-10);
            animado.setPosY(animado.getPosY()-10);
            ventana.repaint();
            ventana.getGest().verificar();
         //   System.out.println("plataforma"+ num+ " x:"+animado.getPosX()+" y:"+animado.getPosY()+ "");
            
            try {
                sleep(80);
            } catch (InterruptedException ex) {
            }
        }
    }
    
}
