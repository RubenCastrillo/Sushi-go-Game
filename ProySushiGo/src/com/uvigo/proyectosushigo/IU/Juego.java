/**
 * Representa el juego del sushiGo, con sus reglas. 
 * Se recomienda una implementación modular.
 */
package com.uvigo.proyectosushigo.IU;

import com.uvigo.poyectosushigo.CORE.Baraja;
import com.uvigo.poyectosushigo.CORE.Carta;
import com.uvigo.poyectosushigo.CORE.CartasMesa;
import com.uvigo.poyectosushigo.CORE.Jugador;
import com.uvigo.poyectosushigo.CORE.Mano;


public class Juego {
    
    private static boolean ordenTurnosAleatorio = true;

    public static void inicio (){
        int op = 0;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
" ____ _____ ______ _   ___      ________ _   _ _____ _____   ____   _____                 _____ _    _  _____ _    _ _____    _____  ____  \n" +
"|  _ \\_   _|  ____| \\ | \\ \\    / /  ____| \\ | |_   _|  __ \\ / __ \\ / ____|      /\\       / ____| |  | |/ ____| |  | |_   _|  / ____|/ __ \\ \n" +
"| |_) || | | |__  |  \\| |\\ \\  / /| |__  |  \\| | | | | |  | | |  | | (___       /  \\     | (___ | |  | | (___ | |__| | | |   | |  __| |  | |\n" +
"|  _ < | | |  __| | . ` | \\ \\/ / |  __| | . ` | | | | |  | | |  | |\\___ \\     / /\\ \\     \\___ \\| |  | |\\___ \\|  __  | | |   | | |_ | |  | |\n" +
"| |_) || |_| |____| |\\  |  \\  /  | |____| |\\  |_| |_| |__| | |__| |____) |   / ____ \\    ____) | |__| |____) | |  | |_| |_  | |__| | |__| |\n" +
"|____/_____|______|_| \\_|   \\/   |______|_| \\_|_____|_____/ \\____/|_____/   /_/    \\_\\  |_____/ \\____/|_____/|_|  |_|_____|  \\_____|\\____/ ");
            do {
                
                try {

                    System.out.println(
                "\n..................................................."
                            + "\n(1). Iniciar juego"
                            + "\n(2). Configuración"
                            + "\n(3). Información sobre el juego"
                            + "\n(4). Ayuda (¿como puedo jugar?)"
                            + "\n(0). Cerrar juego");

                    op = ES.leerEntero("Introduce una opción: ");

                    switch (op) {
                        case 0:
                            System.out.println("¡Hasta la próxima partida!");
                            break;
                        case 1:
                            iniciarJuego();
                            break;
                        case 2:
                            configuracion();
                            break;
                        case 3:
                            System.out.println("Sushi Go! es un juego de cartas creado por Phil Walker-Harding en el año 2013. En este juego, el \n" +
"jugador asume el rol de un comensal en un restaurante de sushi que intenta coger las mejores \n" +
"combinaciones de platos según pasan por delante, de modo que el jugador que coja los mejores \n" +
"platos será el ganador. Cada plato puntuará de forma distinta, e incluso algunos pueden ser \n" +
"combinados para dar más puntos.\n\n" +
"En Sushi Go! cada carta representa a un plato distinto y en cada turno cada jugador escogerá una \n" +
"carta para quedarse con ella, representando que ha cogido un plato. Además, este juego se basa en la \n" +
"mecánica card-drafting que consiste en que, al final de cada turno, los jugadores le darán su mano \n" +
"de cartas a otro jugador (esto es, las cartas rotan de mano)."
    + "\n\n\t(Información extraída del manual de 'Proyecto de Algoritmos y Estructuras de datos I')");
                            break;
                        case 4:
                            informacion();
                            break;
                        default:
                            System.out.println("¡Oh no! No es correcta la opción"
                                    + " ( " + op + " ) Inténtalo de nuevo ;)");
                    }
                } catch (Exception exc) {
                    System.err.println("¡Oh no! Ha ocurrido un error: " + 
                            exc.getMessage());
                }

            } while (op != 0);
    }
    
    
    private static void informacion(){
        int op = 0;
    
        do{
            try{
            System.out.println("\nAyuda (¿cómo puedo jugar?)\n" 
                +"\n(1). Como jugar"
                +"\n(2). Cartas"
                +"\n(0). Salir"); 
            op = ES.leerEntero("Introduce una opción: ");

                switch(op){

                    case 0:{
                        break;
                    }
                    case 1:{
                        System.out.println("¿No sabes como jugar?, ¡TE CONTAREMOS COMO!:\n"
                                + "\n El juego consta de 3 rondas. "
                                + "En cada ronda cada jugador recibirá un número de cartas determinado, dependiendo del número de jugadores:"
                                + "\n\t 2 jugadores: 9 cartas a cada jugador"
                                + "\n\t 3 jugadores: 8 cartas a cada jugador"
                                + "\n\t 4 jugadores: 7 cartas a cada jugador"
                                + "\n\t 5 jugadores: 6 cartas a cada jugador\n"
                                + "\n Repartidas las cartas la primera ronda comienza:"
                                + "\n Por orden, los jugadores deberán escoger de su mano una carta que entregarán automáticamente a la mesa. La colocación de las cartas en la mesa es la siguiente:"
                                + "\n\t Los Nigiris se apilarán o de forma individual o encima de un  Wasabi."
                                + "\n\t Los Wasabis solos no tendrán sentido."
                                + "\n\t Los Makis se apilarán juntos."
                                + "\n\t Las Tempuras se apilarán juntas."
                                + "\n\t Los Sashimis se apilarán juntos."
                                + "\n\t Los Gyozas se apilarán juntos."
                                + "\n(La puntuación de cada carta se adjunta en el apartado 'Cartas').\n"
                                + "\n Cuando todos los jugadores finalicen su turno, los jugadores se rotarán las cartas de su mano."
                                + "\n Puestas todas las cartas de las manos sobre la mesa se procederá a su recuento y comenzaremos la siguiente ronda de la misma forma."
                                + "\n Acabadas todas las rondas el jugador con la mayor suma de puntos obtendrá el ¡TÍTULO DE MEJOR CHEF DE COMIDA ORIENTAL!, bueno...,\n tal vez en la siguiente partida.\n"
                                + "-----------------------------------------------------------------\n");
                                
                        break;
                    }
                    case 2:{
                        int opc;
                        System.out.println("Las cartas de este juego están basadas en platos populares japoneses.\nCada tipo de carta puntuará de diferente manera:");
                        do{
                            System.out.println(
                                 "\n\t(1). Nigiris"
                                +"\n\t(2). Wasabi"
                                +"\n\t(3). Maki"
                                +"\n\t(4). Tempura"
                                +"\n\t(5). Sashimi"
                                +"\n\t(6). Gyoza"
                                +"\n\t(0). Atrás");
                            opc = ES.leerEntero("Introduce una opción: ");
                            menuCartas(opc);
                        }while(opc!=0);
                        break;
                    }
                    default:{
                        System.err.println("¡Oh no! No es correcta la opción"
                                            + " ( " + op + " ) Inténtalo de nuevo ;)");
                    }

                }
            }catch (Exception exc) {
                    System.err.println("¡Oh no! Ha ocurrido un error: " + 
                            exc.getMessage());
                }
        }while (op !=0);
            
    
    }
    
    private static void menuCartas(int opc){
    
        switch(opc){
        
            case 1:{
                System.out.println("\t\tNIGIRIS:"
                    + "\n\tEl juego consta de 3 tipos de nigiris:"
                    + "\n\t Nigiri de calamar: vale 3 puntos"
                    + "\n\t Nigiri de salmón: vale 2 puntos"
                    + "\n\t Nigiri de tortilla: vale 1 punto"
                    + "\n\t(Información extraída del manual de 'Proyecto de Algoritmos y Estructuras de datos I')\n");
                break;
            }
            case 2:{
                System.out.println("\t\tWASABI:"
                    + "\n\tSi hay una carta de Wasabi sobre la mesa cuando se coge un Nigiri, la carta de\n\t" +
                        "Nigiri puede colocarse sobre el Wasabi triplicando su valor (p.ej. si se coloca un Nigiri de Salmón\n\t" +
                        "sobre un Wasabi, valdrá 6 puntos en lugar de 2). Tan solo se puede colocar un Nigiri sobre un\n\t" +
                        "Wasabi y un Wasabi por sí solo no vale ningún punto."
                    +"\n\t(Información extraída del manual de 'Proyecto de Algoritmos y Estructuras de datos I')\n");   
                break;
            }
            case 3:{
                System.out.println("\t\tMAKI:"
                        + "\n\tEn cada carta de Maki puede aparecer 1, 2 o 3 rollitos. El jugador con más rollitos al\n\t" +
                            "final de la ronda ganará 6 puntos. Es necesario tener al menos un rollito para puntuar.\n\t" +
                            "Si dos o más jugadores empatan en el mayor número de rollitos, los 6 puntos se dividen entre ellos,\n\t" +
                            "redondeando hacia abajo."
                        + "\n\t(Información extraída del manual de 'Proyecto de Algoritmos y Estructuras de datos I')\n");  
                break;
            }
            case 4:{
                System.out.println("\t\tTEMPURA:"
                        + "\n\tCada pareja de Tempuras vale 5 puntos. Una Tempura sola no vale ningún punto."
                        + "\n\t(Información extraída del manual de 'Proyecto de Algoritmos y Estructuras de datos I')\n"); 
                break;
            }
            case 5:{
                System.out.println("\t\tSASHIMI:"
                        + "\n\tCada trío de Sashimis vale 10 puntos. Uno o dos Sashimis solos no valen ningún\n\t" +
                            "punto."
                        + "\n\t(Información extraída del manual de 'Proyecto de Algoritmos y Estructuras de datos I')\n"); 
                break;
            }
            case 6:{
                System.out.println("\t\tGYOZA:"
                        + "\n\tCuantas más Gyoza más puntos valdrán. El valor de las Gyoza, dependiendo del\n\t" +
                            "número de cartas de Gyoza que hayamos cogido, será el siguiente:"
                        + "\n\t\t Un Gyoza(1 punto)"
                        + "\n\t\t Dos Gyozas (3 puntos)"
                        + "\n\t\t Tres Gyozas (6 puntos)"
                        + "\n\t\t Cuatro Gyozas (10 puntos)"
                        + "\n\t\t Cinco Gyozas o más (15 puntos)"
                        + "\n\t(Información extraída del manual de 'Proyecto de Algoritmos y Estructuras de datos I')\n"); 
                break;
            }
            case 0:{
                break;
            }
            default:{
                System.err.println("¡Oh no! No es correcta la opción"
                                    + " ( " + opc + " ) Inténtalo de nuevo (º0^)");
            }
        
        }
    
    }
    
    private static void configuracion(){
        int opcionMenu;
        int opcion;
        do{
            System.out.println("\nMenú de configuración: "
                + "\n(1). Orden de jugadores aleatorio"
                + "\n(0). Salir");
            opcionMenu = ES.leerEntero("Introduce una opción: ");
            switch(opcionMenu){
                case 1:
                    do{
                    System.out.println("¿Quieres " + ((ordenTurnosAleatorio)?"desactivar":"activar")
                            + " el orden de jugadores aleatorio?\nEsta función"
                            + " permite que el orden el orden de los turnos de "
                            + "las rondas roten de forma aleatoria en cada ronda"
                            + " (esto no altera el número de rondas de los jugadores)"
                                + "\n\t(1). " + ((ordenTurnosAleatorio)?"Desactivar":"Activar")
                                + "\n\t(0). Cancelar");
                    opcion = ES.leerEntero("Introduce una opción: ");
                    }while(opcion < 0 || opcion > 1);
                    //Si se introduce 1 se invierte el valor del boolean
                    if(opcion ==1){
                        ordenTurnosAleatorio = !ordenTurnosAleatorio;
                        System.out.println("\nSe ha " + ((ordenTurnosAleatorio)?"activado":"desactivado") + " correctamente");
                    }
                    break;
                case 0:
                default:
                    System.out.println("Saliendo al menú principal...");
            }
        }while(opcionMenu != 0);
        
    }
    
    private static void iniciarJuego(){
        String aux;
        int numJugadores;
        Jugador [] jugadores;
        Baraja baraja = new Baraja();
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - "
                + "- -\nVamos a comenzar!!");
        System.out.println("Primero de todo... ¿Cuantos vais a jugar?");
        do{
            numJugadores = ES.leerEntero("Introduce el número de jugadores: ");
            if(numJugadores<2 || numJugadores>5){
                System.err.println("Recuerda que este juego es de 2 a 5 jugadores.");
            }
        }while(numJugadores<2 || numJugadores>5);
        jugadores = new Jugador [numJugadores];
        for(int i=0; i<jugadores.length; i++){
            aux = ES.leerCadena("Introduce el nombre del jugador " + (i+1) + ": ", false);
            jugadores[i] = new Jugador(aux);
        }
        System.out.println("\nRecordad que el juego consta de " + Main.RONDAS + " rondas");
        System.out.println("¡Pues vamos a comenzar el juego entonces!");
        for (int i = 1; i <= Main.RONDAS; i++) {
            try{
                System.out.println("- - - - - - - - - - - - - - - - - - - - - -"
                        + " - - - - - -\nRONDA" + i + ":\n");
                jugarRonda(jugadores, baraja, i);
            }catch(Exception exc){
                System.err.println("¡Oh no! Se ha producido un error de los gordos."
                        + " Hemos tenido que finalizar la ronda.\nVamos a jugar "
                        + "esta ronda de nuevo.\n\tPor si te interesa buscar el "
                        + "origen del error: " + exc.getMessage());
                i--;
                baraja = new Baraja(); //Para evitar quedarnos sin cartas
            }
        }
        ES.leerCadena("\n¡Oh!, el juego se ha acabado, pulsa enter para volver "
                + "al menú principal (y para jugar otra partida ^-^): ", true);
    }
    
    private static Mano crearMano(Mano mano, Baraja baraja, int numJugadores){
        int numCartas;
        switch(numJugadores){
            case 2:
                numCartas = 9;
                break;
            case 3:
                numCartas = 8;
                break;
            case 4:
                numCartas = 7;
                break;
            case 5:
                numCartas = 6;
                break;
            default:
                System.err.println("Error con el número de jugadores: " + numJugadores
                        + "\nSe reparte por defecto 5 cartas a cada uno");
                numCartas = 5;
        }
        for (int i = 0; i < numCartas; i++) {
            mano.añadirCarta(baraja.getCarta());
        }
        return mano;
    }
    
    private static void desordenarJugadores(Jugador[] jugadores){
        Jugador [] jugadoresDesordenados = new Jugador[jugadores.length*5];
        int aleatorio;
        int cont = 0;
        for(Jugador jug:jugadores){
            aleatorio = (int)(Math.random()* jugadoresDesordenados.length);
            if (jugadoresDesordenados [aleatorio] == null) {
                jugadoresDesordenados [aleatorio] = jug;
            }
            else{
                while(jugadoresDesordenados[aleatorio]!=null){
                    aleatorio++;
                    if(aleatorio == jugadoresDesordenados.length){
                        aleatorio = 0;
                    }  
                }
                jugadoresDesordenados [aleatorio] = jug;
            }
        }
        for(Jugador jug:jugadoresDesordenados){
           if( jug!=null ){
               jugadores[cont]=jug;
               cont++;
           }
        }
    }
    
    private static void jugarRonda(Jugador[] jugadores, Baraja baraja, int numRonda){
        Mano manoAux;
        int opcion;
        
        int [] contMakis;
        int maxMakis;
        int numJugadoresMaxMakis;
        
        for (Jugador jugador : jugadores) {
            crearMano(jugador.getMano(), baraja, jugadores.length);
        }
        if (ordenTurnosAleatorio){
            desordenarJugadores(jugadores);
        }
        while(jugadores[0].getNumCartasMano() > 0){
            for(Jugador i:jugadores){
                ES.leerCadena(i.getNombre() + ", pulsa enter para jugar tu turno: ", true);
                //Mostrar datos por pantalla
                ES.mostrarTurnoJugador(jugadores, i);
                //Escoger una carta de la mano y meterla en CartasMesa
                opcion = ES.leerCartaMano(i);               
                i.añadirCartaMesa(i.eliminarCartaMano(opcion));
                ES.mostrarFinTurnoJugador(i, i==jugadores[jugadores.length-1]);

            }
            //Rotar las manos de cartas
            manoAux = jugadores[0].getMano();
            for (int i = 0; i < jugadores.length-1; i++) {
                jugadores[i].setMano(jugadores[i+1].getMano());
            }
            jugadores[jugadores.length-1].setMano(manoAux);
        }
        
        contMakis = new int[jugadores.length];
        maxMakis=0;
        numJugadoresMaxMakis=0;
        //Ya no quedan cartas se finaliza la ronda y contamos los puntos
        for(int i=0; i<jugadores.length; i++){
            jugadores[i].setPuntuacionRonda(numRonda, jugadores[i].getPuntuacion());
            contMakis[i] = jugadores[i].getMakis();
            if(maxMakis<contMakis[i]){
                maxMakis = contMakis[i];
            }
        }
        for (int i = 0; i < contMakis.length; i++) {
            if(contMakis[i]==maxMakis){
                numJugadoresMaxMakis++;
            }
        }
        //Modificar puntuación con los Makis y borrar las cartas de la mesa de cada jugador
        for(int i=0; i<jugadores.length; i++){
            jugadores[i].setCartasMesa(new CartasMesa());//Borrar las cartas de la mesa
            if(numJugadoresMaxMakis!=0 && contMakis[i]==maxMakis){
                jugadores[i].setPuntuacionRonda(numRonda, (jugadores[i].getPuntuacionRonda(numRonda) + 6/numJugadoresMaxMakis));
            }
        }
        ES.mostrarFinRonda(jugadores, contMakis, numRonda);
    }
}