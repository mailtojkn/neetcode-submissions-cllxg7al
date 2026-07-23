public class Solution {
    public int CarFleet(int target, int[] position, int[] speed) {
        int n = position.Length;
        (int pos, double time)[] cars = new (int pos, double time)[n];
        

        for(int i=0;i<n;i++)
        {
            cars[i] = (position[i], (double)(target - position[i])/speed[i]);
        }

        Array.Sort(cars, (a,b)=>b.pos.CompareTo(a.pos));

        int fleets =0;

        double slowest = 0;

        foreach(var car in cars)
        {
            if(car.time>slowest)
            {
                fleets++;
                slowest= car.time;
            }
        }
        return fleets;
    }
}
