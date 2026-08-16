class Solution {
    public int orangesRotting(int[][] grid) {

        int freshOranges =0;
        int[][] dirs = {{-1,0}, new int[]{1,0}, new int[] {0,-1}, new int[]{0,1}};
        Deque<int[]> q= new ArrayDeque<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new int[]{i, j});
                }
                if(grid[i][j]==1) freshOranges++;
            }
        }

        if(freshOranges == 0) return 0;

        int level=0;

        while(!q.isEmpty() && freshOranges >0)
        {
            int count = q.size();
            level++;

            while(count>0)
            {
                int[] coordinates = q.poll();
                for(int[] dir : dirs)
                {
                    int newRow = coordinates[0]+dir[0];
                    int newCol = coordinates[1]+dir[1];
                    if(newRow > grid.length-1 || newRow <0||newCol > grid[0].length-1 || newCol<0 || grid[newRow][newCol]!=1 )
                    {
                        continue;
                    }
                    grid[newRow][newCol] =2;
                    freshOranges--;
                    q.offer(new int[]{newRow, newCol});
                }
                count--;
            }
           
        
    }       
     return freshOranges==0?level:-1;
    }
}