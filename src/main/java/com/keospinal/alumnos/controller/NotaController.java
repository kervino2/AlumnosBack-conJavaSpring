package com.keospinal.alumnos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.keospinal.alumnos.entity.Nota;
import com.keospinal.alumnos.service.NotaService;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
public class NotaController {
    
    @Autowired
    private NotaService notaService;
    
          
    // Crear nueva nota
    @PostMapping
    public ResponseEntity<?> createNota(@RequestBody Nota nota) {
        try {
            Nota nuevaNota = notaService.save(nota);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNota);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    // Eliminar nota
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNota(@PathVariable Long id) {
        try {
            notaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Obtener notas por alumno
    @GetMapping("/alumno/{alumnoId}")
    public ResponseEntity<?> getNotasByAlumno(@PathVariable Long alumnoId) {
        try {
            List<Nota> notas = notaService.findByAlumno(alumnoId);
            return ResponseEntity.ok(notas);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }    

    // Obtener notas por alumno en un ateria
    @GetMapping("/alumno/{alumnoId}/materia/{materiaId}")
    public ResponseEntity<?> getNotasByAlumnoMateria(@PathVariable Long alumnoId, @PathVariable Long materiaId) {
        try {
            List<Nota> notas = notaService.findByAlumno(alumnoId);
            return ResponseEntity.ok(notas);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }       
    
}
