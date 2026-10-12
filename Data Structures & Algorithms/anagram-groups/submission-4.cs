public class Solution {
    public List<List<string>> GroupAnagrams(string[] strs) {
        Dictionary<string, List<string>> dict = new Dictionary<string,List<string>>();
        foreach(var str in strs)
        {
            int[] cnt = new int[26];

            foreach(var c in str)
            {
                cnt[c-'a']++;
            }

            string key = string.Join(',',cnt);

            if(!dict.ContainsKey(key))
            {
                dict[key] = new List<string>();
            }
            dict[key].Add(str);

        }

        return new List<List<string>>(dict.Values);

    }
}
