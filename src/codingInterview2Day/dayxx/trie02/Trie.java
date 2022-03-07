package codingInterview2Day.dayxx.trie02;

/**
 * @author xinchan
 * @version 1.0.1 2022-03-07
 */
class Trie {
    class TreeNode {
        private TreeNode[] dictTree;
        private boolean isEnd;
        public TreeNode() {
            dictTree = new TreeNode[26];
        }
    }

    private TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode cur = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (cur.dictTree[index] == null) {
                cur.dictTree[index] = new TreeNode();
            }
            cur = cur.dictTree[index];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = startsWithPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWithPrefix(prefix) != null;
    }

    private TreeNode startsWithPrefix(String prefix) {
        TreeNode cur = root;
        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.dictTree[index] == null) {
                return null;
            }
            cur = cur.dictTree[index];
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
