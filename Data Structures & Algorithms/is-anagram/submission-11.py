class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        countS, countT = {}, {}

        for x in range(len(s)):
            countS[s[x]] = 1 + countS.get(s[x],0)
            countT[t[x]] = 1 + countT.get(t[x],0)
        for c in countS:
            if countS[c] != countT.get(c,0):
                return False
        return True


        