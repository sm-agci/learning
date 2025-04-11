package sm.learning.week1;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class ChallengeWeek1 {
    private HashSet<BoardMember> boardMembers = new HashSet<>();

    @PostConstruct
    void populateMembers() {
        boardMembers.add(new BoardMember("Jan Kowalski", 0));
        boardMembers.add(new BoardMember("Paweł Michałowski", 0));
        boardMembers.add(new BoardMember("Ola Ułańska", 0));
        boardMembers.add(new BoardMember("Zosia Kowalska", 0));
    }
    public void displayBoard() {
        System.out.printf("%-30s-> %s\n","PARTICIPANT","SCORE");
        boardMembers.stream().forEach(x -> {
                    System.out.printf("%-30s", x.name());
                    System.out.printf("-> %d\n", x.score());
                }
        );
    }
}
