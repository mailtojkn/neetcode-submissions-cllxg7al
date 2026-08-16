class Solution {
    private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private static final int INF = Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid) {

        if(grid == null || grid.length == 0) return;
        Deque<int[]> queue = new ArrayDeque<>();
        for(int r=0;r<grid.length;r++)
        {
            for(int c=0;c<grid[0].length;c++)
            {
                if(grid[r][c]==0)
                {
                    queue.offer(new int[]{r,c});
                }
            }
        }
        if(queue.isEmpty())
        {
            return;
        }

        while(!queue.isEmpty())
        {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            for(int[] dir: dirs)
            {
                int nr = row+dir[0];
                int nc = col +dir[1];

                if(nr <0 || nr>= grid.length || nc<0||nc>=grid[0].length||grid[nr][nc]!=INF)
                {
                    continue;
                }

                grid[nr][nc] = grid[row][col]+1;
                queue.offer(new int[]{nr,nc});
            }
        }
        
    }
}
