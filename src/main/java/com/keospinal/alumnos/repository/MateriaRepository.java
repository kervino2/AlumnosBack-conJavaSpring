package com.keospinal.alumnos.repository;

import com.keospinal.alumnos.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
    
    // Buscar por código (único)
    Optional<Materia> findByCodigo(String codigo);
    
    // Buscar por nombre
    Optional<Materia> findByNombre(String nombre);
    
}