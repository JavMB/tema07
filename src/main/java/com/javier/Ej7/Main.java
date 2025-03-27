package com.javier.Ej7;

/*
Escribe un métod, de nombre mostrarCadenasArray, que reciba como parámetro un array de
cadenas de caracteres. El métod mostrará por pantalla el primer carácter de cada una de las
cadenas contenidas en la array.
a) Se debe evitar que se produzca una excepción NullPointerException si alguna de las posiciones
del array contiene una referencia no inicializada (null).
 */
public class Main {
    public static void main(String[] args) {
        String[] str = new String[]{"Juan", "Alberto", "Vicente","Ignacio",null,"Marcos","Ernesto","Nando","Germán","Ulises","Alvaro","Lukas"};
        System.out.println(mostrarCadenasArray(str));
    }
    /**
     *  Obtiene el primer char de cara cadena y devuelve un array de con esos caracteres
     * @params  una array de cadenas
     * @return devuelve una array de chars con el primer char de cada cadena del array
     */
    static char[] mostrarCadenasArray(String[] array) {
        char[] car = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                car[i]=' ';
                continue;
            }
            array[i].getChars(0, 1, car, i);
        }
        return car;
    }


}
