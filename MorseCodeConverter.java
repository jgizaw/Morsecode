import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * MorseCodeConverter class that converts Morse code to English using MorseCodeTree.
 * Provides methods to convert Morse code from a file or string to English.
 * 
 * @author Joshua Gizaw
 */
public class MorseCodeConverter {

    /**
     * Converts a file of Morse code into English.
     * 
     * @param codeFile the file containing Morse code
     * @return the English translation of the file
     * @throws FileNotFoundException if the file is not found
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(codeFile);
        StringBuilder morseCode = new StringBuilder();
        while (scanner.hasNext()) {
            morseCode.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return convertToEnglish(morseCode.toString().trim());
    }

    /**
     * Converts a string of Morse code into English.
     * 
     * @param code the Morse code
     * @return the English translation
     */
    public static String convertToEnglish(String code) {
        MorseCodeTree tree = new MorseCodeTree();
        String[] words = code.split(" / ");
        StringBuilder englishText = new StringBuilder();

        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                englishText.append(tree.fetch(letter));
            }
            englishText.append(" ");
        }

        return englishText.toString().trim();
    }

    /**
     * Returns a string with all the data in the tree in LNR order with a space in between them.
     * 
     * @return the data in the tree in LNR order separated by a space
     */
    public static String printTree() {
        MorseCodeTree tree = new MorseCodeTree();
        return String.join(" ", tree.toArrayList());
    }
}
