package sm.learning.week3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import sm.learning.week3.io.DiabloDataCache;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChallengeWeek3 {

    private final DiabloDataCache dataCache;
    private final DiabloItemGenerator itemGenerator;

    public void run() {
        ItemGenerator generatePrefixItemAndSuffix = () -> dataCache.getRandomPrefix() + " " + dataCache.getRandomItem() + " " + dataCache.getRandomSuffix();
        ItemGenerator generatePrefixAndItem = () -> dataCache.getRandomPrefix() + " " + dataCache.getRandomItem();
        ItemGenerator generateItemAndSuffix = () -> dataCache.getRandomItem() + " " + dataCache.getRandomSuffix();

        itemGenerator.createItems(generatePrefixItemAndSuffix, 10).forEach(x -> log.debug("Generated: {}", x));
        itemGenerator.createItems(generatePrefixAndItem, 5).forEach(x -> log.debug("Generated: {}", x));
        itemGenerator.createItems(generateItemAndSuffix, 5).forEach(x -> log.debug("Generated: {}", x));
    }
}
