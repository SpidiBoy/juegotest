/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testjuego;

import Bloques.BloqueManager;
import Entidad.Jugador;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author LENOVO
 */
public class GamePanel extends JPanel implements Runnable{
    final int originalTituloSize = 16; // 16x16 titulo
    final int scale = 2;
    
    public final int tituloSize = originalTituloSize * scale; // 48x48 titulo
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 14;
    public final int screenWidth = tituloSize * maxScreenCol; // 768 pixeles
    public final int screenHeight = tituloSize * maxScreenRow; // 576 pixeles
    
    // FPS
    int FPS = 60;
    BloqueManager bloques = new  BloqueManager(this);
    ManejoDeTeclas  tecla = new ManejoDeTeclas(this);
    Thread gameThread;
    Jugador objjugador = new Jugador(this,tecla);
    public InterfazDeUsuario ui = new InterfazDeUsuario(this);
    
    public final int tituloState = 0;
    public int gameState; 
    public final int playState = 1;
    
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight ));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(tecla);
        this.setFocusable(true);
    }        
    
    public void setupGame(){
        gameState = tituloState;
    }
    

    public void StarGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        
        double DibujarIntervalo = 1000000000/FPS; // 0.01666 segundos
        double ProximoDibujo= System.nanoTime() + DibujarIntervalo;
        // este metodo significa: mientras exista este gameThread se repite el proceso
        while (gameThread != null){
                 
            // 1.-ACTUALIZAR (UPDATE): actualizar informacion , ejemplo la posicion del personaje
            update();
            // 2.-DIBUJO (DRAW): el dibujo en la pantalla con la información actualizada
            repaint();
                   
            try {
                double remainingTime = ProximoDibujo - System.nanoTime();
                remainingTime = remainingTime/1000000;
                
                if(remainingTime < 0 ){
                    remainingTime = 0;
                }
                
                Thread.sleep((long)remainingTime);
                
                ProximoDibujo += DibujarIntervalo;
                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
        }
    }
    
    public void update(){     
        objjugador.update();
     }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        //TITULO DE PANTALLA
        if(gameState == tituloState){
             ui.draw(g2);
        }
        else{
            
        //MAPA
        bloques.draw(g2);
        //JUGADOR
        objjugador.draw(g2);
        
        //UI
        ui.draw(g2);
        
       
        
        g2.dispose();
       
        
        }
        
       
    }
}
