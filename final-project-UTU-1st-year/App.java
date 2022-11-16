import java.util.Scanner;
import java.util.Random;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;

public class AppEnProceso {

    static Scanner sc = new Scanner(System.in);
    static Random seleccionRandom = new Random();

    public static void main(String[] args) throws IOException {
        Menu();
    }

    public static void volver() throws IOException {
        char volver;
        System.out.print("[>] ¿Deseas volver al menu principal?: (S/N): ");
        volver = sc.next().charAt(0);

        if (volver == 's' || volver == 'S') {
            Menu();
        } else if (volver == 'n' || volver == 'N') {
            System.out.println("Gracias por abir nuestro programa, hasta la proxima!");
            System.exit(0);
        } else {
            System.out.println("[>] Error, has introducido mal una opcion.");
            System.exit(0);
        }

    }

    public static void error1() {

        System.out.println("      +---+  ");
        System.out.println("      |   |  ");
        System.out.println("          |  ");
        System.out.println("          |  ");
        System.out.println("          |  ");
        System.out.println("          |  ");
        System.out.println("    =========");
    }

    public static void error2() {

        System.out.println("      +---+   ");
        System.out.println("      |   |   ");
        System.out.println("      O   |   ");
        System.out.println("          |   ");
        System.out.println("          |   ");
        System.out.println("          |   ");
        System.out.println("    ========= ");
    }

    public static void error3() {
        System.out.println("      +---+   ");
        System.out.println("      |   |   ");
        System.out.println("      O   |   ");
        System.out.println("      |   |   ");
        System.out.println("          |   ");
        System.out.println("          |   ");
        System.out.println("    ========= ");

    }

    public static void error4() {
        System.out.println("      +---+   ");
        System.out.println("      |   |   ");
        System.out.println("      O   |   ");
        System.out.println("     /|\\  |   ");
        System.out.println("          |   ");
        System.out.println("          |   ");
        System.out.println("    ========= ");
    }

    public static void error5() {
        System.out.println("      +---+   ");
        System.out.println("      |   |   ");
        System.out.println("      O   |   ");
        System.out.println("     /|\\  |   ");
        System.out.println("     / \\  |   ");
        System.out.println("          |   ");
        System.out.println("    ========= ");
        System.out.println("Usted ha perdido, intente jugar nuevamente");
    }

