package quiz.club.silicon.QuizClub.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import quiz.club.silicon.QuizClub.dto.SignUpRequest;
import quiz.club.silicon.QuizClub.serviceLayer.PlayerServices;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private PlayerServices playerServices;

    @PostMapping("/add")
    public void registerPlayer(@RequestBody SignUpRequest request) {
        playerServices.registerPlayer(request);
    }

    @PostMapping("/pressBuzzer/{id}")
    public void pressBuzzer(@PathVariable("id") String id) {
        playerServices.pressBuzzer(id);
    }


}
