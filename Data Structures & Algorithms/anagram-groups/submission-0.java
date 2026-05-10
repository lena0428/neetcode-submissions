class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            if (map.containsKey(getKey(s))) {
                map.get(getKey(s)).add(s);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(s);
                map.put(getKey(s), tmp);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    private String getKey(String s) {
        int[] existed = new int[26];
        for (int i = 0; i < s.length(); i++) {
            existed[s.charAt(i) - 'a']++;
        }
        String res = "";
        for (int i = 0; i < 26; i++) {
            res += existed[i] + "_";
        }
        return res;
    }
}
