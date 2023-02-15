package quiz.club.silicon.QuizClub.serviceLayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.club.silicon.QuizClub.dao.entity.Player;
import quiz.club.silicon.QuizClub.dao.repository.PlayerRepository;
import quiz.club.silicon.QuizClub.dto.SignUpRequest;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlayerServices {

    final Logger logger = LoggerFactory.getLogger(PlayerServices.class);

    @Autowired
    private PlayerRepository playerRepository;

    public void registerPlayer(SignUpRequest request) {
        Player player = new Player();
        player.setName(request.getName());
        player.setBuzzerActive(false);
        player.setRegistrationTimeStamp(LocalDateTime.now());
        playerRepository.save(player);
        logger.info("{} registered successfully", player.getName());
    }

    public void pressBuzzer(String id) {
        List<Player> players = playerRepository.findAll();
        for (Player player : players) {
            player.setBuzzerActive(false);
            playerRepository.save(player);
        }

        Player player = playerRepository.findOneById(id);
        player.setBuzzerActive(true);
        playerRepository.save(player);
        logger.info("{} pressed Buzzer", player.getName());
    }
}
