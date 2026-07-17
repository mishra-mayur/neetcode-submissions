class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap();
        Map<Character, Integer> map2 = new HashMap();

        for(int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i),0)+1);
        }

        System.out.println(map1);
        System.out.println(map2);

        for(Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if(!map2.containsKey(entry.getKey()))
                return false;
            
            if(!map2.get(entry.getKey()).equals(entry.getValue()))
                return false;
        }
        
        return true;
    }
}
