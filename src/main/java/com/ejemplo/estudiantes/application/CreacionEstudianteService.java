package com.ejemplo.estudiantes.application;


import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mapper.EstudianteMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreacionEstudianteService {

    private final EstudianteRepository estudianteRepository;

    public Estudiante crearEstudiante(Estudiante estudiante){
        EstudianteEntity entity = EstudianteEntity.builder().
                nombre(estudiante.getNombre()).
                apellido(estudiante.getApellido()).
                edad(estudiante.getEdad()).
                build();
        EstudianteEntity estudianteResultante = estudianteRepository.save(entity);
        return EstudianteMapper.INSTANCE.mapToDomain(estudianteResultante);


    }
}
