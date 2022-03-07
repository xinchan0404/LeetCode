package codingInterview2Day.dayxx.trie;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-07
 */
class Trie {
    private Trie[] tries;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        tries = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (node.tries[index] == null) {
                node.tries[index] = new Trie();
            }
            node = node.tries[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (node.tries[index] == null) {
                return false;
            }
            node = node.tries[index];
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.tries[index] == null) {
                return false;
            }
            node = node.tries[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
