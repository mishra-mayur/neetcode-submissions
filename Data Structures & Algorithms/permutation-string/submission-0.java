class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int  l = 0;

        for(int r = 0; r < s2.length(); r++) {


            while(s2.substring(l,r+1).length() > s1.length()) {
                l++;
            }

            if(isPermutation(s2.substring(l,r+1), s1))
                return true;
        }

        return false;
    }

    private boolean isPermutation(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        
        Map<Character,Integer> map1 = new HashMap();
        Map<Character,Integer> map2 = new HashMap();

        for(int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i),0)+1);
        }

        for(Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (map2.get(entry.getKey()) != entry.getValue())
                return false;
        }
        return true;
    }
}
