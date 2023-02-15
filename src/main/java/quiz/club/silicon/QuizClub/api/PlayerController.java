package quiz.club.silicon.QuizClub.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import quiz.club.silicon.QuizClub.dao.entity.Player;
import quiz.club.silicon.QuizClub.dto.SignUpRequest;
import quiz.club.silicon.QuizClub.serviceLayer.PlayerServices;

@RestController
@RequestMapping("/api/player")
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayerServices playerServices;

    @PostMapping("/add")
    public ResponseEntity<?> registerPlayer(@RequestBody SignUpRequest request) {
        try {
            return ResponseEntity.ok(playerServices.registerPlayer(request));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/pressBuzzer/{id}")
    public ResponseEntity<?> pressBuzzer(@PathVariable("id") String id) {
        try {
            playerServices.pressBuzzer(id);
            return ResponseEntity.ok().body("Buzzer Pressed");
        } catch (Exception e) {
            return ResponseEntity.status(888).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(playerServices.getPlayer(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
