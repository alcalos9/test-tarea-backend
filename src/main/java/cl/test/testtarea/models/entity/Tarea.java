package cl.test.testtarea.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tarea")
public class Tarea implements Serializable {
    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "identificador")
    private Long identificador;

    @Column(name = "descripcion")
    //@NotNull(message = "La descripción es obligatoria")
    //@Size(min = 1, message = "La descripción es obligatoria")
    private String descripcion;

    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private LocalDate fechaCreacion;

    @Column(name = "vigente")
    private Boolean vigente;

    public void validate() throws IllegalArgumentException {


        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("El campo descripcion es obligatorio");
        }

        if (fechaCreacion == null) {
            throw new IllegalArgumentException("El campo fechaCreacion es obligatorio");
        }

        if (vigente == null) {
            throw new IllegalArgumentException("El campo vigente es obligatorio");
        }
    }

}
