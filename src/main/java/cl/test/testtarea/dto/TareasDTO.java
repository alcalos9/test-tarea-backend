package cl.test.testtarea.dto;

import cl.test.testtarea.models.entity.Tarea;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TareasDTO implements Serializable {
    private List<Tarea> tareas;
}
