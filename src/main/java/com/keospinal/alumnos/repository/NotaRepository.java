package com.keospinal.alumnos.repository;


import com.keospinal.alumnos.entity.Nota;
import com.keospinal.alumnos.entity.Alumno;
import com.keospinal.alumnos.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    
    // Buscar notas por alumno
    List<Nota> findByAlumno(Alumno alumno);
    
    
    // Buscar nota específica de un alumno en una materia
    List<Nota> findByAlumnoAndMateria(Alumno alumno, Materia materia);
    
    // Calcular promedio de un alumno
    @Query("SELECT AVG(n.valor) FROM Nota n WHERE n.alumno = :alumno")
    Double calcularPromedioPorAlumno(@Param("alumno") Alumno alumno);
    
    // Calcular promedio de una materia
    @Query("SELECT AVG(n.valor) FROM Nota n WHERE n.materia = :materia")
    Double calcularPromedioPorMateria(@Param("materia") Materia materia);
    
    // Obtener todas las notas de un alumno ordenadas por fecha
    List<Nota> findByAlumnoOrderByFechaRegistroDesc(Alumno alumno);
    
    // Contar cuántas notas tiene un alumno
    long countByAlumno(Alumno alumno);
}