package com.javier.Ej1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Escribe un metod que se encargue de solicitar números al usuario, validando que no se
 * introduzcan letras, hasta que se indique un número negativo. Los números deben guardarse en un
 * array
 */

public class Main {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solicitarNums()));
        sc.close();
    }

    /**
     * @return devuelve un array de numeros decimales
     * @throws NumberFormatException puede lanzar una excepcion de entrada incorrecta
     */
    static double[] solicitarNums() throws NumberFormatException {
        double[] nums = new double[10];
        double num;
        int size = 0;
        boolean negativo = false;

        while (!negativo) {
            if (size >= nums.length - 1) {
                nums = Arrays.copyOf(nums, nums.length * 2);
            }
            try {
                System.out.println("Dime el siguiente num");
                num = Double.parseDouble(sc.nextLine());
                negativo = num < 0;
                nums[size++] = num;

            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage() + " Pon un numero entero");
            }
        }
        return nums;
    }
}
