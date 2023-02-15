package quiz.club.silicon.QuizClub.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import quiz.club.silicon.QuizClub.dao.entity.Player;
import quiz.club.silicon.QuizClub.dto.SignUpRequest;
import quiz.club.silicon.QuizClub.serviceLayer.PlayerServices;

@RestController
@RequestMapping("/api/player")
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
    public void pressBuzzer(@PathVariable("id") String id) {
        playerServices.pressBuzzer(id);
    }


}
