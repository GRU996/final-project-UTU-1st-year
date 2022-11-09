import java.util.Scanner;
import java.util.Random;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;

public class App {

    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();

    public static void main(String[] args) throws IOException {
        Menu();
    }

    public static void volver() throws IOException {
        char volver;
        System.out.print("¿Deseas volver al menu principal?: (S/N): ");
        volver = sc.next().charAt(0);

        if (volver == 's' || volver == 'S') {
            Menu();
        } else if (volver == 'n' || volver == 'N') {
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

        LimpiarConsola();

        byte caracter;

        System.out.println("¿que quiere hacer?\n" +
                "ingrese 1 si quiere jugar\n" +
                "ingrese 2 si quiere ver los creditos del programa\n" +
                "ingrese 3 si quiere ver las reglas del juego\n" +
                "ingrese 4 si quiere ver la fecha y hora actual\n" +
                "ingrese 5 si quiere ver el clima del dia de mañana\n" +
                "ingrese 6 para apagar la pc (linux)\n" +
                "ingrese 7 para apagar la pc (windows)\n" +
                "ingrese 99 para salir del programa");
        System.out.print("ingreso [>] ");
        caracter = sc.nextByte();
        if (caracter != 99) {
            if (caracter == 1) {
                int n, intentos = 0;
                LimpiarConsola();
                System.out.println("\n#|#|#|#|#|¡BIENVENIDO AL JUEGO!#|#|#|#|#|\n" +
                        "¡Recuerde leer las reglas!\n");
                System.out.print("Ingrese cuantas palabras quiere jugar [>] ");
                n = sc.nextInt();
                sc.nextLine();

                String[] palabras = new String[n];
                String opcionn;
                String palabra_completa;

                for (int i = 0; i < palabras.length; i++) {
                    System.out.print(" Ingrese la/s nueva/s palabra/s [>] ");
                    palabras[i] = sc.nextLine();
                }

                int elemento_random = r.nextInt(palabras.length);

                char[] aciertos = new char[palabras[elemento_random].length()];
                boolean letra_encontrada;
                int relleno_letras = 0;

                letra_encontrada = false;
                StringBuilder letra = new StringBuilder();
                System.out.print("\nPALABRA A ADIVINAR: ");

                // # Algoritmo para sustituir letra por guíon
                for (int i = 0; i < aciertos.length; i++) {
                    if (aciertos[i] != 0x00) {
                        letra.append(aciertos[i]);
                    } else {
                        letra.append("_");
                    }
                }

                System.out.println(letra);

                System.out.println("¿Deseas poner la palabra completa?: (Y/N)");
                opcionn = sc.nextLine().toLowerCase();

                if (opcionn.equals("y")) {
                    System.out.println("Ingrese la palabra completa: ");
                    palabra_completa = sc.nextLine();

                    if (palabra_completa.equals(palabras[elemento_random])) {
                        System.out.println("Ganaste, la palabra era: " + palabras[elemento_random]);
                        volver();
                        System.exit(0);
                    } else {
                        System.out.println("La palabra no era.");
                        intentos++;
                    }
                } else if (opcionn.equals("n")) {
                    LimpiarConsola();
                    while (true) {
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
                                letra_encontrada = true; // Es esta
                                relleno_letras++;
                                break;
                            }

                        }

                        /*
                         * > Pregunta si ya todas las letras fueron rellenadas con 1 entonces si es asi
                         * finaliza el juego
                         * aciertos: La cantidad de letras de la palabra
                         * relleno_letras: La cantidad de letras que acierta el jugador en la palabra
                         * 
                         * Ejemplo
                         * aciertos = 9
                         * relleno_letras = x (las letras que lleve acertando el jugador actualmente)
                         * 
                         * N i c a r a g u a
                         * 1 1 1 1 1 1 1 1 1
                         */

                        if (relleno_letras == aciertos.length) {
                            System.out.println("[#] Has ganado el juego!");
                            volver();
                            System.exit(0);
                        }

                        if (letra_encontrada == true) {
                            System.out.println("[#] Has encontrado una letra.");
                        } else {
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
                                volver();
                            }
                        }
                    }
                }
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

    }

    private static void creditos() throws IOException {
        LimpiarConsola();
        System.out.println("#### Creado por: Guillermo Rodriguez Urban y Camilo Zinola ####");
        volver();
    }

    public static void reglas() throws IOException {
        LimpiarConsola();
        System.out.println("\n[~~~~~~REGLAS DEL JUEGO~~~~~~]");
        System.out.println(
                "Turno: + Muñeco: El muñeco se dibuja en 5 partes (cabeza, tronco y extremidades), por lo que el adivinador tiene 5 posibilidades de fallar.");
        System.out.println("+ Adivinar la Palabra: El jugador puede intentar adivinar la palabra o frase secreta.");
        System.out.println("+ Si acierta la palabra, entonces el programa completa la solución en la consola.");
        System.out.println("+ Si no acierta la palabra, entonces el programa dibujará una parte del muñeco.");
        System.out.println("\nFin de la partida:");
        System.out.println("+ GANA el adivinador si descubre la palabra o frase secreta.");
        System.out.println("+ PIERDE el avidinador si se dibuja el muñeco completo en la horca.");

        volver();

    }

    public static void clima() throws IOException {
        LimpiarConsola();
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("https://www.accuweather.com/es/uy/reducto/349262/daily-weather-forecast/349262?day=23");
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        volver();
    }

    public static void fecha() throws IOException {
        LimpiarConsola();
        LocalDateTime ahora = LocalDateTime.now();
        int año = ahora.getYear();
        int mes = ahora.getMonthValue();
        int dia = ahora.getDayOfMonth();
        int hora = ahora.getHour();
        int minutos = ahora.getMinute();
        System.out.println("fecha: " + dia + "/" + mes + "/" + año +
                "\nhora: " + hora + ":" + minutos);
        volver();
    }

    public static void apagarPCl() throws IOException {
        LimpiarConsola();
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
        LimpiarConsola();
        String shutdownCmd = "shutdown -s";
        Process child = Runtime.getRuntime().exec(shutdownCmd);

    }

    public static void LimpiarConsola() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
    }
}