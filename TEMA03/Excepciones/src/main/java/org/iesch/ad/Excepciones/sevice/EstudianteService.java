package org.iesch.ad.Excepciones.sevice;

import jakarta.validation.Valid;
import org.iesch.ad.Excepciones.excepciones.DatosInvalidosException;
import org.iesch.ad.Excepciones.excepciones.EmailDuplicationException;
import org.iesch.ad.Excepciones.excepciones.EstudianteNoEncontradoException;
import org.iesch.ad.Excepciones.modelo.Estudiante;
import org.iesch.ad.Excepciones.modelo.dto.EstudianteRequestDTO;
import org.iesch.ad.Excepciones.modelo.dto.EstudianteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EstudianteService {
    @Autowired
    Map<Long, Estudiante> estudiantes;

    public List<EstudianteResponseDTO> obtenerTodos() {

        List<Estudiante> listaEstudiante = new ArrayList<>(estudiantes.values());
        List<EstudianteResponseDTO> estudianteResponseDTOS =
                listaEstudiante.stream().map(EstudianteResponseDTO::new).toList();
        return estudianteResponseDTOS;
    }

    public EstudianteResponseDTO obtenerPorID(Long id) {
        Estudiante estudiante = estudiantes.get(id);
        if (estudiante != null){
            return new EstudianteResponseDTO(estudiante);
        }else {
            throw new EstudianteNoEncontradoException(id);
        }
    }

    public EstudianteResponseDTO crear(@Valid EstudianteRequestDTO estudianteRequestDTO) {
        //valido que no exista en BBDDD(MAP) el email
        boolean emailExiste = estudiantes.values()
                .stream().anyMatch(e-> e.getEmail().equalsIgnoreCase(estudianteRequestDTO.getEmail()));
        if (emailExiste){
            throw new EmailDuplicationException(estudianteRequestDTO.getEmail());
        }

        //creao el usuario
        Long maxKey = estudiantes.keySet()
                .stream().max(Long::compareTo).orElse(1L);
        Estudiante estudiante = new Estudiante(maxKey, estudianteRequestDTO.getNombre(),
                estudianteRequestDTO.getApellidos(), estudianteRequestDTO.getEmail(),
                estudianteRequestDTO.getEdad(), estudianteRequestDTO.getCiclo());

        estudiantes.put(estudiante.getId(), estudiante);
        return new EstudianteResponseDTO(estudiante);
    }

    public EstudianteResponseDTO actualizar(Long id, @Valid EstudianteRequestDTO estudianteRequestDTO) {
        Estudiante estudiante = estudiantes.get(id);
        if (estudiante == null){
            throw new EstudianteNoEncontradoException(id);
        }

        //validamos el email
        boolean emailExiste = estudiantes.values()
                .stream().anyMatch(e-> e.getEmail().equalsIgnoreCase(estudianteRequestDTO.getEmail()));
        if (emailExiste){
            throw new EmailDuplicationException(estudianteRequestDTO.getEmail());
        }

        //Actualizar los datos
        estudiante.setNombre(estudianteRequestDTO.getNombre());
        estudiante.setApellidos(estudianteRequestDTO.getApellidos());
        estudiante.setEmail(estudianteRequestDTO.getEmail());
        estudiante.setEdad(estudianteRequestDTO.getEdad());
        estudiante.setCiclo(estudianteRequestDTO.getCiclo());

        return new EstudianteResponseDTO(estudiante);
    }

    public void eliminar(Long id) {

        Estudiante estudiante = estudiantes.get(id);
        if (estudiante == null){
            throw new EstudianteNoEncontradoException(id);
        }

        estudiantes.remove(id);

    }

    public List<EstudianteResponseDTO> obtenerPorCiclo(String ciclo) {
        //validamos que el ciclo sea valido
        if (!ciclo.matches("(?i)DAM|DAW|SMR|ASIR")){
            throw new DatosInvalidosException(
                    "Ciclo no valido"
            );
        }

        List<EstudianteResponseDTO> resultado = estudiantes.values()
                .stream().filter(estudiante -> estudiante.getCiclo().equalsIgnoreCase(ciclo))
                .map(EstudianteResponseDTO::new)
                .toList();

        if (resultado.isEmpty()){
            throw new EstudianteNoEncontradoException("No existen estudiantes del ciclo: " + ciclo);
        }
        return resultado;
    }
}
