package cl.test.testtarea.service.impl;

import cl.test.testtarea.dto.CommonResponseDTO;
import cl.test.testtarea.dto.TareasDTO;
import cl.test.testtarea.models.dao.ITareaDao;
import cl.test.testtarea.models.entity.Tarea;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TareaServiceImplTest {

    @Mock
    private ITareaDao tareaDao;

    @InjectMocks
    private TareaServiceImpl tareaService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        // Mock de datos
        Tarea tarea1 = new Tarea();
        tarea1.setIdentificador(1L);
        tarea1.setDescripcion("Tarea 1");

        Tarea tarea2 = new Tarea();
        tarea2.setIdentificador(2L);
        tarea2.setDescripcion("Tarea 2");

        List<Tarea> tareas = Arrays.asList(tarea1, tarea2);

        when(tareaDao.findAll()).thenReturn(tareas);

        TareasDTO tareasDTO = tareaService.findAll();

        assertEquals(tareas.size(), tareasDTO.getTareas().size());
        assertEquals(tarea1.getDescripcion(), tareasDTO.getTareas().get(0).getDescripcion());
        assertEquals(tarea2.getDescripcion(), tareasDTO.getTareas().get(1).getDescripcion());
    }

    @Test
    void save() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("05-06-2023", formatter);

        Tarea tarea = new Tarea();
        tarea.setIdentificador(1L);
        tarea.setDescripcion("Tarea 1");
        tarea.setFechaCreacion(date);
        tarea.setVigente(true);

        CommonResponseDTO response = tareaService.save(tarea);
        assertEquals(200, response.getStatusCode());
        assertEquals("Tarea guardada exitosamente", response.getStatusMessage());
        verify(tareaDao).save(tarea);
    }

    @Test
    void update() {
    }

    @Test
    void findById() {
    }

    @Test
    void remover() {
    }
}