package Vista;
import Controlador.GestorAnimaciones;
import Modelo.Animacion;
import Modelo.Cuadrado;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
public class Ventana extends JFrame implements KeyListener {

    private GestorAnimaciones gest;
    private BufferStrategy myBuffer;                            //Me ayuda a pintar la pelota y la plataforma

    //Constructor     
    public Ventana(GestorAnimaciones gestor) {
        this.setSize(300, 500);                                 //Darle Tamanio
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //Se acaba el proceso cuando se cierra /*Es decir se cierra todo
        this.addKeyListener(this);                              //Agregamos el listener para que escuche las teclas
        this.gest = gestor;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.createBufferStrategy(2);
        myBuffer = this.getBufferStrategy();
        this.repaint();
    }

    public void dibujarImagen(Graphics2D g) {
        g.drawImage(gest.getPelota().getImagen(), gest.getPelota().getPosX(), gest.getPelota().getPosY(), this);

        int numPlataformas = 8;
        int numImagxPataforma = 8;
        for (int j = 0; j < numPlataformas; j++) {
            for (int i = 0; i < numImagxPataforma; i++) {
                if (gest.getPlataforma()[j] != null) {
                    Image a = gest.getPlataforma()[j].getCuadrado()[i].getImagen();
                    Animacion c = gest.getPlataforma()[j].getCuadrado()[i];
                    if (a != null) {
                        g.drawImage(a, c.getPosX(), c.getPosY(), this);
                    }
                }
            }
        }

    }

    //Este metodo lo tienen las interfaces y me ayuda a dibujar
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = null; //Me ayuda a dibujar
        if (myBuffer != null) {
            g2 = (Graphics2D) myBuffer.getDrawGraphics();
            g2.clearRect(0, 0, 800, 800);//Limpia la pantalla para que no quede rastro
            this.dibujarImagen(g2);
            myBuffer.show();
        }
    }

//Metodos Abstractos cuando se agrega la interafe KEYLISTENER
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 37) {
            //     System.out.println("izquierda");
            gest.getPelota().setPosX(gest.getPelota().getPosX() - 10);
        }
        if (e.getKeyCode() == 38) {
            //     System.out.println("arriba ");
            gest.getPelota().setPosY(gest.getPelota().getPosY() - 10);
        }
        if (e.getKeyCode() == 39) {
            gest.getPelota().setPosX(gest.getPelota().getPosX() + 10);
            //     System.out.println("derecha");
        }
        if (e.getKeyCode() == 40) {
            //        System.out.println("abajo");
            if (gest.verificar()) {
                gest.getPelota().setPosY(gest.getPelota().getPosY() + 10);
            }else{
                gest.getPelota().setPosY(gest.getPelota().getPosY() - 10);
            }
                
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    public GestorAnimaciones getGest() {
        return gest;
    }
    
    
}
