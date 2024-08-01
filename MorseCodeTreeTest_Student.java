import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MorseCodeTreeTest_Student {

    private MorseCodeTree tree;

    @BeforeEach
    public void setUp() {
        tree = new MorseCodeTree();
    }

    @Test
    public void testFetch() {
        assertEquals("e", tree.fetch("."));
        assertEquals("t", tree.fetch("-"));
        assertEquals("i", tree.fetch(".."));
        assertEquals("a", tree.fetch(".-"));
        assertEquals("s", tree.fetch("..."));
        assertEquals("p", tree.fetch(".--."));
        assertEquals("z", tree.fetch("--.."));
    }

}
