import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class MorsecodeConverterTest_Student {

    @Test
    public void testConvertToEnglishString() {
        String morseCode = "--. .. ...- . / -- . / -.-- --- ..- .-. / .- -. ... .-- . .-. / -.. ---";
        String expected = "give me your answer do";
        String actual = MorseCodeConverter.convertToEnglish(morseCode);
        assertEquals(actual, expected, "The Morse code string was not converted correctly.");
    }

    @Test
    public void testConvertToEnglishFileDaisy() throws FileNotFoundException {
        File file = new File("src/Daisy.txt");
        String expected = "give me your answer do";
        String actual = MorseCodeConverter.convertToEnglish(file);
        assertEquals( actual, expected, "The Morse code file Daisy.txt was not converted correctly.");
    }

    @Test
    public void testConvertToEnglishFileDaisyDaisy() throws FileNotFoundException {
        File file = new File("src/DaisyDaisy.txt");
        String expected = "im half crazy all for the love of you";
        String actual = MorseCodeConverter.convertToEnglish(file);
        assertEquals(actual, expected, "The Morse code file DaisyDaisy.txt was not converted correctly.");
    }
}
