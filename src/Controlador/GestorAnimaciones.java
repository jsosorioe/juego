package Controlador;

import Modelo.Animacion;
import Modelo.Cuadrado;
import Modelo.Pelota;
import Modelo.Plataforma;
import Vista.Ventana;
import java.util.Random;

public class GestorAnimaciones {

    private Ventana ventana;
    private Animacion pelota;
    private Plataforma plataforma[];

    public GestorAnimaciones() {
        ventana = new Ventana(this); //This quiere decir enviele este gestor 
        crearAnimaciones();
    }

    private void crearAnimaciones() {
        //Para la pelota
        pelota = new Pelota(ventana);
        pelota.setPosY(120);
        pelota.setPosX(120);
        //Para la plataforma
        int numeroRandom;
        plataforma = new Plataforma[8];
        for (int numeroPlataforma = 0; numeroPlataforma < 8; numeroPlataforma++) {
            numeroRandom = (int) (Math.random() * 7);//Genera un numero random de 0  a 7
            //numerorandom es el cuadro que no va a dibujar 
            plataforma[numeroPlataforma] = new Plataforma(ventana, numeroRandom, numeroPlataforma);

        }

    }

    public Animacion getPelota() {
        return pelota;
    }

    public Plataforma[] getPlataforma() {
        return plataforma;
    }

    public boolean verificar() {

        int tamp = plataforma.length;

        for (int i = 0; i < tamp; i++) {
            int tamc = plataforma[i].getCuadrado().length;
            for (int j = 0; j < tamc; j++) {
                //21 ancjo de los cuadros de la plataforma
                Animacion cuadroP = plataforma[i].getCuadrado()[j];
                if (cuadroP.getPosX() == pelota.getPosX() && cuadroP.getPosY() == pelota.getPosY()) {
                   // System.out.println("no se debe mover");
                    return false;
                } else if ((cuadroP.getPosX() - 21) <= pelota.getPosX() && cuadroP.getPosY() <= pelota.getPosY()) {
                    if ((cuadroP.getPosX() + 21) >= pelota.getPosX() && cuadroP.getPosY() <= pelota.getPosY()) {
                        if ((cuadroP.getPosX() + 21) >= pelota.getPosX() && (cuadroP.getPosY() + 21) >= pelota.getPosY()) {
                            if ((cuadroP.getPosX() - 21) <= pelota.getPosX() && (cuadroP.getPosY() + 21) >= pelota.getPosY()) {
                                ventana.getGest().pelota.setPosY(ventana.getGest().pelota.getPosY() - 10);
                                           
            
                               // System.out.println("no se debe mover");
                                return false;
                            }
                        }
                    }
                   // System.out.println("se puede mover");
                }
                //15 ancho de la pelota

            }
        }
        System.out.println("");
        return true;
    }

}
