class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int[] prev = intervals[0];
        int overlap =0;
        for(int i=1;i<intervals.length;i++)
        {
            int[] current = intervals[i];
            if(prev[1]>current[0])
            {
                overlap++;
            }
            else
            {
                prev=current;
            }
        }
        return overlap;
    }
}
