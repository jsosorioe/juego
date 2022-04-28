/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.MovimientoPelota;
import Controlador.MovimientoCuadrado;
import Vista.Ventana;

public class Cuadrado extends Animacion{
   
    private Ventana ventana;
    public MovimientoCuadrado correr;

    public Cuadrado(Ventana ventana, int num) {
        correr = new MovimientoCuadrado(ventana, this, num);
        this.ventana = ventana;
    }

    public MovimientoCuadrado getCorrer() {
        return correr;
    }
    

}
