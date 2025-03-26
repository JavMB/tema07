package com.javier.Ej4;

/*
Para comprobar el funcionamiento de algunas excepciones, haz lo siguiente:
 a) Crea un métod que reciba un array de enteros. Este métod irá leyendo números desde
teclado y guardándolos en el array. ¿Qué situaciones se pueden producir y que hacer en ellas?
• Que se inserte una letra: informar al usuario.
• Que se sobrepase la capacidad de la array: informar al usuario, finalizar y mostrar el
contenido del array.
• Que el array no esté creado: informar al usuario y finalizar.

 b) Desde el main() crea un array de 5 números enteros y llama al métod. Haz diferentes pruebas
para forzar las dos primeras excepciones.
 c) Después declara (sin crearlo) un array en el main() y llama al métod.
 */

import com.javier.lib.IO;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arry = new int[5];
        introducirNumsArray(arry);
        System.out.println(Arrays.toString(arry));
        System.out.println();

        try {
            int[] arry2 = null;
            introducirNumsArray(arry2);
        } catch (NullPointerException npe) {
            System.err.println("El array no está inicializado. Por favor, crea el array antes de usarlo.");
        }

        sc.close();
    }

    /**
     * Introduce numeros hasta que el usuario quiera o en su defecto el array llegue a su limite
     *
     * @param array recibe un array para introducirle numeros
     */
    static void introducirNumsArray(int[] array) {
        int numero;
        int cont = 0;

        do {
            try {
                numero = (int) IO.solicitarNum();
                array[cont++] = numero;
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                System.err.println(arrayIndexOutOfBoundsException.getMessage() + " : " + Arrays.toString(array));
                return;

            } catch (NumberFormatException nfe) {
                System.err.println("Introduce solo numeros porfavor");
            }
        } while (seguirIntroduciendo(array));
    }

    /**
     * Controla la interaccion con el usuario
     *
     * @param array recibe un array para mostrarla
     * @return devuelve un boolean depende de si el usuario desea seguir introduciendo
     */
    static boolean seguirIntroduciendo(int[] array) {
        System.out.println("Quiere introducir un numero al array? S/N " + Arrays.toString(array));
        return sc.next().toLowerCase().charAt(0) == 's';
    }
}
