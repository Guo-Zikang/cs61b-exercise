import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

/**
 * Created by Jenny Huang on 3/12/19.
 */
public class TestMyTrieSet {

    // assumes add/contains work
    @Test
    public void sanityClearTest() {
        MyTrieSet t = new MyTrieSet();
        for (int i = 0; i < 455; i++) {
            t.add("hi" + i);
            //make sure put is working via contains
            assertTrue(t.contains("hi" + i));
        }
        t.clear();
        for (int i = 0; i < 455; i++) {
            assertFalse(t.contains("hi" + i));
        }
    }

    // assumes add works
    @Test
    public void sanityContainsTest() {
        MyTrieSet t = new MyTrieSet();
        assertFalse(t.contains("waterYouDoingHere"));
        t.add("waterYouDoingHere");
        assertTrue(t.contains("waterYouDoingHere"));
    }

    // assumes add works
    @Test
    public void sanityPrefixTest() {
        String[] saStrings = new String[]{"same", "sam", "sad", "sap"};
        String[] otherStrings = new String[]{"a", "awls", "hello"};

        MyTrieSet t = new MyTrieSet();
        for (String s: saStrings) {
            t.add(s);
        }
        for (String s: otherStrings) {
            t.add(s);
        }

        List<String> keys = t.keysWithPrefix("sa");
        for (String s: saStrings) {
            assertTrue(keys.contains(s));
        }
        for (String s: otherStrings) {
            assertFalse(keys.contains(s));
        }
    }

    @Test
    public void testLongestPrefixOf() {
        MyTrieSet trie;
        trie = new MyTrieSet();
        trie.add("apple");
        trie.add("app");
        trie.add("apricot");
        trie.add("banana");
        trie.add("band");
        assertEquals("app", trie.longestPrefixOf("applause"));
        assertEquals("app", trie.longestPrefixOf("application"));
        assertEquals("apricot", trie.longestPrefixOf("apricots"));
        assertEquals("", trie.longestPrefixOf("ban"));
        assertEquals("band", trie.longestPrefixOf("bandit"));
        assertEquals("banana", trie.longestPrefixOf("banana"));
        assertEquals("", trie.longestPrefixOf("cat"));
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestMyTrieSet.class);
    }

}
