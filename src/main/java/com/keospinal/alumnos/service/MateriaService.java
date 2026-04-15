package com.keospinal.alumnos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keospinal.alumnos.entity.Materia;
import com.keospinal.alumnos.repository.MateriaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MateriaService {
    
    @Autowired
    private MateriaRepository materiaRepository;
    
    // Obtener todas las materias
    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }
    
    // Obtener materia por ID
    public Optional<Materia> findById(Long id) {
        return materiaRepository.findById(id);
    }
    
    // Guardar materia
    public Materia save(Materia materia) {
    // Validar créditos menores 1
        if (materia.getCreditos() < 1) {
            throw new RuntimeException("Los créditos no pueden ser negativos o menores a 1");
        }
        
        // materia NUEVA 
        if (materia.getId() == null) {
            // Validar que el código no exista - redundancia
            Optional<Materia> existente = materiaRepository.findByCodigo(materia.getCodigo());
            if (existente.isPresent()) {
                throw new RuntimeException("Ya existe una materia con el código: " + materia.getCodigo());
            }
            return materiaRepository.save(materia);
        }
        
        // Materia EXISTENTE 
        Optional<Materia> materiaExistente = materiaRepository.findById(materia.getId());
        if (!materiaExistente.isPresent()) {
            throw new RuntimeException("No existe una materia con ID: " + materia.getId());
        }
        
        Optional<Materia> codigoExistente = materiaRepository.findByCodigo(materia.getCodigo());
        if (codigoExistente.isPresent() && !codigoExistente.get().getId().equals(materia.getId())) {
            throw new RuntimeException("Ya existe otra materia con el código: " + materia.getCodigo());
        }
        
        // Actualizar los datos
        Materia existente = materiaExistente.get();
        existente.setNombre(materia.getNombre());
        existente.setCodigo(materia.getCodigo());
        existente.setCreditos(materia.getCreditos());
        
        return materiaRepository.save(existente);
    }
    
    // Eliminar materia
    public void deleteById(Long id) {
        if (!materiaRepository.existsById(id)) {
            throw new RuntimeException("No existe materia con ID: " + id);
        }
        materiaRepository.deleteById(id);
    }
    
}