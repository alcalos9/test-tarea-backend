package cl.test.testtarea.service.impl;

import cl.test.testtarea.dto.CommonResponseDTO;
import cl.test.testtarea.dto.TareasDTO;
import cl.test.testtarea.models.dao.ITareaDao;
import cl.test.testtarea.models.entity.Tarea;
import cl.test.testtarea.service.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TareaServiceImpl implements ITareaService {

    @Autowired
    private ITareaDao tareaDao;
    @Override
    public TareasDTO findAll() {
        TareasDTO tareasDTO = new TareasDTO();
        tareasDTO.setTareas(tareaDao.findAll());
        return tareasDTO;
    }

    @Override
    public CommonResponseDTO save(Tarea tarea) {
        tarea.validate();
        CommonResponseDTO response = new CommonResponseDTO();
        boolean existe = existeTarea(tarea.getIdentificador());
        if (existe) {
            response.setStatusCode(500);
            response.setStatusMessage("Tarea ya existe");
        } else
            response = responseSaveTarea(tarea, response);
        return response;
    }

    private boolean existeTarea(Long identificador) {
        Optional<Tarea> tareaOptional = tareaDao.findById(identificador);
        if (tareaOptional.isPresent())
            return true;
        return false;
    }

    private Tarea obtenerTarea(Long identificador) {
        Optional<Tarea> tareaOptional = tareaDao.findById(identificador);
        if (tareaOptional.isPresent())
            return tareaOptional.get();
        return null;
    }
    private CommonResponseDTO responseSaveTarea(Tarea tarea, CommonResponseDTO response) {
        if (tareaDao.save(tarea) != null) {
            response.setStatusCode(200);
            response.setStatusMessage("Acción realizada exitosamente");
        }else {
            response.setStatusCode(500);
            response.setStatusMessage("Problemas al ejecutar la acción");
        }
        return response;
    }

    @Override
    public Tarea update(Tarea tarea) {
        Tarea newTarea = new Tarea();

        tarea.validate();
        CommonResponseDTO response = new CommonResponseDTO();
        boolean existe = existeTarea(tarea.getIdentificador());
        if (!existe) {
            response.setStatusCode(500);
            response.setStatusMessage("Tarea no existe");
        } else {
            newTarea = tareaDao.save(tarea);
            newTarea.validate();
        }
        return newTarea;
    }

    public Optional<Tarea> findById(Long id) {
        return tareaDao.findById(id);
    }

    @Override
    public CommonResponseDTO remover(Long identificador) {
        CommonResponseDTO response = new CommonResponseDTO();
        Tarea tarea = obtenerTarea(identificador);
        if (tarea != null) {
            tareaDao.delete(tarea);
            response.setStatusCode(200);
            response.setStatusMessage("Tarea eliminada exitosamente");
        } else{
            response.setStatusCode(500);
            response.setStatusMessage("Tarea no existe");
        }
        return response;
    }

}

