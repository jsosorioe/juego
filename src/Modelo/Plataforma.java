package Modelo;

import Controlador.MovimientoCuadrado;
import Vista.Ventana;

public class Plataforma extends Animacion {

    private Ventana ventana;
    protected MovimientoCuadrado correr;
    private Cuadrado cuadrado[];
    private int num;

    public Plataforma(Ventana ventana, int cuadroQuenodibuja, int plataformaalaquepertenesco) {
        cuadrado = new Cuadrado[8];
        Cuadrado aux;
        this.num = cuadroQuenodibuja;
        for (int i = 0; i < 8; i++) {
            cuadrado[i] = new Cuadrado(ventana, i);
            cuadrado[i].setPosY(500+plataformaalaquepertenesco*90);
            cuadrado[i].setPosX(i * 42);
        }
        for (int i = 0; i < 8; i++) {
            if (i == cuadroQuenodibuja) {
                continue;
            }
            aux = cuadrado[i];
            aux.getCorrer().start();
        }
        this.ventana = ventana;
    }

    public Animacion[] getCuadrado() {
        return cuadrado;
    }
}
