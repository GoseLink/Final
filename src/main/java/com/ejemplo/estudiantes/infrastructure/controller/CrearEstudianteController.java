package com.ejemplo.estudiantes.infrastructure.controller;

import com.ejemplo.estudiantes.application.CreacionEstudianteService;
import com.ejemplo.estudiantes.domain.Estudiante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("estudiantes")
@RequiredArgsConstructor
public class CrearEstudianteController {

    private final CreacionEstudianteService creacionEstudianteService;

    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante){
        log.info("Se va a crear un estudiante");
        return creacionEstudianteService.crearEstudiante(estudiante);
    }
}
