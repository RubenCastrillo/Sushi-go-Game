/*
* Representa las cartas que tiene un jugador en la mano (las que dispone para jugar).
* Estructura: Se utilizarán TAD adecuado. 
* Funcionalidad: añadir carta a la mano, quitar carta de la mano, visualizar cartas de la mano,...
*/
package com.uvigo.poyectosushigo.CORE;
import java.util.List;
import java.util.LinkedList;

public class Mano 
{
    private List <Carta> cartas;
    
    public Mano(){
           cartas = new LinkedList <> ();
    }
    
    public int getNumCartas(){
        return cartas.size();
    }
    
    public void añadirCarta (Carta nueva){
        cartas.add(nueva);
    }
    
    public Carta retirarCarta (int pos) {
        return cartas.remove(pos);
    }
    
    @Override
    public String toString(){
        StringBuilder toRet = new StringBuilder();
        int pos=0;
        for(Carta i: cartas){
            toRet.append("\n\t(").append(++pos).append(").").append(i.getNombre());
        }
        return toRet.toString();
    }
}
