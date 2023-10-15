package moodanalysis;


import java.util.ArrayList;
import java.util.List;

public class MusicPlaylistGenerator {

    // Define a mapping of emotions to lists of songs
	private static final List<String> angerSongs = new ArrayList<>();
	private static final List<String> anticipationSongs = new ArrayList<>();
	private static final List<String> disgustSongs = new ArrayList<>();
	private static final List<String> fearSongs = new ArrayList<>();
	private static final List<String> joySongs = new ArrayList<>();
    private static final List<String> negativeSongs = new ArrayList<>();
    private static final List<String> positiveSongs = new ArrayList<>();
    private static final List<String> sadnessSongs = new ArrayList<>();
    private static final List<String> surpriseSongs = new ArrayList<>();
    private static final List<String> trustSongs = new ArrayList<>();

    // Initialize the song lists
    static {
    	
    	// Anger Songs
    	angerSongs.add("Killing in the Name - Rage Against the Machine");
    	angerSongs.add("Bulls on Parade - Rage Against the Machine");
    	angerSongs.add("Break Stuff - Limp Bizkit");
        angerSongs.add("Down with the Sickness - Disturbed");
        angerSongs.add("Before I Forget - Slipknot");
        angerSongs.add("Chop Suey! - System of a Down");
        angerSongs.add("Given Up - Linkin Park");
        angerSongs.add("Du Hast - Rammstein");
        angerSongs.add("The Way I Am - Eminem");
        angerSongs.add("In the End - Linkin Park");
    	
    	// Anticipation Songs
    	anticipationSongs.add("Levels - Avicii");
    	anticipationSongs.add("Titanium - David Guetta ft. Sia");
    	anticipationSongs.add("Wake Me Up - Avicii");
        anticipationSongs.add("On the Floor - Jennifer Lopez ft. Pitbull");
        anticipationSongs.add("I Gotta Feeling - The Black Eyed Peas");
        anticipationSongs.add("Don't Stop Believin' - Journey");
        anticipationSongs.add("Shut Up and Dance - WALK THE MOON");
        anticipationSongs.add("Uptown Funk - Mark Ronson ft. Bruno Mars");
        anticipationSongs.add("Can't Stop the Feeling! - Justin Timberlake");
        anticipationSongs.add("Counting Stars - OneRepublic");
    	
    	// Disgust Songs
    	disgustSongs.add("Rape Me - Nirvana");
    	disgustSongs.add("Bodies - Drowning Pool");
    	disgustSongs.add("Nazi Punks Fuck Off - Dead Kennedys");
        disgustSongs.add("American Idiot - Green Day");
        disgustSongs.add("Holiday/Boulevard of Broken Dreams - Green Day");
        disgustSongs.add("Faint - Linkin Park");
        disgustSongs.add("The Way I Am - Eminem");
        disgustSongs.add("My Generation - Limp Bizkit");
        disgustSongs.add("Holiday in Cambodia - Dead Kennedys");
        disgustSongs.add("Crazy Train - Ozzy Osbourne");
    	
    	// Fear Songs
    	fearSongs.add("Estranged - Guns N' Roses");
    	fearSongs.add("Boulevard of Broken Dreams - Green Day");
    	fearSongs.add("Breathe Me - Sia");
        fearSongs.add("Mad World - Tears for Fears (or Gary Jules cover)");
        fearSongs.add("Comfortably Numb - Pink Floyd");
        fearSongs.add("Black - Pearl Jam");
        fearSongs.add("Behind Blue Eyes - The Who");
        fearSongs.add("Fade to Black - Metallica");
        fearSongs.add("Hurt - Johnny Cash");
        fearSongs.add("In the Air Tonight - Phil Collins");
    	
    	
    	// Joy Songs
    	joySongs.add("Happy - Pharrell Williams");
    	joySongs.add("Uptown Funk - Mark Ronson ft. Bruno Mars");
    	joySongs.add("Dancing Queen - ABBA");
    	joySongs.add("Can't Stop the Feeling! - Justin Timberlake");
    	joySongs.add("Shut Up and Dance - WALK THE MOON");
    	joySongs.add("I Gotta Feeling - The Black Eyed Peas");
    	joySongs.add("Hey Ya! - OutKast");
    	joySongs.add("I Want to Hold Your Hand - The Beatles");
    	joySongs.add("Dance Monkey - Tones and I");
    	joySongs.add("Here Comes the Sun - The Beatles");
    	
        // Negative Songs
    	negativeSongs.add("Everybody Hurts - R.E.M.");
    	negativeSongs.add("Hurt - Johnny Cash");
    	negativeSongs.add("Mad World - Tears for Fears (or Gary Jules cover)");
    	negativeSongs.add("Boulevard of Broken Dreams - Green Day");
    	negativeSongs.add("Black - Pearl Jam");
    	negativeSongs.add("Comfortably Numb - Pink Floyd");
    	negativeSongs.add("Behind Blue Eyes - The Who");
    	negativeSongs.add("In the Air Tonight - Phil Collins");
    	negativeSongs.add("Say Something - Justin Timberlake ft. Chris Stapleton");
    	negativeSongs.add("The Sound of Silence - Simon & Garfunkel");
        
        
        // Add more negative songs as needed

        // Positive Songs
    	positiveSongs.add("Here Comes the Sun - The Beatles");
    	positiveSongs.add("Imagine - John Lennon");
    	positiveSongs.add("Don't Stop Believin' - Journey");
    	positiveSongs.add("Hey Jude - The Beatles");
    	positiveSongs.add("Wonderwall - Oasis");
    	positiveSongs.add("What a Wonderful World - Louis Armstrong");
        positiveSongs.add("I Will Survive - Gloria Gaynor");
        positiveSongs.add("Lean on Me - Bill Withers");
        positiveSongs.add("Three Little Birds - Bob Marley & The Wailers");
        positiveSongs.add("Hallelujah - Leonard Cohen");
        // Add more positive songs as needed

        // Sadness Songs
        sadnessSongs.add("Hurt - Johnny Cash");
        sadnessSongs.add("Nothing Compares 2 U - Sinead O'Connor");
        sadnessSongs.add("Mad World - Tears for Fears (or Gary Jules cover)");
        sadnessSongs.add("Yesterday - The Beatles");
        sadnessSongs.add("Black - Pearl Jam");
        sadnessSongs.add("Creep - Radiohead");
        sadnessSongs.add("I'm Not in Love - 10cc");
        sadnessSongs.add("Everybody Hurts - R.E.M.");
        sadnessSongs.add("Alone Again (Naturally) - Gilbert O'Sullivan");
        sadnessSongs.add("Eleanor Rigby - The Beatles");
        // Add more sadness songs as needed

        // Surprise Songs
        surpriseSongs.add("Bohemian Rhapsody - Queen");
        surpriseSongs.add("A Day in the Life - The Beatles");
        surpriseSongs.add("November Rain - Guns N' Roses");
        surpriseSongs.add("Stairway to Heaven - Led Zeppelin");
        surpriseSongs.add("Hotel California - Eagles");
        surpriseSongs.add("Time - Pink Floyd");
        surpriseSongs.add("Knights of Cydonia - Muse");
        surpriseSongs.add("Paradise by the Dashboard Light - Meat Loaf");
        surpriseSongs.add("Light My Fire - The Doors");
        surpriseSongs.add("Boys Don't Cry - The Cure");
        // Add more surprise songs as needed

        // Trust Songs
        trustSongs.add("Lean on Me - Bill Withers");
        trustSongs.add("With a Little Help from My Friends - The Beatles");
        trustSongs.add("We Will Rock You - Queen");
        trustSongs.add("What a Wonderful World - Louis Armstrong");
        trustSongs.add("Here Comes the Sun - The Beatles");
        trustSongs.add("Stand by Me - Ben E. King");
        trustSongs.add("Bridge Over Troubled Water - Simon & Garfunkel");
        trustSongs.add("I Will Always Love You - Whitney Houston");
        trustSongs.add("True Colors - Cyndi Lauper");
        trustSongs.add("You've Got a Friend - James Taylor");
        // Add more trust songs as needed
    }

    // Method to generate a playlist based on the dominant emotion
    public static List<String> generatePlaylist(String dominantEmotion) {
        List<String> playlist = new ArrayList<>();

        // Choose songs based on the dominant emotion
        switch (dominantEmotion) {
            case "Emotion 0":
                playlist.addAll(angerSongs);
                break;
            case "Emotion 1":
                playlist.addAll(anticipationSongs);
                break;
            case "Emotion 2":
                playlist.addAll(disgustSongs);
                break;
            case "Emotion 3":
                playlist.addAll(fearSongs);
                break;
            case "Emotion 4":
                playlist.addAll(joySongs);
                break;
            case "Emotion 5":
                playlist.addAll(negativeSongs);
                break;
            case "Emotion 6":
                playlist.addAll(positiveSongs);
                break;
            case "Emotion 7":
                playlist.addAll(sadnessSongs);
                break;
            case "Emotion 8":
                playlist.addAll(surpriseSongs);
                break;
            case "Emotion 9":
                playlist.addAll(trustSongs);
                break;
            default:
                System.out.println("Invalid emotion detected.");
        }

        return playlist;
    }
}
