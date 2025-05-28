package co.edu.ucentral.EmotionalSupport.controller; // Adjust package name

import co.edu.ucentral.EmotionalSupport.model.Comunidad;
import co.edu.ucentral.EmotionalSupport.model.RecursoEmocional;
import co.edu.ucentral.EmotionalSupport.service.EmotionalSupportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/") // Base path for this microservice, individual endpoints will be prefixed
public class EmotionalSupportController {

    private final EmotionalSupportService service;

    public EmotionalSupportController(EmotionalSupportService service) {
        this.service = service;
    }

    // POST /comunidad/publicar: Publicar mensaje en la comunidad.
    @PostMapping("/comunidad/publicar")
    public ResponseEntity<Comunidad> publishMessage(@RequestBody Map<String, String> request) {
        Long userId = Long.parseLong(request.get("userId")); // Get userId from the request body
        String message = request.get("message");

        if (userId == null || message == null || message.trim().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Comunidad newPost = service.publishCommunityMessage(userId, message);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    // GET /comunidad/{usuario_id}: Obtener las interacciones y publicaciones de un usuario.
    @GetMapping("/comunidad/{userId}")
    public ResponseEntity<List<Comunidad>> getUserPosts(@PathVariable Long userId) {
        List<Comunidad> posts = service.getUserCommunityPosts(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // GET /comunidad/all: Obtener todas las publicaciones de la comunidad. (Added for general feed)
    @GetMapping("/comunidad/all")
    public ResponseEntity<List<Comunidad>> getAllCommunityPosts() {
        List<Comunidad> posts = service.getAllCommunityPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // GET /recursos/emocionales: Acceder a herramientas de relajación y bienestar.
    @GetMapping("/recursos/emocionales")
    public ResponseEntity<List<RecursoEmocional>> getEmotionalResources() {
        List<RecursoEmocional> resources = service.getAllEmotionalResources();
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }
}