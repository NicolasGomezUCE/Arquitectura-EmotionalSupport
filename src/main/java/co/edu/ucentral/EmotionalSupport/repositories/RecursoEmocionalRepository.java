package co.edu.ucentral.EmotionalSupport.repositories;

import co.edu.ucentral.EmotionalSupport.model.RecursoEmocional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoEmocionalRepository extends JpaRepository<RecursoEmocional, Long> {
    List<RecursoEmocional> findByTipoRecurso(String tipoRecurso);
}