package com.javier.Ej8;
/*
Crea un programa que provoque las siguientes excepciones, las trate y muestre un mensaje
indicando que la excepción ha sido tratada:
a) ArithmeticException
b) NullPointerException
c) IndexOutOfBoundsException
 */
public class Main {
    public static void main(String[] args) {
        // a) ArithmeticException
        try {
            int dividendo = 10;
            int divisor = 0;
            int resultado = dividendo / divisor;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero");
        }

        // b) NullPointerException
        try {
            String texto = null;
            int longitud = texto.length();
            System.out.println("Longitud: " + longitud);
        } catch (NullPointerException e) {
            System.out.println("Intento de usar objeto nulo");
        }

        // c) IndexOutOfBoundsException
        try {
            int[] array = new int[5];
            array[10] = 100;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice fuera de rango");
        }
    }
}
