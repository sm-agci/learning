package sm.learning;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sm.learning.week1.ChallengeWeek1;
import sm.learning.week2.ChallengeWeek2;
import sm.learning.week3.ChallengeWeek3;

@Component
@RequiredArgsConstructor
class Runner implements CommandLineRunner {

    private final ChallengeWeek1 challengeWeek1;
    private final ChallengeWeek2 challengeWeek2;
    private final ChallengeWeek3 challengeWeek3;

    @Override
    public void run(String... args) {
       // challengeWeek1.displayBoard();
      //  challengeWeek2.runCompany();
        challengeWeek3.run();
    }
}
