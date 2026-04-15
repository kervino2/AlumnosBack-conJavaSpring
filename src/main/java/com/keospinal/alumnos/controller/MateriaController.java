package com.keospinal.alumnos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.keospinal.alumnos.entity.Materia;
import com.keospinal.alumnos.service.MateriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {
    
    @Autowired
    private MateriaService materiaService;
    
    // Obtener todas las materias
    @GetMapping
    public ResponseEntity<List<Materia>> getAllMaterias() {
        List<Materia> materias = materiaService.findAll();
        return ResponseEntity.ok(materias);
    }
    
    // Obtener materia por ID
    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable Long id) {
        Optional<Materia> materia = materiaService.findById(id);
        if (materia.isPresent()) {
            return ResponseEntity.ok(materia.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    
    // Crear nueva materia
    @PostMapping
    public ResponseEntity<?> createMateria(@RequestBody Materia materia) {
        try {
            Materia nuevaMateria = materiaService.save(materia);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMateria);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    // Actualizar materia
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMateria(@PathVariable Long id, @RequestBody Materia materia) {
        try {
            materia.setId(id);
            Materia actualizada = materiaService.save(materia);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            if (e.getMessage().contains("No existe")) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    // Eliminar materia
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMateria(@PathVariable Long id) {
        try {
            materiaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}