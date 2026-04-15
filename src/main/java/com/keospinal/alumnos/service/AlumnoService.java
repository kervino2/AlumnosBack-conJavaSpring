package com.keospinal.alumnos.service;

import com.keospinal.alumnos.entity.Alumno;
import com.keospinal.alumnos.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    // Obtener todos los alumnos
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    // Obtener alumno por ID
    public Optional<Alumno> findById(Long id) {
        return alumnoRepository.findById(id);
    }

    // Guardar alumno (actualizar)
    public Alumno save(Alumno alumno) {
        // Es un alumno NUEVO 
        if (alumno.getId() == null) {
            // Validar por email
            Optional<Alumno> existente = alumnoRepository.findByEmail(alumno.getEmail());
            if (existente.isPresent()) {
                throw new RuntimeException("Ya existe un alumno con el email: " + alumno.getEmail());
            }
            return alumnoRepository.save(alumno);
        }

        // alumno EXISTENTE ( es una actualización)
        Optional<Alumno> alumnoExistente = alumnoRepository.findById(alumno.getId());
        if (!alumnoExistente.isPresent()) {
            throw new RuntimeException("No existe un alumno con ID: " + alumno.getId());
        }

        Optional<Alumno> emailExistente = alumnoRepository.findByEmail(alumno.getEmail());
        if (emailExistente.isPresent() && !emailExistente.get().getId().equals(alumno.getId())) {
            throw new RuntimeException("Ya existe otro alumno con el email: " + alumno.getEmail());
        }

        // Actualizar los datos
        Alumno existente = alumnoExistente.get();
        existente.setNombre(alumno.getNombre());
        existente.setApellido(alumno.getApellido());
        existente.setEmail(alumno.getEmail());
        existente.setFechaNacimiento(alumno.getFechaNacimiento());

        return alumnoRepository.save(existente);
    }

    // Eliminar alumno
    public void deleteById(Long id) {
        // Verificar que exista antes de eliminar
        if (!alumnoRepository.existsById(id)) {
            throw new RuntimeException("No existe alumno con ID: " + id);
        }
        alumnoRepository.deleteById(id);
    }

    // Verificar si existe
    public boolean existsById(Long id) {
        return alumnoRepository.existsById(id);
    }
}