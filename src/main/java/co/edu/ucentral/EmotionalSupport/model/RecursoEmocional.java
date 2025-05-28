package co.edu.ucentral.EmotionalSupport.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "recursos_emocionales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecursoEmocional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recurso_nombre", length = 100)
    private String recursoNombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "tipo_recurso", length = 50)
    private String tipoRecurso; // e.g., "ejercicio de respiración", "mindfulness"

    @Column(name = "fecha_administracion")
    private LocalDate fechaAdministracion;

}
