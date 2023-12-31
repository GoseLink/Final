package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.application.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VerEstudianteService {

    private final EstudianteRepository verEstudianteRepository;

    public List<Estudiante> obtenerEstudiantes() {
        return verEstudianteRepository.findAll().stream()
                .map(estudianteEntity ->
                    Estudiante.builder()
                            .id(estudianteEntity.getId())
                            .edad(estudianteEntity.getEdad())
                            .nombre(estudianteEntity.getNombre())
                            .apellido(estudianteEntity.getApellido())
                            .build())
                .collect(Collectors.toList());
    }

    public Estudiante obtenerEstudiante(Long estudianteId) {
        return verEstudianteRepository.findById(estudianteId).map(estudianteEntity -> Estudiante.builder()
                        .id(estudianteEntity.getId())
                        .edad(estudianteEntity.getEdad())
                        .nombre(estudianteEntity.getNombre())
                        .apellido(estudianteEntity.getApellido())
                        .build()).orElseThrow(() -> new ResourceNotFoundException(String.format("Estdiante %d no encontrado", estudianteId)));
    }
}
