package co.edu.ucentral.EmotionalSupport.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "comunidad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id")
    private Long usuarioId; // ID of the user who posted

    @Column(name = "mensaje", columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "fecha_publicacion")
    private LocalDate fechaPublicacion;
}