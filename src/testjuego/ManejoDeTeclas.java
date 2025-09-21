/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testjuego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author LENOVO
 */
public class ManejoDeTeclas implements KeyListener {
    GamePanel gp;
    public boolean ArribaPressed, AbajoPressed , IzquierdaPressed , DerechaPressed , SaltarPressed;
    
    
    public ManejoDeTeclas(GamePanel gp){
        this.gp = gp;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        // TECLAS PARA TITULO
        if(gp.gameState == gp.tituloState){
            if(code == KeyEvent.VK_W){
            gp.ui.comandoNumero--;
            if(gp.ui.comandoNumero < 0){
                gp.ui.comandoNumero = 3;
            }
        }
        
          if(code == KeyEvent.VK_S){
            gp.ui.comandoNumero++;
            if(gp.ui.comandoNumero > 3){
                gp.ui.comandoNumero = 0;
            }
        }
          
        if(code == KeyEvent.VK_ENTER){
            //INICIAR JUEGO
            if(gp.ui.comandoNumero == 0){
                gp.gameState = gp.playState;
                //MUSICA CUANDO INCIAS EL JUEGO
            }
            //CONTROLES
            if(gp.ui.comandoNumero == 1){
                
            }
            //CONFIGURACION
            if(gp.ui.comandoNumero == 2){
                
            }
            // SALIR
            if(gp.ui.comandoNumero == 3){
                System.exit(0);
            }
        }
    }  
        
        // TECLAS DE JUGADOR
        
         if(gp.gameState == gp.tituloState){
            
        }
        
        if(code == KeyEvent.VK_W){
            ArribaPressed = true;
            
        }
        
          if(code == KeyEvent.VK_S){
            AbajoPressed = true;
        }
        
          
          if(code == KeyEvent.VK_A){
            IzquierdaPressed = true;
        }
          
          if(code == KeyEvent.VK_D){
              DerechaPressed = true;
        }
          if (code == KeyEvent.VK_SPACE){
              SaltarPressed = true;
          }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            ArribaPressed = false;
            
        }
        
          if(code == KeyEvent.VK_S){
            AbajoPressed = false;
        }
        
          
          if(code == KeyEvent.VK_A){
            IzquierdaPressed = false;
        }
          
          if(code == KeyEvent.VK_D){
              DerechaPressed = false;
        }
          if (code == KeyEvent.VK_SPACE){
              SaltarPressed = true;
          }
          
        
    }
    
    
}
