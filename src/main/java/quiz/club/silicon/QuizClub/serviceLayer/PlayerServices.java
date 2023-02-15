package quiz.club.silicon.QuizClub.serviceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.club.silicon.QuizClub.dao.entity.Player;
import quiz.club.silicon.QuizClub.dao.repository.PlayerRepository;
import quiz.club.silicon.QuizClub.dto.SignUpRequest;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlayerServices {

    @Autowired
    private PlayerRepository playerRepository;

    public Player registerPlayer(SignUpRequest request) {
        Player player = new Player();
        player.setName(request.getName());
        player.setBuzzerActive(false);
        player.setRegistrationTimeStamp(LocalDateTime.now());
        System.out.println(player.getName() + " registered successfully");
        return playerRepository.save(player);
    }

    public Player getPlayer(String id) {
        return playerRepository.findOneById(id);
    }

    public void pressBuzzer(String id) {
        if (playerRepository.findOneByIsBuzzerActiveTrue() == null) {
            Player player = playerRepository.findOneById(id);
            player.setBuzzerActive(true);
            playerRepository.save(player);
            System.out.println(player.getName() + " pressed buzzer");
        } else {
            throw new RuntimeException("Buzzer Already Pressed");
        }
    }
}
