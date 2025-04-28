package sm.learning.week3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sm.learning.week3.io.DiabloDataCache;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
class DiabloItemGenerator {

//    private final DiabloDataCache dataCache;
//
//    public ItemGenerator getPrefixItemAndSuffixGenerator() {
//        return () -> dataCache.getRandomPrefix() + " " +
//                dataCache.getRandomItem() + " " +
//                dataCache.getRandomSuffix();
//    }
//    public ItemGenerator getPrefixAndItemGenerator() {
//        return () -> dataCache.getRandomPrefix() + " " +
//                dataCache.getRandomItem();
//    }
//    public ItemGenerator getItemAndSuffixGenerator() {
//        return () -> dataCache.getRandomItem() + " " +
//                dataCache.getRandomSuffix();
//    }
    public List<String> createItems(ItemGenerator generator, int n) {
        List<String> items = new ArrayList<>();
        do {
            items.add(generator.generate());
        } while (--n > 0);
        return items;
    }
}
