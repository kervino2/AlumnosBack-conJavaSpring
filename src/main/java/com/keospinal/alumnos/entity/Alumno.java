package com.keospinal.alumnos.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column( nullable = false)
    private String nombre;

    @Column( nullable = false)
    private String apellido;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;  // ← camelCase, no fecha_nacimiento
    
    @OneToMany(mappedBy = "alumno")
    private List<Nota> notas;
    
    
    // Getters y Setters
    public Long getId() {
    return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}