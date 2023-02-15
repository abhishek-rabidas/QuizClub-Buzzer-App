package quiz.club.silicon.QuizClub.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quiz.club.silicon.QuizClub.serviceLayer.AdminServices;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminServices adminServices;

    @GetMapping("/resetGame")
    public void resetGame() {
        adminServices.resetGame();
    }

    @GetMapping("/resetBuzzers")
    public void resetBuzzers() {
        adminServices.resetBuzzers();
    }

    @GetMapping
    public String getActivePlayer() {
        return adminServices.getActivePlayer();
    }

}
