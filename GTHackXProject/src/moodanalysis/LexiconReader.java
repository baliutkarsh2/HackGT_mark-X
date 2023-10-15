/*
 * This class will read and parse the lexicon files, creating the data structures for 
 * emotion analysis.
 */

package moodanalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LexiconReader {

    public static Map<String, boolean[]> readLexicon(String fileName) throws IOException {
        Map<String, boolean[]> emotionLexicon = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\t");
            String word = parts[0];
            boolean[] emotions = new boolean[parts.length - 1];
            for (int i = 1; i < parts.length; i++) {
                emotions[i - 1] = Integer.parseInt(parts[i]) == 1;
            }
            emotionLexicon.put(word, emotions);
        }
        reader.close();

        return emotionLexicon;
    }

    public static boolean wordBelongsToEmotion(String word, String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals(word)) {
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;
    }
}
