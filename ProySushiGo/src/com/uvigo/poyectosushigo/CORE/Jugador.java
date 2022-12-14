/*
 * Representa a un jugador de la partida, identificado por el nombre 
 * Funcionalidad: escoge una carta de su mano; la colocará en su mesa; coge cartas de la baraja para la mano,
 *                entrega las cartas de su mano; coge las cartas de otra mano; calcula su puntuación por ronda;
 *                calcula su puntuación total; cuenta cuantos rollitos tiene en su mesa; ....
 */
package com.uvigo.poyectosushigo.CORE;

import com.uvigo.proyectosushigo.IU.Main;




public class Jugador {
    private final String nombre;
    private Mano mano;
    private CartasMesa cartasMesa;
    private int [] puntuacionRondas;
    private int puntuacionTotal;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        this.mano = new Mano();
        cartasMesa = new CartasMesa();
        puntuacionRondas = new int [Main.RONDAS];
        puntuacionTotal=0;
    }
    
    //- - - - - - - - - - - - - - -
    // MÉTODOS DE MANO
    //- - - - - - - - - - - - - - -
    
    public Mano getMano() {
        return mano;
    }

    public void setMano(Mano mano) {
        this.mano = mano;
    }
    
    public Carta eliminarCartaMano(int pos){
        return mano.retirarCarta(pos);
    }
    
    public void añadirCartaMano(Carta carta){
        mano.añadirCarta(carta);
    }
    
    public int getNumCartasMano(){
        return mano.getNumCartas();
    }
    
    public String toStringMano(){
        return mano.toString();
    }
    
    //- - - - - - - - - - - - - - -
    // MÉTODOS DE CARTAS MESA
    //- - - - - - - - - - - - - - -

    public void setCartasMesa(CartasMesa cartasMesa) {
        this.cartasMesa = cartasMesa;
    }
 
    public void añadirCartaMesa(Carta carta){
        cartasMesa.añadirCarta(carta);
    }
    
    public int getPuntuacion(){
        return cartasMesa.calcularPuntuacionSinMakis();
    }
    
    public int getMakis(){
        return cartasMesa.contarMakis();
    }
    
    public String toStringCartasMesa(){
        return cartasMesa.toString();
    }
    
    //- - - - - - - - - - - - - - -
    // MÉTODOS PROPIOS DE JUGADOR
    //- - - - - - - - - - - - - - -
    
    public void setPuntuacionRonda(int ronda, int puntuacion){
        puntuacionRondas[--ronda] = puntuacion;
        puntuacionTotal=0;
        for (int i: puntuacionRondas) {
            puntuacionTotal += i;
        }
    }
    
    public int getPuntuacionRonda(int ronda){
        return puntuacionRondas[--ronda];
    }
    
    public int getPuntuacionTotal(){
        return puntuacionTotal;
    }
    
    public String getNombre() {
        return nombre;
    }
}
