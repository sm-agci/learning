package sm.learning.week3.io;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
class DiabloDataFileReader {
    private final String resourcePath = "ch3/";
    private final String itemFileName = "item.txt";
    private final String prefixFileName = "prefix.txt";
    private final String suffixFileName = "suffix.txt";

    public List<String> getItems() {
        return readFile(itemFileName);
    }

    public List<String> getPrefixes() {
        return readFile(prefixFileName);
    }

    public List<String> getSuffixes() {
        return readFile(suffixFileName);
    }

    private List<String> readFile(String fileName) {
        try {
            Path path = ResourceUtils.getFile("classpath:" + resourcePath + fileName).toPath();
            List<String> lines = Files.readAllLines(path);
            return lines;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
