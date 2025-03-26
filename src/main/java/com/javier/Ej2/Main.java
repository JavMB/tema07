package com.javier.Ej2;
import com.javier.lib.IO;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("El numero mas alto es : "+solicitarNums(10));
    }

    /**
     *
     * @param cantidad cuantos numeros solicitara al usuario
     * @return devuelve el numero mas grande
     */
    static double solicitarNums(int cantidad) {
        double[] nums = new double[10];
        int contador = 0;
        int contadorExcepcion = 0;
        boolean entradaValida;


        do {
            entradaValida = false;
            while (!entradaValida) {
                try {
                    nums[contador++] = IO.solicitarNum();
                    entradaValida = true;
                } catch (NumberFormatException e) {
                    contadorExcepcion++;
                    System.err.println("¡Error! Eso no es un número válido.");
                }
            }

        } while (contador < cantidad);

        System.out.println("Has hecho saltar " + contadorExcepcion + " excepcion");
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }
}



