package com.javier.Ej3;

import com.javier.lib.IO;

import java.util.*;

/**
 * Escribe un programa que lea por teclado una secuencia de números hasta que el usuario inserte letras.
 * Al final del programa, debe visualizarse el número más alto de todos los que se hayan
 * introducido. Puede ocurrir que un usuario no llegue a insertar ningún número.
 * En este caso, se indicará con el mensaje correspondiente. Debe emplearse un métod para solicitar los números.
 */

public class Main {
    public static void main(String[] args) {

        System.out.println(solicitarNums());
    }

    /**
     *  Solicita numeros hasta que pongas una letra
     * @return devuelve el numero mas grande
     */
    static double solicitarNums() {
        List<Double> nums = new ArrayList<>();
        boolean letraIntroducida = false;
        String str;


        while (!letraIntroducida) {
            try {
                str = IO.solicitarString();
                if (str.isEmpty()) {
                    throw new NoNumbersEnteredException();
                }
                nums.add(Double.parseDouble(str));

            } catch (NumberFormatException nfe) {
                System.err.println("¡Error! Eso no es un número válido.");
                letraIntroducida = true;
            } catch (NoNumbersEnteredException nnee) {
                System.err.println(nnee.getMessage());
            }
        }

        if (!nums.isEmpty()) {
            Collections.sort(nums);
            return nums.getLast();
        } else return 0;

    }
}
