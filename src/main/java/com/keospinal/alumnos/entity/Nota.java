package com.keospinal.alumnos.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Notas")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private Double valor;
    
    @Column(name = "fecha_registro", nullable = false)  // La columna en BD sigue con _
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;
    
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Double getValor() {
        return valor;
    }
    
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(Date fecha_registro) {
        this.fechaRegistro = fecha_registro;
    }
    
    public Alumno getAlumno() {
        return alumno;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    public Materia getMateria() {
        return materia;
    }
    
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
