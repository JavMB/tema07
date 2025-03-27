package com.javier.Ej6;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{-2, -1, 0, 1, 2};

        if (dividiEntreArray(2, array)) {
            System.out.println(Arrays.toString(array));
        }
    }

    //familiarizandome con streams un poco.
    /**
     * @param num divisor
     * @param array array de dividiendos
     * @return true o false depende si se pudo realizar completamente
     */
    static boolean dividiEntreArray(int num, int[] array) {
        IntStream.range(0, array.length)
                .forEach(index -> {
                    try {
                        if (array[index] == 0) {
                            System.err.println("Division por cero detectada en ondice " + index + " - valor omitido");
                            return;
                        }
                        array[index] = num / array[index];
                        System.out.println("Resultado en indice " + index + ": " + array[index]);
                    } catch (ArithmeticException ae) {
                        System.err.println("Error aritmetico en indice " + index + ": " + ae.getMessage());
                    }
                });
        return true;
    }
}