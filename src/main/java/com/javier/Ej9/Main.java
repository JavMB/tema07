package com.javier.Ej9;
/*
Modifica el programa anterior y crea 3 clases de excepciones personalizadas, haciendo uso de la
palabra reservada extends, para los 3 tipos de excepciones anteriores. Cuando se produzca una
excepción de los 3 tipos anteriores deberemos lanzar nuestra propia excepción y mostrar un
mensaje personalizado.
 */

public class Main {
    public static void main(String[] args) {
        // a) ArithmeticException
        try {
            int dividendo = 10;
            int divisor = 0;
            if (divisor == 0) {
                throw new DivisionPorCeroException("Error matemático División por cero detectada");
            }
            int resultado = dividendo / divisor;
            System.out.println("Resultado: " + resultado);
        } catch (DivisionPorCeroException e) {
            System.out.println(e.getMessage());
        }

        // b) NullPointerException
        try {
            String texto = null;
            if (texto == null) {
                throw new ObjetoNuloException("Objeto no inicializado Se intentó usar una referencia nula");
            }
            int longitud = texto.length();
            System.out.println("Longitud: " + longitud);
        } catch (ObjetoNuloException e) {
            System.out.println(e.getMessage());
        }

        // c) IndexOutOfBoundsException
        try {
            int[] array = new int[5];
            int indice = 10;
            if (indice >= array.length) {
                throw new IndiceFueraRangoException("Indice no valido Se intentó acceder a una posición fuera del array");
            }
            array[indice] = 100;
        } catch (IndiceFueraRangoException e) {
            System.out.println(e.getMessage());
        }
    }

}

class DivisionPorCeroException extends Exception {
    public DivisionPorCeroException(String mensaje) {
        super(mensaje);
    }
}

class ObjetoNuloException extends Exception {
    public ObjetoNuloException(String mensaje) {
        super(mensaje);
    }
}

class IndiceFueraRangoException extends Exception {
    public IndiceFueraRangoException(String mensaje) {
        super(mensaje);
    }
}