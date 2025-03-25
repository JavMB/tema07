package com.javier;

import java.util.Scanner;

public class Main {
    static final Scanner sc = new Scanner(System.in);
    static final int LONGITUD_MATRICULA = 8;
    static final int DIGITOS_INICIALES = 4;

    public static void main(String[] args) {
        String matricula;
        boolean validado = false;

        while (!validado) {
            try {
                matricula = solicitarMatricula("Dime la matricula", LONGITUD_MATRICULA, LONGITUD_MATRICULA);
                validado = validarMatricula(matricula);

                if (validado) {
                    System.out.println("Matricula valida: " + matricula);
                    break;
                }

            } catch (MatriculaInvalidaException mie) {
                System.out.println(mie.getMessage());
            }
        }
        sc.close();
    }


    static String solicitarMatricula(String mensaje,int min, int max) throws MatriculaInvalidaException {
        String matricula;
        System.out.println(mensaje);
        matricula = sc.nextLine();

        if (matricula.length()+1 < min || matricula.length() > max)
            throw new MatriculaInvalidaException("Longitud de matricula invalida");

        return matricula;
    }

    static boolean validarMatricula(String matricula) throws MatriculaInvalidaException {
        int i;

        for (i = 0; i < DIGITOS_INICIALES; i++) {
            if (!Character.isDigit(matricula.charAt(i))) {
                throw new MatriculaInvalidaException("Los primeros 4 caracteres deben ser digitos");
            }
        }

        if (!Character.isWhitespace(matricula.charAt(i))) {
            throw new MatriculaInvalidaException("Debe haber un espacio después de los 4 digitos");
        }

        for (int j = i + 1; j < matricula.length(); j++) {
            if (!Character.isLetter(matricula.charAt(j))) {
                throw new MatriculaInvalidaException("Los ultimos 3 caracteres deben ser letras");
            }
        }

        return true;
    }

    static class MatriculaInvalidaException extends Exception {

        public MatriculaInvalidaException(String mensaje) {
            super(mensaje);
        }

        public MatriculaInvalidaException() {
            super("Matricula invalida");
        }
    }
}
