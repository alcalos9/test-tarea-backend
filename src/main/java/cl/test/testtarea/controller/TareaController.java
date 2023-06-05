package cl.test.testtarea.controller;

import cl.test.testtarea.dto.CommonResponseDTO;
import cl.test.testtarea.dto.TareasDTO;
import cl.test.testtarea.models.entity.Tarea;
import cl.test.testtarea.service.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    private ITareaService tareaService;

    @GetMapping("/listar")
    public TareasDTO listarTareas(){
        return tareaService.findAll();
    }

    @PostMapping("/agregar")
    public ResponseEntity<CommonResponseDTO> agregarTarea(@RequestBody(required = true) Tarea tarea){
        return ResponseEntity.ok().body(tareaService.save(tarea));
    }

    @DeleteMapping("/remover/{identificador}")
    public ResponseEntity<CommonResponseDTO> removerTarea(@PathVariable Long identificador){
        return ResponseEntity.ok().body(tareaService.remover(identificador));
    }

    @PutMapping("/editar")
    public Tarea editarTarea(@RequestBody(required = true) Tarea tarea){
       return tareaService.update(tarea);
    }

}
