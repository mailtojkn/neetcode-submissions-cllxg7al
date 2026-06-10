class Solution {
    public boolean isValidSudoku(char[][] board) {

        if(board == null || board.length != 9) return false;
        int n=9;
        Set<Character>[] rows = new HashSet[n];
        Set<Character>[] cols = new HashSet[n];
        Set<Character>[] boxes = new HashSet[n];

        for(int i=0;i<n;i++)
        {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }


        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                char c = board[i][j];
                if(c=='.') continue;
                int boxindex = (i/3)*3+(j/3);
                if(rows[i].contains(c) || cols[j].contains(c)|| boxes[boxindex].contains(c))
                {
                    return false;
                }
                rows[i].add(c);
                cols[j].add(c);
                boxes[boxindex].add(c);
            }
        }

        return true;
    }
}
