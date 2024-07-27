import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTrieSet implements TrieSet61B {

    private Node root;

    private static class Node {
        private boolean isKey;
        private char c;
        private HashMap<Character, Node> map;

        private Node(char c, boolean blue) {
            this.c = c;
            isKey = blue;
            map = new HashMap<>();
        }
    }

    public MyTrieSet() {
        root = new Node(' ', false);
    }

    @Override
    public void clear() {
        root = new Node(' ', false);
    }

    @Override
    public boolean contains(String key) {
        if (key == null || key.length() < 1) {
            return false;
        }
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            curr = curr.map.get(c);
            if (curr == null) {
                return false;
            }
        }
        return curr.isKey;
    }

    @Override
    public void add(String key) {
        if (key == null || key.length() < 1) {
            return;
        }
        Node curr = root;
        for (int i = 0, n = key.length(); i < n; i++) {
            char c = key.charAt(i);
            if (!curr.map.containsKey(c)) {
                curr.map.put(c, new Node(c, false));
            }
            curr = curr.map.get(c);
        }
        curr.isKey = true;
    }

    public List<String> collect() {
        List<String> lst = new ArrayList<>();
        for (char c : root.map.keySet()) {
            colHelp(String.valueOf(c), lst, root.map.get(c));
        }
        return lst;
    }

    /** 递归调用，发现字符串。 */
    private void colHelp(String s, List<String> lst, Node node) {
        if (node.isKey) {
            lst.add(s);
        }
        for (char c : node.map.keySet()) {
            colHelp(s + c, lst, node.map.get(c));
        }
    }

    private Node findPrefix(String prefix) {
        if (prefix == null || prefix.length() < 1) {
            return null;
        }
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            curr = curr.map.get(c);
            if (curr == null) {
                return null;
            }
        }
        return curr;
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        Node node = findPrefix(prefix);
        if (node == null) {
            return null;
        }
        List<String> lst = new ArrayList<>();
        for (char ch : node.map.keySet()) {
            colHelp(prefix + ch, lst, node.map.get(ch));
        }
        return lst;
    }

    @Override
    public String longestPrefixOf(String key) {
        if (key == null || key.length() < 1) {
            return null;
        }
        Node curr = root;
        int maxLength = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            curr = curr.map.get(c);
            if (curr == null) {
                break;
            }
            if (curr.isKey) {
                maxLength = i + 1;
            }
        }
        return key.substring(0, maxLength);
    }
}
