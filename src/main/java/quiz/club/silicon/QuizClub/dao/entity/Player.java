package quiz.club.silicon.QuizClub.dao.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
public class Player {
    @MongoId
    private String id;
    private String name;
    private boolean isBuzzerActive;
    private LocalDateTime registrationTimeStamp;
}
