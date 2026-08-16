class Solution {

    private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific=new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        for(int i=0;i<rows;i++)
        {
            dfs(heights, i,0,pacific, heights[i][0]);
            dfs(heights, i, cols-1, atlantic,heights[i][cols-1]);
        }

        for(int j=0;j<cols;j++)
        {
            dfs(heights, 0, j, pacific, heights[0][j]);
            dfs(heights, rows-1, j, atlantic, heights[rows-1][j]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
            {
                if(pacific[r][c] && atlantic[r][c])
                {
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited, int height)
    {
        if(row<0|| row>=heights.length||col<0||col>=heights[0].length||visited[row][col] ||heights[row][col]<height)
        {
            return;
        }

        visited[row][col]=true;
        for(int[] dir:dirs)
        {
            dfs(heights,row+dir[0],col+dir[1],visited, heights[row][col]);
        }
    }

}
