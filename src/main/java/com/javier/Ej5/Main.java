package com.javier.Ej5;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/*
a) Queremos crear 2 alumnos. De cada alumno guardaremos el nombre, la edad y la altura.
Al solicitar los datos al usuario comprueba que al introducir la edad y la altura no se inserten
letras. Si es así, repite el proceso hasta que se inserten números.
b) Crea los 2 alumnos desde el main(). Visualiza la información de cada uno de ellos y después
indica qué alumno es mayor.
 */
public class Main {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Alumno a1 = crearAlumno();
        Alumno a2 = crearAlumno();
        System.out.println(a1 + " " + a2);

        if (a1.mayorQue(a2)) {
            System.out.println(a1.getNombre() + " es mayor que " + a2.getNombre());
        } else System.out.println(a2.getNombre() + " es mayor que " + a1.getNombre());

    }

    static Alumno crearAlumno() {
        String nombre = pedirNombre();
        float altura = pedirAltura();
        LocalDate fechaNac = pedirFechaNacimiento();

        return new Alumno(nombre, altura, fechaNac);
    }


    static String pedirNombre() {
        System.out.println("Dime el nombre del Alumno:");
        return sc.nextLine();
    }


    static float pedirAltura() {
        float altura = -1;
        while (altura <= 0) {
            System.out.println("Dime la altura en metros:");
            try {
                altura = Float.parseFloat(sc.nextLine());
                if (altura <= 0) {
                    System.err.println("La altura debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Introduce un número válido para la altura.");
            }
        }
        return altura;
    }


    static LocalDate pedirFechaNacimiento() {
        LocalDate fechaNac = null;
        while (fechaNac == null) {
            System.out.println("Dime la fecha de nacimiento, ej: 2007-12-03:");
            try {
                fechaNac = LocalDate.parse(sc.nextLine());
            } catch (DateTimeParseException e) {
                System.err.println("Error: Introduce la fecha en formato válido (yyyy-MM-dd).");
            }
        }
        return fechaNac;
    }


}
