class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for(int num:nums)
        {
            frequency.put(num, frequency.getOrDefault(num,0)+1);
        }

        List<Integer>[] buckets = new List[nums.length+1];

        for(Map.Entry<Integer, Integer> entry: frequency.entrySet())
        {
            int num = entry.getKey();
            int freq = entry.getValue();

            if(buckets[freq]==null)
            {
                buckets[freq] = new ArrayList();
            }
            buckets[freq].add(num);
        }
        int[] result = new int[k];
        int cnt=0;
        for(int i=buckets.length-1;i>=0 && cnt<k;i-- )
        {
            if(buckets[i] == null) continue;
            for(int val : buckets[i])
            {
                result[cnt++]=val;
                if(cnt==k) break;
            }
        }
        return result;
    }
}
