class Solution {
    private static final int[][]dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count=0;
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {
                if(grid[r][c]=='1')
                {
                    count++;
                    dfs(grid,r,c,rows,cols);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c, int rows, int cols)
    {
        if(r<0 || r>= rows || c<0||c>=cols || grid[r][c]=='0')
            return;
        
        grid[r][c]='0';

        for(int[] dir: dirs)
        {
            dfs(grid, r+dir[0],c+dir[1], rows, cols);
        }
    }

}
