package cl.test.testtarea.models.dao;

import cl.test.testtarea.models.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITareaDao extends JpaRepository<Tarea, Long> {
}
