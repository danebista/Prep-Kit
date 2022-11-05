class Trie {
    boolean endOfWord;
    Trie[] children;

    Trie() {
        endOfWord = false;
        children = new Trie[26];
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }

    public void insert(String word) {
        Trie curr = this;
        for (Character c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null)
                curr.children[index] = new Trie();
            curr = curr.children[index];
        }
        curr.endOfWord = true;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> result = new HashSet();
        List<String> results = new ArrayList();
        if (words.length == 0)
            return results;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(board, i, j, trie, result, "");
            }
        }

        return new ArrayList(result);
    }

    public void helper(char[][] board, int i, int j, Trie trie, HashSet<String> result, String s) {

        if (board[i][j] == '$')
            return;
        Character curr = board[i][j];
        Trie current = trie.children[board[i][j] - 'a'];
        board[i][j] = '$';
        if (current == null) {
            board[i][j] = curr;
            return;
        }
        String ss = s + curr;
        if (current.endOfWord)
            result.add(ss);
        if (i < board.length - 1)
            helper(board, i + 1, j, current, result, ss);
        if (i > 0)
            helper(board, i - 1, j, current, result, ss);
        if (j < board[0].length - 1)
            helper(board, i, j + 1, current, result, ss);
        if (j > 0)
            helper(board, i, j - 1, current, result, ss);

        board[i][j] = curr;
    }
}
