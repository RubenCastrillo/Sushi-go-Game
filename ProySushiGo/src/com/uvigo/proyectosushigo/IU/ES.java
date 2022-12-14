/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uvigo.proyectosushigo.IU;

import com.uvigo.poyectosushigo.CORE.Jugador;
import java.util.Scanner;


public class ES
{
    //En los métodos de escritura de datos por pantalla usamos StringBuilder para ahorrar recursos
    
    public static void mostrarCartasMano(Jugador jugador){
        StringBuilder mostrar = new StringBuilder();
        mostrar.append("\n").append(jugador.toStringMano()).append("\n");
        System.out.println(mostrar.toString());
    }
    
    public static void mostrarCartasMesa(Jugador jugador){
        StringBuilder mostrar = new StringBuilder();
        mostrar.append(jugador.toStringCartasMesa());
        System.out.println(mostrar.toString());
    }
    
    public static void mostrarTurnoJugador(Jugador[] jugadores, Jugador jugador){
        StringBuilder mostrar = new StringBuilder();
        mostrar.append("\n\n- - - - - - - - - - - - - - - - - - - - - - - - - -\nTURNO DE ")
                .append(jugador.getNombre().toUpperCase()).append("\n");
        
        //El número de turnos coincide con el número de cartas que le quedan
        mostrar.append(jugador.getNombre()).append(", te quedan ")
                .append(jugador.getNumCartasMano())
                .append(" turnos incluyendo este. ¡Juégalos bien!\n");
        mostrar.append("Orden de turnos:\n");
        
        for (int i = 0; i < jugadores.length; i++) {
            mostrar.append(i+1).append(". ").append(jugadores[i].getNombre());
            if(jugadores[i]==jugador){
                mostrar.append(" <-- Estamos aquí, ¡oriéntate!");
            }
            mostrar.append("\n");
        }
        //Mostrar las cartas de la mesa de los demás jugadores
        System.out.println(mostrar);
        for (Jugador i: jugadores) {
            if(i!=jugador){
                System.out.println("- - - - - - - - - - - - - - - - - - - - -"
                        + "\nCartas de la mesa de: " + i.getNombre());
                mostrarCartasMesa(i); 
            }
        }
        //Mostrar las cartas de la mesa y de la mano del jugador correspondiente
        System.out.println("- - - - - - - - - - - - - - - - - - - - -"
                + "\nTUS CARTAS DE LA MESA:");
        mostrarCartasMesa(jugador);
        System.out.println("\n\nTUS CARTAS DE LA MANO:");
        mostrarCartasMano(jugador);
    }
    
    public static void mostrarFinTurnoJugador(Jugador jugador, boolean ultimoJugador){
        StringBuilder mostrar = new StringBuilder();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        mostrarCartasMano(jugador);
        mostrarCartasMesa(jugador);
        mostrar.append("\nTus cartas quedan así al final del turno. Tu mano se le pasará al ")
                .append((ultimoJugador)?"primer":"siguiente")
                .append(" jugador en el siguiente turno");
        System.out.println(mostrar);
        leerCadena("\n\tPulsa enter para finalizar tu turno y ocultar tus cartas: ", true);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\t\tTRAMPOS@, NO SIGAS SUBIENDO"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    public static void mostrarFinRonda (Jugador [] jugadores, int [] makis, int numRonda){
        StringBuilder mostrar = new StringBuilder();
        mostrar.append("Hemos llegado al final de la ").append(numRonda)
                .append(" ronda. Las puntuaciones de esta ronda son las siguientes:\n");
        
        //Ordenar por puntuación ronda:
        ordenarJugadoresRonda(jugadores, numRonda);
        for (int i = 0; i < jugadores.length; i++) {
            mostrar.append("\n\t(").append((i+1)).append("). ")
                    .append(jugadores[i].getNombre()).append("\tPuntuación ronda: ")
                    .append(jugadores[i].getPuntuacionRonda(numRonda));
        }
        
        mostrar.append("\n\nPor tanto, el podio general se mantiene...");
        ordenarJugadoresPuntuacionTotal(jugadores);
        
        for (int i = 0; i < jugadores.length; i++) {
            mostrar.append("\n\t(").append((i+1)).append("). ")
                    .append(jugadores[i].getNombre()).append("\tPuntuación total: ")
                    .append(jugadores[i].getPuntuacionTotal());
        }
        System.out.println(mostrar);
    }
    
