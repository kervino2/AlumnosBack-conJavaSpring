package com.keospinal.alumnos.repository;


import com.keospinal.alumnos.entity.Nota;
import com.keospinal.alumnos.entity.Alumno;
import com.keospinal.alumnos.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    
    // Buscar notas por alumno
    List<Nota> findByAlumno(Alumno alumno);
    
    
    @EntityGraph(attributePaths = {"alumno", "materia"})
    List<Nota> findByAlumnoAndMateria(Alumno alumno, Materia materia);
           
}