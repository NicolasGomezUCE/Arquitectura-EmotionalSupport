package co.edu.ucentral.EmotionalSupport.repositories;

import co.edu.ucentral.EmotionalSupport.model.Comunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComunidadRepository extends JpaRepository<Comunidad, Long> {
    List<Comunidad> findByUsuarioIdOrderByFechaPublicacionDesc(Long usuarioId);
    List<Comunidad> findAllByOrderByFechaPublicacionDesc(); // To see all community posts
}