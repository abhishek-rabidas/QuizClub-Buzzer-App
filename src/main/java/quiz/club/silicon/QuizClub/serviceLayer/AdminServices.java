package quiz.club.silicon.QuizClub.serviceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.club.silicon.QuizClub.dao.entity.Player;
import quiz.club.silicon.QuizClub.dao.repository.PlayerRepository;

import java.util.List;

@Service
public class AdminServices {

    @Autowired
    private PlayerRepository playerRepository;

    public void resetGame() {
        playerRepository.deleteAll();
        System.out.println("All Players Erased");
    }

    public void resetBuzzers() {
        List<Player> players = playerRepository.findAll();
        for (Player player : players) {
            player.setBuzzerActive(false);
            playerRepository.save(player);
        }
        System.out.println("All Players Buzzers Reset");
    }
}