    public static void Menu() throws IOException {

        limpiar();

        byte caracter;
        System.out.println("#     # ####### #     # #     # ");
        System.out.println("##   ## #       ##    # #     # ");
        System.out.println("# # # # #       # #   # #     # ");
        System.out.println("#  #  # #####   #  #  # #     # ");
        System.out.println("#     # #       #   # # #     # ");
        System.out.println("#     # #       #    ## #     # ");
        System.out.println("#     # ####### #     #  #####  \n\n");
        System.out.println("¿que quiere hacer?\n");
        System.out.println("ingrese 1 si quiere jugar\n");
        System.out.println("ingrese 2 si quiere ver los creditos del programa\n");
        System.out.println("ingrese 3 si quiere ver las reglas del juego\n");
        System.out.println("ingrese 4 si quiere ver la fecha y hora actual\n");
        System.out.println("ingrese 5 si quiere ver el clima del dia de mañana\n");
        System.out.println("ingrese 6 para apagar la pc (linux)\n");
        System.out.println("ingrese 7 para apagar la pc (windows)\n");
        System.out.println("ingrese 99 para salir del programa");
        System.out.print("ingreso [>] ");
        caracter = sc.nextByte();
        if (caracter == 1) {
            int n, intentos = 0, partidas = 0;
            limpiar();
            System.out.println("\n#|#|#|#|#|¡BIENVENIDO AL JUEGO!#|#|#|#|#|\n" + "¡Recuerde leer las reglas!\n");
            System.out.print("Ingrese cuantas palabras quiere jugar [>] ");
            n = sc.nextInt();
            sc.nextLine();

            String[] palabras = new String[n];
            String opcionn;

            for (int i = 0; i < palabras.length; i++) {

                System.out.print(" Ingrese la/s nueva/s palabra/s [>] ");
                String nuevaPalabra = sc.nextLine();
                while (nuevaPalabra.equals(" ")) {
                    System.out.print(" No puede ingresar valores vacios, por favor vuelva a intentar [>]");
                    nuevaPalabra = sc.nextLine();
                }
                palabras[i] = nuevaPalabra;
            }

            String[] palabrasUsadas = new String[n];

            while (n != partidas) {
                intentos = 0;
                boolean palabraUsada = false;
                int elemento_random = seleccionRandom.nextInt(palabras.length);                
                while (!palabraUsada) {
                    for (int i = 0; i < palabrasUsadas.length; i++) {
                        if (palabras[elemento_random].equals(palabrasUsadas[i])) {

                            palabraUsada = true;
                        }
                    }
                    if (palabraUsada) {
                        elemento_random = seleccionRandom.nextInt(palabras.length);
                        palabraUsada = false;
                    } else {
                        palabrasUsadas[elemento_random] = palabras[elemento_random];
                        palabraUsada = true;
                        partidas++;
                    }
                }

                
                

                char[] aciertos = new char[palabras[elemento_random].length()];
                boolean letra_encontrada;
                int relleno_letras = 0;

                letra_encontrada = false;
                char[] letra = new char[palabras[elemento_random].length()];

                for (int i = 0; i < letra.length; i++) {
                    if (palabras[elemento_random].charAt(i) == ' ') {
                        letra[i] = ' ';
                        aciertos[i] = ' ';
                        relleno_letras++;
                    } else {
                        letra[i] = '_';
                    }

                }
                boolean volverAEmpezar = false;
                while ((intentos < 5 || relleno_letras == aciertos.length) && !volverAEmpezar) {
                    System.out.print("\nPALABRA A ADIVINAR: ");

                    System.out.println("¿Deseas poner la palabra/frase completa?: (S/N)");
                    opcionn = sc.next().toLowerCase();



                    if (opcionn.equals("s")) {
                                                                        
                        sc.nextLine();
                        System.out.println("ingrese la palabra/frase completa: ");
                        String palabraCompleta = sc.nextLine();
                          
                        if (palabraCompleta.equals(palabras[elemento_random])) {
                            System.out.println("Ganaste, la palabra/frase era: " +
                                    palabras[elemento_random]);
                            volverAEmpezar = true;
                            intentos = 0;
                            
                        } else {
                            System.out.println("La palabra/frase no era.");
                            intentos++;
                            if (intentos == 1) {
                                error1();
                            } else if (intentos == 2) {
                                error2();
                            } else if (intentos == 3) {
                                error3();
                            } else if (intentos == 4) {
                                error4();
                            } else if (intentos == 5) {
                                error5();
                                volverAEmpezar = true;
                                 intentos = 0;
                            }
                        }
                         
                    } else {
                        limpiar();

                        while ((letra_encontrada || intentos == 0 || intentos < 5) && !volverAEmpezar) {
                            letra_encontrada = false;
                            // # El usuario juega una Letra

                            System.out.println(letra);
                            System.out.print("[-] Ingrese una letra: ");
                            char letra_ingresada = sc.next().charAt(0);

                            // # El juego se repite durante N Intentos
                            // # Buscar si la letra ingresada existe en la palabra oculta
                            for (int t = 0; t < palabras[elemento_random].length(); t++) {

                                if (aciertos[t] != 0x00) {
                                    continue;
                                }

                                if (palabras[elemento_random].charAt(t) == letra_ingresada) {
                                    aciertos[t] = palabras[elemento_random].charAt(t);
                                    letra[t] = aciertos[t];
                                    letra_encontrada = true;
                                    relleno_letras++;

                                }
                            }

                            volverAEmpezar = verificarAciertos(relleno_letras, aciertos, letra);

                            if (letra_encontrada && !volverAEmpezar) {
                                System.out.println("[#] Has encontrado una letra.");
                            } else if (!letra_encontrada) {
                                intentos++;
                                letra_encontrada = false;
                            }
                            if (intentos == 1) {
                                error1();
                            } else if (intentos == 2) {
                                error2();
                            } else if (intentos == 3) {
                                error3();
                            } else if (intentos == 4) {
                                error4();
                            } else if (intentos == 5) {
                                error5();
                                volverAEmpezar = true;
                                intentos = 0;
                            }
                        }
                    }
                }
            }

            volver();
        } else if (caracter == 2) {
            creditos();
        } else if (caracter == 3) {
            reglas();
        } else if (caracter == 4) {
            fecha();
        } else if (caracter == 5) {
            clima();
        } else if (caracter == 6) {
            apagarPCl();
        } else if (caracter == 7) {
            apagarPCw();
        } else if (caracter == 99) {
            System.out.println(
                    "usted ha elegido salir del programa, esperamos que haya pasado un buen momento jugando el juego del ahorcado, hasta la proxima!");
        } else {
            System.out.println(
                    "usted ha ingresado un numero que no es contemplado en el menu, por favor, ingrese uno que si este contemplado");
            Menu();
        }
    }

