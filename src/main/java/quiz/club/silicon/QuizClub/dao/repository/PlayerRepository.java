package quiz.club.silicon.QuizClub.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import quiz.club.silicon.QuizClub.dao.entity.Player;

public interface PlayerRepository extends MongoRepository<Player, String> {
    Player findOneById(String id);
}