    //Este método se trata de una variante del algoritmo ordenación por selección.
    //(ejercicio 3 de la actividad 9 (AED_I))
    public static void ordenarJugadoresRonda (Jugador[] jugadores, int numRonda){
        int posMayor;//Posición del jugador con mayor puntuación
        for(int i = 0; i < jugadores.length; i++) {
            posMayor = i;
            for (int j = i; j < jugadores.length; j++) {
                if(jugadores[posMayor].getPuntuacionRonda(numRonda)<jugadores[j]
                        .getPuntuacionRonda(numRonda)){
                    posMayor = j;
                }
            }
            if(posMayor!=i){
                Jugador temp = jugadores[posMayor];
                jugadores[posMayor] = jugadores[i];
                jugadores[i] = temp;
            }
        }
    }
    //Este método se trata de una variante del algoritmo ordenación por selección.
    //(ejercicio 3 de la actividad 9 (AED_I))
    public static void ordenarJugadoresPuntuacionTotal(Jugador[] jugadores){
        int posMayor;//Posición del jugador con mayor puntuación total
        for(int i = 0; i < jugadores.length; i++) {
            posMayor = i;
            for (int j = i; j < jugadores.length; j++) {
                if(jugadores[posMayor].getPuntuacionTotal()<jugadores[j].getPuntuacionTotal()){
                    posMayor = j;
                }
            }
            if(posMayor!=i){
                Jugador temp = jugadores[posMayor];
                jugadores[posMayor] = jugadores[i];
                jugadores[i] = temp;
            }
        }
    }
    
    public static int leerCartaMano(Jugador jugador){
        int opcion;
        int numCartas = jugador.getNumCartasMano();
        do{
            opcion = leerEntero(jugador.getNombre() + ", selecciona una carta de tu mano: ");
            if(opcion < 1 || opcion > numCartas){
                System.err.println("Selecciona una carta válida.\nRecuerda que "
                        + "solo son válidas las cartas entre 1 y " 
                        + numCartas);
            }
        }while(opcion < 1 || opcion > numCartas);
        return --opcion;
    }
    
    
    
    

   /* -------------------------------------------------------------*/
   //  METODOS PARA LA LECTURA DE DATOS DEL TECLADO (EXTRAÍDOS DE PROII)
   /* -------------------------------------------------------------*/
    
    /**
     * Lee una cadena del teclado
     *
     * @param mensaje Literal que especifica lo que el usuario debe introducir
     * @param permiteVacia True: campo no obligatorio; False: campo obligatorio
     * @return String cadena leida del teclado
     */
    public static String leerCadena(String mensaje,
            boolean permiteVacia) {
        String leer;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(mensaje);
            leer = scanner.nextLine().trim();
            if (!permiteVacia && leer.length() == 0) {
                System.err.println("La cadena introducida no puede estar vacía. "
                        + "Por favor, introdúcela de nuevo.");
            }
        } while ((permiteVacia == false) && leer.length() == 0);

        return leer;
    }

    /**
     * Lee un número entero del teclado
     *
     * @param mensaje Literal que especifica lo que el usuario debe introducir
     * @return int Entero leido del teclado
     */
    public static int leerEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        boolean esValido = false; // True: entero leido correctamente
        int leer = 0;

        do {
            try {
                System.out.print(mensaje);
                leer = Integer.parseInt(scanner.nextLine().trim());
                esValido = true;
            } catch (NumberFormatException e) {
                System.err.println("La cadena introducida no se puede "
                        + "convertir a número entero. Por favor, "
                        + "introdúcela de nuevo.");
            }
        } while (!esValido);

        return leer;
    }
}