    private static void creditos() throws IOException {
        limpiar();
        System.out.println("#### Creado por: Guillermo Rodriguez Urban y Camilo Zinola ####");
        volver();
    }

    public static void reglas() throws IOException {
        limpiar();
        System.out.println("\n[~~~REGLAS DEL JUEGO~~~]");

System.out.println("1. Usted tiene que igresar una opcion del menu");
System.out.println("2.Tiene que ingresar cuantas palabras quiere jugar");
System.out.println("3.Usted tiene que ingresar la palabra/s");
System.out.println("4.Si desea poner la palabra completa tiene que ingresar 'S' y si no lo desea tiene que ingresar 'N' para jugar letra por letra");
System.out.println("5.Ponga la palabra completa o letra por letra segun la opcion");
System.out.println("6.Si usted le erra a la palabra o a la letra se le contara un error y apecera una parte del muñeco, tiene 5 chances antes de perder");
System.out.println("7.Termina el juego y usted tiene que ingresar si quiere volver al menu ingresando 'S' y si se quiere quedar en la consola viendo el juego tiene que ingresar 'N'");
        volver();

    }

    public static void clima() throws IOException {
        limpiar();
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI(
                    "https://www.meteored.com.uy/tiempo-en_Montevideo-America+Sur-Uruguay-Montevideo-SUMU-1-13027.html");
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        volver();
    }

    public static void fecha() throws IOException {
        limpiar();
        LocalDateTime ahora = LocalDateTime.now();
        int año = ahora.getYear();
        int mes = ahora.getMonthValue();
        int dia = ahora.getDayOfMonth();
        int hora = ahora.getHour();
        int minutos = ahora.getMinute();
        System.out.println("fecha: " + dia + "/" + mes + "/" + año + "\nhora: " + hora + ":" + minutos);
        volver();
    }

    public static void apagarPCl() throws IOException {
        limpiar();
        int seconds;

        String operatingSystem = System.getProperty("os.name");

        if (operatingSystem.equals("Linux")) {

            Runtime runTime = Runtime.getRuntime();

            seconds = 5;

            Process processing = runTime.exec("shutdown -h -t " + seconds);

            System.exit(0);
        }
    }

    public static void apagarPCw() throws IOException {
        limpiar();
        String shutdownCmd = "shutdown -s";
        Process child = Runtime.getRuntime().exec(shutdownCmd);

    }

    public static void limpiar() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
    }

    public static boolean verificarAciertos(int relleno_letras, char[] aciertos, char[] letra)
            throws IOException

    {

        if (relleno_letras == aciertos.length) {
            System.out.println("[#] Has ganado el juego!");
            System.out.print("La palabra o frase era: ");
            System.out.println(letra);
            return true;

        }
        return false;

    }

}
