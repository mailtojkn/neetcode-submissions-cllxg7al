class Solution {
    private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(char[][] board) {
        
        int rows =  board.length;
        int cols = board[0].length;

        for(int i=0;i<rows;i++)
        {
            dfs(board, i,0);
            dfs(board, i, cols-1);
        }

        for(int j=0;j<cols;j++)
        {
            dfs(board, 0, j);
            dfs(board, rows-1, j);
        }

        for(int r =0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {
                if(board[r][c]=='O')
                {
                    board[r][c]='X';
                }
                else if(board[r][c] == 'T')
                {
                    board[r][c]='O';
                }

            }
        }
    }

    private  void dfs(char[][] board, int r, int c)
    {
        if(r<0||r>=board.length||c<0||c>=board[0].length||board[r][c]!='O')
        {
            return;
        }
        board[r][c]='T';

        for(int[] dir : dirs)
        {
            dfs(board, r + dir[0],c + dir[1]);
        }
    }
}
