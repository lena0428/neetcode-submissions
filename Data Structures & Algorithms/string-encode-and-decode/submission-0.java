class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for (String str: strs) {
            res = res + str + ":#";
        }
        return res;
    }

    public List<String> decode(String str) {
        int i = 0;
        int j = 0;
        List<String> res = new ArrayList<>();
        while (j < str.length()) {
            while (j < str.length() && str.charAt(j) != ':') {
                j++;
            }
            if (j + 1 < str.length() && str.charAt(j + 1) == '#') {
                res.add(str.substring(i, j));
            }
            i = j + 2;
            j = i + 1;
        }
        return res;
    }
}
