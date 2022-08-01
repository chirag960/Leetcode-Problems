class Solution {
    
    class TrieNode {

        boolean isEnd;
        TrieNode[] links;
        final int len = 26;
        int index;

        public TrieNode(){
            links = new TrieNode[len];
        }

        public boolean containsKey(char c){
            return links[c - 'a']!=null;
        }

        public TrieNode get(char c){
            return links[c - 'a'];
        }

        public void put(char c, TrieNode node){
            links[c - 'a'] = node;
        }

        public void setEnd(){
            isEnd = true;
        }

        public boolean getEnd(){
            return isEnd;
        }

        public void setIndex(int i){
            index = i;
        }

        public int getIndex(){
            return index;
        }
    }
    
    TrieNode root;
    Set<String> result;
    String[] words;

    public Solution(){
        root = new TrieNode();
    }

    public void insert(String s, int index){
        TrieNode node = root;
        for(char c : s.toCharArray()){
            if(!node.containsKey(c)){
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
        node.setIndex(index);
    }

    public void recur(char[][] board,boolean[][] visited, int i, int j, TrieNode node){
        if (node.containsKey(board[i][j])) {
            visited[i][j] = true;
            node = node.get(board[i][j]);
            if (node.getEnd()) {
                result.add(words[node.getIndex()]);
            }

            if (i - 1 >= 0 && !visited[i-1][j]) {
                recur(board,visited, i - 1, j, node);
            }
            if (j - 1 >= 0 && !visited[i][j-1]) {
                recur(board,visited, i, j - 1, node);
            }
            if (i + 1 < board.length && !visited[i+1][j]) {
                recur(board,visited, i + 1, j, node);
            }
            if (j + 1 < board[0].length && !visited[i][j+1]) {
                recur(board,visited, i, j + 1, node);
            }
            visited[i][j] = false;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        for(int i=0;i<words.length;i++){
            insert(words[i], i);
        }

        result = new HashSet<>();
        this.words = words;

        for(int i=0; i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                recur(board,visited, i, j, root);
            }
        }

        System.out.println(result);
        List<String> ans = new ArrayList<String>();
        ans.addAll(result);
        return ans;
    }
}