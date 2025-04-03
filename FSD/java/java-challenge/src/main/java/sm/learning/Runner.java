package sm.learning;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sm.learning.week1.ChallengeWeek1;

@Component
class Runner implements CommandLineRunner {

    private final ChallengeWeek1 challengeWeek1;
    //todo add lombock

    Runner(ChallengeWeek1 challengeWeek1) {
        this.challengeWeek1 = challengeWeek1;
    }

    @Override
    public void run(String... args) {
        challengeWeek1.displayBoard();
    }
}
