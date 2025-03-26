package com.javier.Ej5;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.StringJoiner;

public class Alumno {
    private final String nombre;
    private final float altura;
    private final LocalDate fechaNac;
    private int edad;


    public Alumno(String nombre, float altura, LocalDate fechaNac) {
        this.nombre = nombre;
        this.altura = altura;
        this.fechaNac = fechaNac;
        this.edad = getEdad();
    }

    public int getEdad() {
        return Period.between(fechaNac, LocalDate.now()).getYears();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean mayorQue(Alumno alumno) {
        if (!this.equals(alumno)) {
            return this.fechaNac.isBefore(alumno.fechaNac);
        } else throw new RuntimeException("Son el mismo alumno");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Float.compare(altura, alumno.altura) == 0 && edad == alumno.edad && Objects.equals(nombre, alumno.nombre) && Objects.equals(fechaNac, alumno.fechaNac);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, altura, fechaNac, edad);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Alumno.class.getSimpleName() + "[", "]")
                .add("nombre='" + nombre + "'")
                .add("altura=" + altura)
                .add("fechaNac=" + fechaNac)
                .add("edad=" + edad)
                .toString();
    }
}

