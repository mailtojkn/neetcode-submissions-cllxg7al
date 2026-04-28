public class Solution {
    public int[] FindOrder(int numCourses, int[][] prerequisites) {      
     int[] indegree = new int[numCourses];
     var adj = new Dictionary<int,List<int>>();
     foreach(var edge in prerequisites)
     {
        int course = edge[0];
        int prereq = edge[1];
        if(!adj.ContainsKey(prereq))
        {
            adj[prereq]=new List<int>();
        }
        adj[prereq].Add(course);
        indegree[course]++;
     }

    Queue<int> queue = new Queue<int>();
    for(int i=0;i<numCourses;i++)
    {
    if(indegree[i]==0)
    {
        queue.Enqueue(i);
    }
    }
    //if(queue.Count==0) return false; 
    List<int> order = new List<int>();
    int count=0;
    while(queue.Count>0)
    {
        int u = queue.Dequeue();
        count++;
        order.Add(u);
        if(adj.ContainsKey(u))
        {
            foreach(var v in adj[u])
            {
                indegree[v]--;
                if(indegree[v] == 0)
                {
                    queue.Enqueue(v);
                }
            }
        }
    }

    return count == numCourses ? order.ToArray() : new int[0];
}
}

