package Entidad;

import testjuego.GamePanel;
import testjuego.ManejoDeTeclas;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Jugador extends Entidad {
    GamePanel gd;
    ManejoDeTeclas tecla;

    public Jugador(GamePanel gd, ManejoDeTeclas tecla) {
        this.gd = gd;
        this.tecla = tecla;
        setDefaultValues();
        getImagenesJugador();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        velocidad = 4; 
        direccion = Direccion.ABAJO;
    }
    
     public void getImagenesJugador(){
        try{
            // SI VA
            arriba1= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/subir1.png"));
            arriba2= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/subir2.png"));
            //ELIMINAR
            arribaDerecha1= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/arriba_derecha1player.png"));
            arribaDerecha2= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/arriba_derecha2player.png"));
            // SI VA
            abajo1= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/abajo1player.png"));
            abajo2= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/abajo2player.png"));
            //ELIMINAR
            arribaIzquierda1= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/izquierda_arriba_1player.png"));
            arribaIzquierda2= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/izquierda_arriba_2player.png"));
            abajoIzquierda1= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/izquierda_abajo_1player.png"));
            abajoIzquierda2= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/izquierda_abajo_2player.png"));
            abajoDerecha1= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/derecha_abajo1player.png"));
            abajoDerecha2= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/derecha_abajo2player.png"));
            
            // SI VA
            izquierda1= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/izquierda.png"));
            izquierda2= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/izquierda2.png"));
            derecha1= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/Derecha.png"));
            derecha2= ImageIO.read(getClass().getResourceAsStream("/imagenes/jugador/Derecha2.png"));   
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
     
public void update() {
    boolean estaMoviendose = false;

    if(tecla.ArribaPressed && tecla.DerechaPressed) {
        y -= velocidad / Math.sqrt(2);
        x += velocidad / Math.sqrt(2);
        direccion = Direccion.ARRIBA_DERECHA;
        estaMoviendose = true;
    }
    else if(tecla.ArribaPressed && tecla.IzquierdaPressed) {
        y -= velocidad / Math.sqrt(2);
        x -= velocidad / Math.sqrt(2);
        direccion = Direccion.ARRIBA_IZQUIERDA;
        estaMoviendose = true;
    }
    else if(tecla.AbajoPressed && tecla.DerechaPressed) {
        y += velocidad / Math.sqrt(2);
        x += velocidad / Math.sqrt(2);
        direccion = Direccion.ABAJO_DERECHA;
        estaMoviendose = true;
    }
    else if(tecla.AbajoPressed && tecla.IzquierdaPressed) {
        y += velocidad / Math.sqrt(2);
        x -= velocidad / Math.sqrt(2);
        direccion = Direccion.ABAJO_IZQUIERDA;
        estaMoviendose = true;
    }
    else if(tecla.ArribaPressed) {
        y -= velocidad;
        direccion = Direccion.ARRIBA;
        estaMoviendose = true;
    }
    else if(tecla.AbajoPressed) {
        y += velocidad;
        direccion = Direccion.ABAJO;
        estaMoviendose = true;
    }
    else if(tecla.IzquierdaPressed) {
        x -= velocidad;
        direccion = Direccion.IZQUIERDA;
        estaMoviendose = true;
    }
    else if(tecla.DerechaPressed) {
        x += velocidad;
        direccion = Direccion.DERECHA;
        estaMoviendose = true;
    }

    // Si se mueve, animamos
    if(estaMoviendose){
        spriteCounter++;
        // EL > TAL NUEMERO -- AUMENTA LA VELOCIDAD DEL PERSONAJE
        if(spriteCounter > 6){
            if (spriteNum == 1){
                spriteNum = 2;
            }
            else{
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    } else {
        // Si no se mueve, lo dejamos en el primer frame (idle)
        spriteNum = 1;
    }
}

    public void draw(Graphics2D g2) {
        // Dibujar al jugador como un cuadrado
        //g2.setColor(Color.RED);
        //g2.fillRect((int)x, (int)y, gd.tituloSize, gd.tituloSize);
        
        BufferedImage imagen = null;
          switch(direccion){
            case ARRIBA:
                imagen = (spriteNum == 1) ? arriba1 : arriba2;
                break;
            case ABAJO:
                imagen = (spriteNum == 1) ? abajo1 : abajo2;
                break;
            case IZQUIERDA:
                imagen = (spriteNum == 1) ? izquierda1 : izquierda2;
                break;
            case DERECHA:
                imagen = (spriteNum == 1) ? derecha1 : derecha2;
                break;
            case ARRIBA_IZQUIERDA:
                imagen = (spriteNum == 1) ? arribaIzquierda1 : arribaIzquierda2;
                break;
            case ARRIBA_DERECHA:
                imagen = (spriteNum == 1) ? arribaDerecha1 : arribaDerecha2;
                break;
            case ABAJO_IZQUIERDA:
                imagen = (spriteNum == 1) ? abajoIzquierda1 : abajoIzquierda2;
                break;
            case ABAJO_DERECHA:
                imagen = (spriteNum == 1) ? abajoDerecha1 : abajoDerecha2;
                break;
        }
       g2.drawImage(imagen, (int)x,(int)y, gd.tituloSize,gd.tituloSize,null);
    }
}
