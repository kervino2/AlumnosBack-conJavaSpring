package com.keospinal.alumnos.service;

import com.keospinal.alumnos.entity.Nota;
import com.keospinal.alumnos.entity.Alumno;
import com.keospinal.alumnos.entity.Materia;
import com.keospinal.alumnos.repository.NotaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NotaService {
    
    private Double valormin = 0.0;
    private Double valormax = 5.0;

    @Autowired
    private NotaRepository notaRepository;
    
    @Autowired
    private AlumnoService alumnoService;
    
    @Autowired
    private MateriaService materiaService;
    
    // Obtener todas las notas
    public List<Nota> findAll() {
        return notaRepository.findAll();
    }
    
    
    // Guardar nota
    public Nota save(Nota nota) {
        double valor;
        valor = nota.getValor();
        
        if (valor < this.valormin || valor > this.valormax) {
            throw new RuntimeException("La nota debe estar entrelos valores preestablesidos");
        }
        
        // Verificar que el alumno existe
        if (nota.getAlumno() == null || nota.getAlumno().getId() == null) {
            throw new RuntimeException("Debe especificar un alumno válido");
        }
        
        Optional<Alumno> alumno = alumnoService.findById(nota.getAlumno().getId());
        if (!alumno.isPresent()) {
            throw new RuntimeException("No existe el alumno con ID: " + nota.getAlumno().getId());
        }
        nota.setAlumno(alumno.get());
        
        // Verificar que la materia existe
        if (nota.getMateria() == null || nota.getMateria().getId() == null) {
            throw new RuntimeException("Debe especificar una materia válida");
        }
        
        Optional<Materia> materia = materiaService.findById(nota.getMateria().getId());
        if (!materia.isPresent()) {
            throw new RuntimeException("No existe la materia con ID: " + nota.getMateria().getId());
        }
        nota.setMateria(materia.get());
        
                
        return notaRepository.save(nota);
    }
    
    // Eliminar nota
    public void deleteById(Long id) {
        if (!notaRepository.existsById(id)) {
            throw new RuntimeException("No existe nota con ID: " + id);
        }
        notaRepository.deleteById(id);
    }
    
    // Obtener notas por alumno
    public List<Nota> findByAlumno(Long alumnoId) {
        Optional<Alumno> alumno = alumnoService.findById(alumnoId);
        if (!alumno.isPresent()) {
            throw new RuntimeException("No existe el alumno con ID: " + alumnoId);
        }
        return notaRepository.findByAlumno(alumno.get());
    }
    
    public List<Nota> findByAlumnoMateria(Long alumnoId, Long materiaId) {
        Optional<Alumno> alumno = alumnoService.findById(alumnoId);
        if (!alumno.isPresent()) {
            throw new RuntimeException("No existe el alumno con ID: " + alumnoId);
        }

        Optional<Materia> materia = materiaService.findById(materiaId);
        if (!materia.isPresent()) {
            throw new RuntimeException("No existe la materia con ID: " + materiaId);
        }
        return notaRepository.findByAlumnoAndMateria(alumno.get(), materia.get());
    }    
    
}