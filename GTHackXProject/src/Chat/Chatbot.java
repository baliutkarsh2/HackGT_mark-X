package Chat;

import java.util.List;
import java.util.Scanner;

import moodanalysis.EmotionAnalyzer;
import moodanalysis.MusicPlaylistGenerator;

public class Chatbot {
    public static void main(String[] args) {
    	
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
    	 
        Scanner scanner = new Scanner(System.in);
        EmotionAnalyzer emotionAnalyzer = new EmotionAnalyzer();

        while (true) {
            System.out.println("Please enter your message (type 'exit' to quit):");
            String userInput = scanner.nextLine();

            if (userInput.equals("exit")) {
                break;
            }

            String dominantEmotion = emotionAnalyzer.getDominantEmotion();
            String userExperienceMessage = generateUserExperienceMessage(dominantEmotion);
            List<String> playlist = MusicPlaylistGenerator.generatePlaylist(dominantEmotion);

            System.out.println(userExperienceMessage);
            System.out.println("Generated Playlist:");
            for (String song : playlist) {
                System.out.println(song);
            }
        }
    }

    private static String generateUserExperienceMessage(String dominantEmotion) {
        switch (dominantEmotion) {
        case "Emotion 0":
            return ("\nWelcome! It seems like you're experiencing a surge of energy and intensity, which can happen to all of us. It's perfectly normal to feel this way sometimes. Let's explore some music together that might resonate with your current mood.\n");
            
        case "Emotion 1":
            return ("\nHello! It looks like you're feeling excited and looking forward to something. That's a wonderful state to be in! Anticipation can bring a sense of thrill and eagerness. Let's find some music that complements your sense of anticipation.\n");
            
        case "Emotion 2":
            return ("\nHi there! It appears you're having a reaction to something that doesn't sit well with you. We all experience this from time to time, and it's a natural part of human emotion. Let's discover some music that might help you process these feelings.\n");
            
        case "Emotion 3":
            return ("\nHey! It seems like you're feeling a bit uneasy or apprehensive, which is something we all experience. It's completely okay. Fear is a normal emotion, and it's a sign that our body is preparing to face a challenge. Let's explore some music that might offer comfort or a sense of empowerment.\n");
            
        case "Emotion 4":
            return ("\nHi! You're radiating positivity and happiness, which is a wonderful state to be in! It's fantastic to feel this way. Joy is a beautiful emotion that can brighten up any moment. Let's dive into some music that can enhance this joyful moment even further.\n");
            
        case "Emotion 5":
            return ("\nHello! It seems like you're having a bit of a rough time, and that's okay. Remember, it's absolutely fine to feel this way, and you're not alone. There's support available, and it's important to take care of yourself. Let's see if some music can provide a little comfort or a new perspective.\n");
            
        case "Emotion 6":
            return ("\nWelcome! You're in a great state of mind, radiating positivity. Embrace this positivity! Positive emotions can bring a sense of lightness and contentment. Let's explore some music that can amplify these good vibes even more.\n");
            
        case "Emotion 7":
            return ("\nHi there. It looks like you're feeling a bit down or reflective, which is something we all go through. Sadness is a natural emotion and an important part of processing our experiences. Let's find some music that might offer solace or resonate with your emotions.\n");
            
        case "Emotion 8":
            return ("\nHey there! It looks like life just threw you a curveball, bringing a dash of unexpected excitement. Surprises can be a delightful reminder of life's unpredictability. Let's find some music that complements this unique and thrilling moment, adding an extra layer of magic to it!\n");
            
        case "Emotion 9":
            return ("\nHello! You're in a state of calm and assurance, which is a wonderful place to be. Trusting in oneself and others is a valuable quality. It brings a sense of security and connection. Let's explore some music that resonates with this sense of trust.\n");
            
        default:
            return ("\nWelcome! Let's find the perfect music for your mood!\n");
            
    }

    }
}
