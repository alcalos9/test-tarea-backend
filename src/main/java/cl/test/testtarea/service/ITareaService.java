package cl.test.testtarea.service;

import cl.test.testtarea.dto.CommonResponseDTO;
import cl.test.testtarea.dto.TareasDTO;
import cl.test.testtarea.models.entity.Tarea;

public interface ITareaService {

    public TareasDTO findAll();

    public CommonResponseDTO save(Tarea tarea);

    public Tarea update(Tarea tarea);

    public CommonResponseDTO remover(Long identificador);
}
