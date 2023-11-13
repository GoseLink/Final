package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mapper.EstudianteMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActualizacionEstudianteService {

    private final EstudianteRepository estudianteRepository;


    public Estudiante actualizarEstudiante(Long estudianteId, Estudiante estudianteActualizado){
        EstudianteEntity entity = estudianteRepository.findById(estudianteId).orElse(null);
        if (entity != null){
            entity.setNombre(estudianteActualizado.getNombre());
            entity.setApellido(estudianteActualizado.getApellido());
            entity.setEdad(estudianteActualizado.getEdad());
            EstudianteEntity estudiante = estudianteRepository.save(entity);
            return EstudianteMapper.INSTANCE.mapToDomain(estudiante);
        }
        return null;
    }
}
