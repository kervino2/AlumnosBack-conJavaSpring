package com.keospinal.alumnos.repository;

import com.keospinal.alumnos.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    
    // Buscar por id (único)
    Optional<Alumno> findByEmail(String email);
    
    // Buscar por nombre o apellido
    List<Alumno> findByNombreContainingIgnoreCase(String nombre);
    List<Alumno> findByApellidoContainingIgnoreCase(String apellido);
    
}