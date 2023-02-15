package quiz.club.silicon.QuizClub.serviceLayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.club.silicon.QuizClub.dao.entity.Player;
import quiz.club.silicon.QuizClub.dao.repository.PlayerRepository;

import java.util.List;

@Service
public class AdminServices {

    final Logger logger = LoggerFactory.getLogger(AdminServices.class);

    @Autowired
    private PlayerRepository playerRepository;

    public void resetGame() {
        playerRepository.deleteAll();
        logger.info("All Players Erased");
    }

    public void resetBuzzers() {
        List<Player> players = playerRepository.findAll();
        for (Player player : players) {
            player.setBuzzerActive(false);
            playerRepository.save(player);
        }
        logger.info("All Players Buzzers Reset");
    }
}
