package mapper;

import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.domain.Estudiante.EstudianteBuilder;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity.EstudianteEntityBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-18T10:07:48-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.21 (Eclipse Adoptium)"
)
public class EstudianteMapperImpl implements EstudianteMapper {

    @Override
    public EstudianteEntity mapToEntity(Estudiante estudiante) {
        if ( estudiante == null ) {
            return null;
        }

        EstudianteEntityBuilder estudianteEntity = EstudianteEntity.builder();

        estudianteEntity.id( estudiante.getId() );
        estudianteEntity.apellido( estudiante.getApellido() );
        estudianteEntity.nombre( estudiante.getNombre() );
        estudianteEntity.edad( estudiante.getEdad() );

        return estudianteEntity.build();
    }

    @Override
    public Estudiante mapToDomain(EstudianteEntity estudianteEntity) {
        if ( estudianteEntity == null ) {
            return null;
        }

        EstudianteBuilder estudiante = Estudiante.builder();

        estudiante.id( estudianteEntity.getId() );
        estudiante.nombre( estudianteEntity.getNombre() );
        estudiante.apellido( estudianteEntity.getApellido() );
        estudiante.edad( estudianteEntity.getEdad() );

        return estudiante.build();
    }
}
