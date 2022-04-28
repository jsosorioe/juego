package Modelo;

import Controlador.MovimientoPelota;
import Vista.Ventana;

public class Pelota extends Animacion {

    private Ventana ventana;
    protected MovimientoPelota correr;

 
    public Pelota(Ventana ventana) {
        correr = new MovimientoPelota(ventana, this);
        correr.start();
        this.ventana = ventana;
    }


}
