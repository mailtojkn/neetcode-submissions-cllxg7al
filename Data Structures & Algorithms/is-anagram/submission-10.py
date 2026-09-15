class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        s_list = []
        t_list = []
        for chr in s:
            s_list.append(chr)
        for chr in t:
            t_list.append(chr)
        s_list.sort()
        t_list.sort()
        return s_list == t_list
        