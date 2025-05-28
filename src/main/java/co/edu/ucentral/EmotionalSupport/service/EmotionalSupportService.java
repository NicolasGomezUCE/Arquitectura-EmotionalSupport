package co.edu.ucentral.EmotionalSupport.service;

import co.edu.ucentral.EmotionalSupport.model.Comunidad;
import co.edu.ucentral.EmotionalSupport.model.RecursoEmocional;
import co.edu.ucentral.EmotionalSupport.repositories.ComunidadRepository;
import co.edu.ucentral.EmotionalSupport.repositories.RecursoEmocionalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmotionalSupportService {

    private final ComunidadRepository comunidadRepository;
    private final RecursoEmocionalRepository recursoRepository;

    public EmotionalSupportService(ComunidadRepository comunidadRepository, RecursoEmocionalRepository recursoRepository) {
        this.comunidadRepository = comunidadRepository;
        this.recursoRepository = recursoRepository;
    }

    /**
     * POST /comunidad/publicar: Publicar mensaje en la comunidad.
     */
    public Comunidad publishCommunityMessage(Long userId, String message) {
        Comunidad post = new Comunidad();
        post.setUsuarioId(userId);
        post.setMensaje(message);
        post.setFechaPublicacion(LocalDate.now());
        return comunidadRepository.save(post);
    }

    /**
     * GET /comunidad/{usuario_id}: Obtener las interacciones y publicaciones de un usuario.
     * This will return all posts made by a specific user.
     */
    public List<Comunidad> getUserCommunityPosts(Long userId) {
        return comunidadRepository.findByUsuarioIdOrderByFechaPublicacionDesc(userId);
    }

    /**
     * GET /comunidad/all: Obtener todas las publicaciones de la comunidad (for viewing interactions).
     * Added this for a general view of the community feed.
     */
    public List<Comunidad> getAllCommunityPosts() {
        return comunidadRepository.findAllByOrderByFechaPublicacionDesc();
    }

    /**
     * GET /recursos/emocionales: Acceder a herramientas de relajación y bienestar.
     */
    public List<RecursoEmocional> getAllEmotionalResources() {
        return recursoRepository.findAll();
    }

    // Future consideration for "Solicitar contacto con profesional de salud mental"
    // This would likely involve a new table for professional requests or integration
    // with an external professional service. For now, it's out of scope.

    // Future consideration for "Recibir notificaciones de apoyo emocional"
    // This could be integrated with your existing 'ComunicacionesProfesor' if professors send it,
    // or a new 'NotificacionesEmocionales' table if automated.
}