package moodanalysis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmotionAnalyzer {

    private Map<String, int[]> emotionCounters; // This will store the counters for each emotion

    public EmotionAnalyzer() {
        // Initialize emotion counters
        this.emotionCounters = new HashMap<>();
        for (int i = 0; i < Constants.NUM_EMOTIONS; i++) {
            emotionCounters.put("Emotion " + i, new int[]{0});
        }
    }

    public void processWord(String word, String[] fileNames) throws IOException {
        for (int i = 0; i < Constants.NUM_EMOTIONS; i++) {
            if (LexiconReader.wordBelongsToEmotion(word, fileNames[i])) {
                emotionCounters.get("Emotion " + i)[0]++;
            }
        }
    }

    public void resetEmotionCounters() {
        for (Map.Entry<String, int[]> entry : emotionCounters.entrySet()) {
            entry.getValue()[0] = 0;
        }
    }

    public String getDominantEmotion() {
        String dominantEmotion = "";
        int maxCount = Integer.MIN_VALUE;

        for (Map.Entry<String, int[]> entry : emotionCounters.entrySet()) {
            String emotion = entry.getKey();
            int count = entry.getValue()[0];

            if (count > maxCount) {
                maxCount = count;
                dominantEmotion = emotion;
            }
        }

        return dominantEmotion;
 
	}

    public String analyzeMood(String userInput, String[] fileNames) throws IOException {
        for (String word : userInput.split("\\s+")) {
            for (int i = 0; i < Constants.NUM_EMOTIONS; i++) {
                if (LexiconReader.wordBelongsToEmotion(word, fileNames[i])) {
                    emotionCounters.get("Emotion " + i)[0]++;
                }
            }
        }
        return getDominantEmotion();
    }

}


