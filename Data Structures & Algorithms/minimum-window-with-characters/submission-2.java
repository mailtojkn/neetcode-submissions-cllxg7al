class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        Map<Character, Integer> need = new HashMap<>();
        Map<Character,Integer> have = new HashMap<>();

        for(char c:t.toCharArray())
        {
            need.put(c, need.getOrDefault(c,0)+1);
        }

        int matches=0;
        int left=0;
        int minLength = Integer.MAX_VALUE;
        int minStart =0;

        for(int right=0;right<s.length();right++)
        {
            char c = s.charAt(right);
            if(need.containsKey(c))
            {
                have.put(c, have.getOrDefault(c,0)+1);
                if(need.get(c).equals(have.get(c)))
                {
                    matches++;
                }
            }
            while(matches == need.size())
            {
                if(right-left+1<minLength)
                {
                    minLength = right-left+1;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                if(need.containsKey(leftChar))
                {
                    have.put(leftChar, have.get(leftChar)-1);
                    if(have.get(leftChar)<need.get(leftChar))
                    {
                        matches--;
                    }
                }
                left++;
            }

          }
          return minLength==Integer.MAX_VALUE?"":s.substring(minStart, minStart+minLength);
  
    }
}
