public class Solution {
    public string MinWindow(string s, string t) {
        if(t.Length > s.Length) return "";

        int[] need = new int[128];
        int missing = t.Length;
        int left=0;
        int minLen = int.MaxValue;
        int minStart=0;
        for(int i=0;i<t.Length;i++)
        {
            need[t[i]]++;
        }

        for(int right=0;right<s.Length;right++)
        {
            if(need[s[right]] >0) missing--;
            need[s[right]]--;

            while(missing==0)
            {
                if(right-left+1<minLen)
                {
                    minLen = right-left+1;
                    minStart = left;
                }
                need[s[left]]++;
                if(need[s[left]] > 0 ) missing++;
                left++;
            }
            
        }
        return minLen == int.MaxValue?"":s.Substring(minStart, minLen);
    }
}
