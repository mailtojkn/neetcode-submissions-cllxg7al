class Solution {
    private static final int[][] dirs= {{-1,0},{1,0},{0,-1},{0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea=0;
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {  
                if(grid[r][c]==1)
                {
                int area = dfs(grid, r,c);
                maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c)
    {
        if(r<0 || r>=grid.length||c<0||c>=grid[0].length ||grid[r][c]!=1)
        {
            return 0;
        }

        grid[r][c]='0';
        int area=1;
        for(int[] dir:dirs)
        {
            area+= dfs(grid,r+dir[0],c+dir[1]);
        }
        return area;
    }
}
