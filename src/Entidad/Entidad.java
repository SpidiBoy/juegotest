/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.awt.image.BufferedImage;

/**
 *
 * @author LENOVO
 */
public class Entidad {
public double x, y;
public int velocidad;
    
public BufferedImage arriba1, arriba2;
public BufferedImage abajo1, abajo2;
public BufferedImage izquierda1, izquierda2;
public BufferedImage derecha1, derecha2;
public BufferedImage arribaIzquierda1, arribaIzquierda2;
public BufferedImage arribaDerecha1, arribaDerecha2;
public BufferedImage abajoIzquierda1, abajoIzquierda2;
public BufferedImage abajoDerecha1, abajoDerecha2;
public BufferedImage salto1 , salto2;

public enum Direccion {
    ARRIBA, ABAJO, IZQUIERDA, DERECHA,
    ARRIBA_IZQUIERDA, ARRIBA_DERECHA,
    ABAJO_IZQUIERDA, ABAJO_DERECHA,SALTO
}
 
public Direccion direccion;
    
public int spriteCounter = 0;
public int spriteNum = 1;
    
}
