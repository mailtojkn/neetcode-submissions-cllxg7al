class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        

        Deque<Integer> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            map.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites)
        {
            int course = pre[0];
            int precourse = pre[1];
            map.get(precourse).add(course);
            indegree[course]++;
        }

        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                queue.offer(i);
            }
        }

        int completed =0;

        while(!queue.isEmpty())
        {
            int course = queue.poll();
            completed++;

            for(int nextCourse : map.get(course))
            {
                indegree[nextCourse]--;
                if(indegree[nextCourse]==0)
                {
                    queue.offer(nextCourse);
                }
            }
        }
        return completed==numCourses;
    }
}
