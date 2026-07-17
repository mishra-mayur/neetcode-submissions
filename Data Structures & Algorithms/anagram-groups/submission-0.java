class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();

        Map<String,List<String>> frequency = new HashMap();

        for(int i = 0; i < strs.length; i++) {
            String ints = getIntArray(strs[i]);
            List<String> list = frequency.getOrDefault(ints, new ArrayList());
            list.add(strs[i]);
            frequency.put(ints, list);
        }

        for(Map.Entry<String,List<String>> entry : frequency.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    private String getIntArray(String str) {
        int[] ints = new int[26];
        for(int i = 0; i < str.length(); i++) {
            ints[str.charAt(i) - 'a']++;
        }
        return Arrays.toString(ints);
    }
}