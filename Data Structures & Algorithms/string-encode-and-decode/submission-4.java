class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str: strs) {
            res.append(str.length());
            res.append(":");
            res.append(str);
        }
        return res.toString();
    }

    // 1:a2:bb
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            // find :
            while (j < str.length() && Character.isDigit(str.charAt(j))) {
                j++;
            }
            int count = Integer.valueOf(str.substring(i, j));
            res.add(str.substring(j + 1, j + count + 1));
            i = j + count + 1;
        }
        return res;
    }
}
