package com.javier.lib;

import java.util.Scanner;

public class IO {
    public static final Scanner sc = new Scanner(System.in);

    // comentarios solo para la correcta realizacion de ejercicios, esto es mi libreria que controlara sola las excepciones.

    public static double solicitarNum() throws NumberFormatException {
        boolean entradaValida = false;
        double numero = 0;
//        while (!entradaValida) {
//            try {
        System.out.println("Introduce un número: ");
        String input = sc.nextLine();
        numero = Double.parseDouble(input);
        entradaValida = true;
//            } catch (NumberFormatException e) {
//                System.err.println("¡Error! Eso no es un número válido.");
//            }
//        }
        return numero;
    }

    public static String solicitarString() {
        boolean entradaValida = false;
        String str;
//        while (!entradaValida) {
//            try {
        System.out.println("Introduce un número: ");
        str = sc.nextLine();

        entradaValida = true;
//            } catch (NumberFormatException e) {
//                System.err.println("¡Error! Eso no es un número válido.");
//            }
//        }
        return str;
    }

}
