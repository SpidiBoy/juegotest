/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bloques;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import testjuego.*;

/**
 *
 * @author LENOVO
 */
public class BloqueManager {
    GamePanel gp;
    Bloque[] bloque;
    int mapBloqueNum[][];

    public BloqueManager(GamePanel gp) {
        this.gp = gp;
        bloque = new Bloque [30];
        mapBloqueNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getBloqueImagen();
        cargarMapa("/Mapas/mapa_nivel1.txt");
    }
    
   public void getBloqueImagen(){
       
       try {
           bloque[0] = new Bloque();
           bloque[0].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/16.png"));
           
           bloque[1] = new Bloque();
           bloque[1].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/8.png"));
           
           bloque[2] = new Bloque();
           bloque[2].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/5.png"));
           
           bloque[3] = new Bloque();
           bloque[3].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/25.png"));
           
           bloque[4] = new Bloque();
           bloque[4].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/Barriles/Gas.png"));
           
           bloque[5] = new Bloque();
           bloque[5].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/33.png"));
           
           bloque[6] = new Bloque();
           bloque[6].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/18.png"));
           
           bloque[7] = new Bloque();
           bloque[7].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/26.png"));
           
           bloque[8] = new Bloque();
           bloque[8].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/34.png"));
           
           bloque[9] = new Bloque();
           bloque[9].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/35.png"));
           
           bloque[10] = new Bloque();
           bloque[10].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/27.png"));
           
           bloque[11] = new Bloque();
           bloque[11].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/31.png"));
           
           bloque[12] = new Bloque();
           bloque[12].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/39.png"));
           
           bloque[13] = new Bloque();
           bloque[13].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/36.png"));
           
           bloque[14] = new Bloque();
           bloque[14].imagen = ImageIO.read(getClass().getResourceAsStream("/imagenes/MAPA_nivel1/28.png"));
           
       }catch (IOException e){
           e.printStackTrace();
       }
        
   }
   
   public void draw(Graphics2D g2) {
       int col = 0;
       int row = 0;
       int x = 0;
       int y = 0;
       
       while(col <gp.maxScreenCol && row < gp.maxScreenRow){
           
           int bloqueNum = mapBloqueNum[col][row];
           
           g2.drawImage(bloque[bloqueNum].imagen,x, y, gp.tituloSize,gp.tituloSize,null);
           col++;
           x += gp.tituloSize;
           
           if(col == gp.maxScreenCol){
               col = 0;
               x = 0;
               row++;
               y += gp.tituloSize;
           }
       }
   }
     
   public void cargarMapa(String filePath){
       try{
           //ruta de txt mapas
           InputStream is = getClass().getResourceAsStream(filePath);
           BufferedReader br = new BufferedReader(new InputStreamReader(is));
           
           int col = 0;
           int row = 0;
           while(col < gp.maxScreenCol && row < gp.maxScreenRow){
               String line = br.readLine();
               
             while(col < gp.maxScreenCol){
                 String numbers[] = line.split(" ");
                 
                 int num = Integer.parseInt(numbers[col]);
                 
                 mapBloqueNum[col][row] = num;
                 col++; 
             }
             if(col == gp.maxScreenCol){
                 col=0;
                 row++;
             }
           }
           br.close();
           
       }catch (Exception e){
       }
   }
}
