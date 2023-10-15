package moodanalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmotionDataProcessor {

    private Map<String, Boolean> wordEmotionMap;

    public EmotionDataProcessor(String filePath) {
        wordEmotionMap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                String word = parts[0];
                boolean conveysEmotion = Integer.parseInt(parts[1]) == 1;
                wordEmotionMap.put(word, conveysEmotion);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean doesWordConveyEmotion(String word) {
        return wordEmotionMap.containsKey(word) && wordEmotionMap.get(word);
    }
}
