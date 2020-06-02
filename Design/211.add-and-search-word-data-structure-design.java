class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endWord;
        TrieNode(){
            children = new HashMap<Character, TrieNode>();
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();    
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if(node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                TrieNode newNode = new TrieNode();
                node.children.put(ch, newNode);
                node = newNode;
            }
        }
        node.endWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode node) {
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if(!node.children.containsKey(ch)) {
                if(ch == '.') {
                    for (Character key : node.children.keySet()) {
                        if (search(word.substring(i+1, word.length()), node.children.get(key))) {
                            return true;
                        }
                    }
                }
                return false;
            }
            node = node.children.get(ch);
        }
        return node.endWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */