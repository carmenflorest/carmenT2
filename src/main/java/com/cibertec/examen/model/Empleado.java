package com.cibertec.examen.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Empleado", propOrder = {"id", "dni", "nombres", "area", "sueldo", "fechaIngreso"})
public class Empleado {

    private long id;
    private String dni;
    private String nombres;
    private String area;
    private double sueldo;
    private String fechaIngreso;

    public Empleado() {
    }

    public Empleado(long id, String dni, String nombres, String area, double sueldo, String fechaIngreso) {
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.area = area;
        this.sueldo = sueldo;
        this.fechaIngreso = fechaIngreso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
