package sm.learning.week3.io;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DiabloDataCache {
    @Getter
    private List<String> prefixes;
    @Getter
    private List<String> items;
    @Getter
    private List<String> suffixes;

    private final DiabloDataFileReader dataFileReader;
    private final Random random = new Random();

   @PostConstruct
    public void populateCache() {
        prefixes = dataFileReader.getPrefixes();
        items = dataFileReader.getItems();
        suffixes = dataFileReader.getSuffixes();
    }

    public String getRandomPrefix() {
        return prefixes.get(random.nextInt(prefixes.size()));
    }

    public String getRandomItem() {
        return items.get(random.nextInt(items.size()));
    }

    public String getRandomSuffix() {
        return suffixes.get(random.nextInt(suffixes.size()));
    }
}
