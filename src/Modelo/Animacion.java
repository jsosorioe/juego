package Modelo;

import Controlador.MovimientoPelota;
import Vista.Ventana;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Animacion {

    private int posX;
    private int posY;
    private Image imagen;
    

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(String dir_img_anima) {
        try {
            if (dir_img_anima != null) {
                imagen = ImageIO.read(new File(dir_img_anima));
            }
        } catch (IOException ex) {
        }
    }

    public void getPosX(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
