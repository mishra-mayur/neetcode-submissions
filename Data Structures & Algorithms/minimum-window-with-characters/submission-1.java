class Solution {
    public String minWindow(String s, String t) {
        
        // substring of s that contains all elements of t

        int min = Integer.MAX_VALUE;
        int l = 0;
        String result = "";

        for(int r = 0; r < s.length(); r++) {

            String window = s.substring(l, r + 1);
            //System.out.println("Min : "+min+" l : "+l+" r : "+r);

            while(l <= r && containsSubstring(window, t)) {
                if(min > window.length()) {
                    min = Math.min(window.length(), min);
                    result = window;
                }
                l++;
                window = s.substring(l, r + 1);
            }

            //System.out.println(window);
            
        }
        return result;
    }

    private boolean containsSubstring(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap();
        Map<Character, Integer> map2 = new HashMap();

        for(int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for(int i = 0; i < s2.length(); i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map2.entrySet()) {
            if (map1.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
