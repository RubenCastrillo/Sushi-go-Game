/*
* Representa la baraja del sushiGo, 94 cartas, cada una representa a una comida 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: estando la baraja desordenada, devolverá la carta situada encima del montón de cartas
 */
package com.uvigo.poyectosushigo.CORE;

import pila.*;

public class Baraja {
    
    public static final String N_CALAMAR = "Nigiri de calamar";
    public static final String N_SALMON = "Nigiri de salmón";
    public static final String N_TORTILLA = "Nigiri de tortilla";
    public static final String WASABI = "Wasabi";
    public static final String M_1_ROLLO = "Maki de 1 rollo";
    public static final String M_2_ROLLOS = "Maki de 2 rollos";
    public static final String M_3_ROLLOS = "Maki de 3 rollos";
    public static final String TEMPURA = "Tempura";
    public static final String SASHIMI = "Sashimi";
    public static final String GYOZA = "Gyoza";
    public static final String PRUEBA = "Prueba";

    Pila<Carta> baraja;
    private final int NUM_CARTAS = 999;

    public Baraja() {
        baraja = new EnlazadaPila<>();
        
        insertarCarta(N_CALAMAR, 5);
        insertarCarta(N_SALMON, 10);
        insertarCarta(N_TORTILLA, 5);
        insertarCarta(WASABI, 6);
        insertarCarta(M_1_ROLLO, 6);
        insertarCarta(M_2_ROLLOS, 12);
        insertarCarta(M_3_ROLLOS, 8);
        insertarCarta(TEMPURA, 14);
        insertarCarta(SASHIMI, 14);
        insertarCarta(GYOZA, 14);
        insertarCarta(PRUEBA, 5);
        
        barajar ();
    }

    /**
     * Método que permite insertar varias veces una misma carta en la baraja.
     * @param carta La carta a insertar.
     * @param numCartas El número de veces que se inserta la carta.
     */
    private void insertarCarta(String carta, int numCartas) {
        for (int i = 0; i < numCartas; i++) {
            baraja.push(new Carta(carta));
        }
    }

    private void barajar (){
        int aleatorio;
        Carta [] desordenadas = new Carta [NUM_CARTAS*3];
        while (!baraja.esVacio()){
            aleatorio = (int)(Math.random()* desordenadas.length-1);
            if (desordenadas [aleatorio] == null) {
                desordenadas [aleatorio] = baraja.pop();
            }else{
                while(desordenadas[aleatorio]!=null){
                    aleatorio++;
                    if(aleatorio == desordenadas.length){
                        aleatorio = 0;
                    }       
                }
                desordenadas[aleatorio] = baraja.pop();
            }
        }
        for (Carta arrayCartas: desordenadas) {
            if(arrayCartas != null){
                baraja.push(arrayCartas);
            }
        }
    }
    
    /**
     * Devuelve una carta de la baraja
     * @return Una carta de la baraja o una excepción si no hay cartas
     */
    public Carta getCarta (){
        return baraja.pop();
    }

}
