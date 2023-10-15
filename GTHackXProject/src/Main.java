import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import moodanalysis.EmotionAnalyzer;
import moodanalysis.LexiconReader;
import moodanalysis.MusicPlaylistGenerator;

public class Main {

    public static void main(String[] args) {
        try {
            // List of file names for the emotions
            String[] fileNames = {
                "/Users/tanay/Downloads/NRC-Emotion-Lexicon/OneFilePerEmotion/anger-NRC-Emotion-Lexicon.txt",
                "/Users/tanay/Downloads/NRC-Emotion-Lexicon/OneFilePerEmotion/anticipation-NRC-Emotion-Lexicon.txt",
                "/Users/tanay/Downloads/NRC-Emotion-Lexicon/OneFilePerEmotion/disgust-NRC-Emotion-Lexicon.txt",
                "/Users/tanay/Downloads/NRC-Emotion-Lexicon/OneFilePerEmotion/fear-NRC-Emotion-Lexicon.txt",
                "/Users/tanay/Downloads/NRC-Emotion-Lexicon/OneFilePerEmotion/joy-NRC-Emotion-Lexicon.txt",
                "/Users/tanay/Downloads/NRC-Emotion-Lexicon/OneFilePerEmotion/negative-NRC-Emotion-Lexicon.txt",
                "/Users/tanay/Downloads/NRC-Emotion-Lexicon/OneFilePerEmotion/positive-NRC-Emotion-Lexicon.txt",
                "/Users/tanay/Downloads/NRC-Emotion-Lexicon/OneFilePerEmotion/sadness-NRC-Emotion-Lexicon.txt",
                "/Users/tanay/Downloads/NRC-Emotion-Lexicon/OneFilePerEmotion/surprise-NRC-Emotion-Lexicon.txt",
                "/Users/tanay/Downloads/NRC-Emotion-Lexicon/OneFilePerEmotion/trust-NRC-Emotion-Lexicon.txt"
            };


         // Initialize the EmotionAnalyzer
            EmotionAnalyzer emotionAnalyzer = new EmotionAnalyzer();

            // Step 3: Allow the user to input text
            Scanner scanner = new Scanner(System.in);
            boolean exitRequested = false;

            while (true) {
                System.out.println("Please enter the text you want to analyze (type 'exit' to quit):");
                String inputText = scanner.nextLine();

                if (inputText.equals("exit")) {
                    exitRequested = true;
                    break;
                }

                // Step 4: Tokenize the input and process words
                String[] words = inputText.split("\\s+");
                for (String word : words) {
                    emotionAnalyzer.processWord(word, fileNames);
                }
            }

            if (exitRequested) {
                // Step 5: Get the dominant emotion
                String dominantEmotion = emotionAnalyzer.getDominantEmotion();

                // Display personalized message
                displayPersonalizedMessage(dominantEmotion);

                // Step 6: Generate and display the playlist
                List<String> playlist = MusicPlaylistGenerator.generatePlaylist(dominantEmotion);
                System.out.println("Generated Playlist:");
                for (String song : playlist) {
                    System.out.println(song);
                }

                // Reset emotion counters for next input
                emotionAnalyzer.resetEmotionCounters();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void displayPersonalizedMessage(String dominantEmotion) {
        switch (dominantEmotion) {
            case "Emotion 0":
                System.out.println("\nWelcome! It seems like you're experiencing a surge of energy and intensity, which can happen to all of us. It's perfectly normal to feel this way sometimes. Let's explore some music together that might resonate with your current mood.\n");
            	break;
            case "Emotion 1":
                System.out.println("\nHello! It looks like you're feeling excited and looking forward to something. That's a wonderful state to be in! Anticipation can bring a sense of thrill and eagerness. Let's find some music that complements your sense of anticipation.\n");
                break;
            case "Emotion 2":
                System.out.println("\nHi there! It appears you're having a reaction to something that doesn't sit well with you. We all experience this from time to time, and it's a natural part of human emotion. Let's discover some music that might help you process these feelings.\n");
                break;
            case "Emotion 3":
                System.out.println("\nHey! It seems like you're feeling a bit uneasy or apprehensive, which is something we all experience. It's completely okay. Fear is a normal emotion, and it's a sign that our body is preparing to face a challenge. Let's explore some music that might offer comfort or a sense of empowerment.\n");
                break;
            case "Emotion 4":
                System.out.println("\nHi! You're radiating positivity and happiness, which is a wonderful state to be in! It's fantastic to feel this way. Joy is a beautiful emotion that can brighten up any moment. Let's dive into some music that can enhance this joyful moment even further.\n");
                break;
            case "Emotion 5":
                System.out.println("\nHello! It seems like you're having a bit of a rough time, and that's okay. Remember, it's absolutely fine to feel this way, and you're not alone. There's support available, and it's important to take care of yourself. Let's see if some music can provide a little comfort or a new perspective.\n");
                break;
            case "Emotion 6":
                System.out.println("\nWelcome! You're in a great state of mind, radiating positivity. Embrace this positivity! Positive emotions can bring a sense of lightness and contentment. Let's explore some music that can amplify these good vibes even more.\n");
                break;
            case "Emotion 7":
                System.out.println("\nHi there. It looks like you're feeling a bit down or reflective, which is something we all go through. Sadness is a natural emotion and an important part of processing our experiences. Let's find some music that might offer solace or resonate with your emotions.\n");
                break;
            case "Emotion 8":
                System.out.println("\nHey there! It looks like life just threw you a curveball, bringing a dash of unexpected excitement. Surprises can be a delightful reminder of life's unpredictability. Let's find some music that complements this unique and thrilling moment, adding an extra layer of magic to it!\n");
                break;
            case "Emotion 9":
                System.out.println("\nHello! You're in a state of calm and assurance, which is a wonderful place to be. Trusting in oneself and others is a valuable quality. It brings a sense of security and connection. Let's explore some music that resonates with this sense of trust.\n");
                break;
            default:
                System.out.println("\nWelcome! Let's find the perfect music for your mood!\n");
                break;
        }
    }
}




