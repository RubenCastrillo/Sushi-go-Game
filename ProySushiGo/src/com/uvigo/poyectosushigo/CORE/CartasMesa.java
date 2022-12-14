/*
* Representa las cartas que coloca el jugador en la mesa (únicamente las suyas).
* Estructura: Se utilizarán TADs adecuados para su respresentación. En concreto:Una lista de pilas 
* Funcionalidad: colocar una carta en la mesa, calcular la toRet de las cartas de la mesa, calcular el número de rollitos, visualizar cartas de la mesa, descartar cartas de la mesa, etc
*/
package com.uvigo.poyectosushigo.CORE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lista.Lista;
import lista.ListaEnlazada;
import pila.*;

public class CartasMesa {
    
    private List <List<Carta>> mesa;
    
    public CartasMesa(){
        mesa = new ArrayList<>();
    }
    
    public void añadirCarta(Carta carta){
        boolean seguirBuscando = false;
        boolean flag = true;
        List <Carta> listaActual =  new ArrayList<>();
        List <Carta> nuevaLista = new ArrayList<>();

       Iterator <List<Carta>> it = mesa.iterator();
        
        
        
        if(!carta.getNombre().equals(Baraja.WASABI)){
            for(List<Carta> lista: mesa){
                Carta c = lista.get(lista.size());
                if(c.getNombre().equals(carta.getNombre())){
                    lista.add(carta);
                    
                    flag = algoritmoEscogerLista(c,lista);
                }
            }
//            while(!seguirBuscando && it.hasNext()){ 
//                seguirBuscando = algoritmoEscogerPila(carta, listaActual);
//                it.next();
//            }
        }
        // Crea al nueva pila con la cartas en caso de que no haya una creada ya,
        // tambien sirve para gestionar los wasabis
        if(!flag){
            nuevaLista.add(carta);
            mesa.add(nuevaLista);
        }
//        if(!seguirBuscando){
//            nuevaLista.add(carta);
//            mesa.add(nuevaLista);
//        }
    }
    
    private boolean algoritmoEscogerLista(Carta carta, List<Carta> listaActual){
        //Nota: los Wasabis no entran en este método, se controlan en "añadirCarta".
        switch (carta.getNombre()){
            case Baraja.N_CALAMAR:
            case Baraja.N_SALMON:
            case Baraja.N_TORTILLA:
                if(listaActual.get(0).equals(Baraja.WASABI)){
                    listaActual.add(carta);
                    return true;
                }
                break;
            case Baraja.M_1_ROLLO:
            case Baraja.M_2_ROLLOS:
            case Baraja.M_3_ROLLOS:
            case Baraja.TEMPURA:
            case Baraja.SASHIMI:
            case Baraja.GYOZA:
            case Baraja.PRUEBA:
                if(listaActual.get(0).getNombre().equals(carta.getNombre())){
                    listaActual.add(carta);
                    return true;
                }
                break;
                }
                
      
//                if(pilaActual.top().getNombre().equals(carta.getNombre())){
//                    pilaActual.push(carta);
//                    return true;
//                }
            return false;   
        }
        
        
    
    
    /**
     * Produce: Contabiliza la puntuación personal de una ronda
     * 
     * @return Devuelve: Puntuación de la ronda (sin contar Makis)
     */
    public int calcularPuntuacionSinMakis(){
        int toRet=0;
        int contTempuras=0;
        int contSashimis=0;
        int contGyozas=0;
        int contPruebas = 0;
        
        for(List<Carta> pilaActual: mesa){
            switch(pilaActual.get(0).getNombre()){
                case Baraja.N_CALAMAR:
                    if(pilaActual.size()== 2){
                        //Debido el método "añadirCarta", si hay dos cartas Nigiri,
                        //tiene que haber un Wasabi debajo
                        toRet+=9;
                    }else{//No se puede dar el caso de que haya más de dos cartas Nigiri
                        toRet+=3;
                    }
                    break;
                case Baraja.N_SALMON:
                    if(pilaActual.size()== 2){
                        toRet+=6;
                    }else{
                        toRet+=2;
                    }
                    break;
                case Baraja.N_TORTILLA:
                    if(pilaActual.size()== 2){
                        toRet+=3;
                    }else{
                        toRet+=1;
                    }
                    break;
                

                    // CASOS APARTE PARA CONTAR LA CANTIDAD Y LUEGO LA PUNTUACION
                case Baraja.TEMPURA:
                    contTempuras+=pilaActual.size();
                    break;
                case Baraja.SASHIMI:
                    contSashimis+=pilaActual.size();
                    break;
                case Baraja.GYOZA:
                    contGyozas+=pilaActual.size();
                    break;
                default:
                }
        }
        toRet += ((int)contTempuras/2)*5;
        toRet += ((int)contSashimis/3)*10;
        
        // CASO DE LAS GYOZAS
        switch(contGyozas){
            case 0:
                break;
            case 1:
                toRet = toRet+1;
                break;
            case 2:
                toRet+=3;
                break;
            case 3:
                toRet+=6;
                break;
            case 4:
                toRet+=10;
                break;
            default:
                toRet+=15;
        }
        return toRet;
    }
    
    public int contarMakis(){
        int contMakis=0;
        for(List <Carta> pilaActual: mesa){
            switch(pilaActual.get(0).getNombre()){
                case Baraja.M_3_ROLLOS:
                    contMakis+= 3*pilaActual.size();
                    break;
                case Baraja.M_2_ROLLOS:
                    contMakis+=2*pilaActual.size();
                    break;
                case Baraja.M_1_ROLLO:
                    contMakis+=pilaActual.size();
                    break;
                default:
                }
        }
        return contMakis;
    }

    @Override
    public String toString() {
        StringBuilder toRet = new StringBuilder();
        List <Carta> aux = new ArrayList <>();
        Carta carta = null;
        for(List <Carta> pilaActual: mesa){
            toRet.append("\n");
            for (int i = 0; i < aux.size(); i++) {
                carta = aux.remove(i);
                pilaActual.add(carta);
            }
//            while(!pilaActual.isEmpty()){
//                aux.push(pilaActual.re());
//            }

            for (int i = 0; i < aux.size(); i++) {
                carta = aux.remove(i);
            }
//            while(!aux.isEmpty()){
//                carta = aux.re();
                

                toRet.append("[").append(carta.getNombre()).append("]");
            }
        return toRet.toString();
        }

}