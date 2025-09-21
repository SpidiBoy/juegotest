/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testjuego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author LENOVO
 */
public class InterfazDeUsuario {
    GamePanel gp;
    Graphics2D g2;
    ImageIcon  imagenTitulo;
    String text;
    public int comandoNumero = 0;
    
    
    public InterfazDeUsuario(GamePanel gp) {
        this.gp = gp;
        getTituloImage();
    }
 
    public void draw(Graphics2D g2){
        this.g2 = g2;
        
        // PANTALLA INICIO TITULO
        if(gp.gameState == gp.tituloState){
            drawTituloScreen(); 
        }
        
    }
    
    public void drawTituloScreen (){
    //IMAGEN CON TITULO: 
    float y = gp.tituloSize * -0.3F;
    float x = gp.screenWidth/2 - (gp.tituloSize*5F);
    g2.drawImage(imagenTitulo.getImage(), (int) x, (int )y, gp.tituloSize * 10, gp.tituloSize * 10, null);
    
    // OPCIONES MENU:
    g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
    g2.setColor(Color.white);
    
    text = "INICIAR JUEGO";
    x = getXCentroTexto(text);
    y += gp.tituloSize*7.5F;
    g2.drawString(text,x,y);
    if(comandoNumero == 0 ){
        g2.drawString(">",x-gp.tituloSize,y);
    }
    
    text = "CONTROLES";
    x = getXCentroTexto(text);
    y += gp.tituloSize;
    g2.drawString(text,x,y);
    if(comandoNumero == 1 ){
        g2.drawString(">",x-gp.tituloSize,y);
    }
    
    text = "CONFIGURACION";
    x = getXCentroTexto(text);
    y += gp.tituloSize;
    g2.drawString(text,x,y);
      if(comandoNumero == 2 ){
        g2.drawString(">",x-gp.tituloSize,y);
    }
    
    text = "SALIR";
    x = getXCentroTexto(text);
    y += gp.tituloSize;
    g2.drawString(text,x,y);
      if(comandoNumero == 3 ){
        g2.drawString(">",x-gp.tituloSize,y);
    }

}
   public int getXCentroTexto(String text){
       int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
       int x = gp.screenWidth/2 - length/2;
       return x;
   }
   
   public void getTituloImage() {
     try {
        // Ruta
        var url = getClass().getResource("/imagenes/jugador/Titulo.gif");

        if (url != null) {
            imagenTitulo = new ImageIcon(url);
        } else {
            // Este error si el archivo no se encuentra
            System.err.println("¡ERROR! No se pudo encontrar el archivo gif en la ruta especificada");
        }
    } catch (Exception e) {
        System.err.println("¡ERROR! Ocurrio un problema al cargar el gif");
        e.printStackTrace();
    }
   }  
  
}

