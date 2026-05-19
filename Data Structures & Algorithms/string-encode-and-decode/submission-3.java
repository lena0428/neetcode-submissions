class Solution {

      public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length());
            sb.append(":");
            sb.append(str);
        }
        return sb.toString();
    }


    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (j < str.length() && str.charAt(j) != ':') {
                j++;
            }
            int count = Integer.valueOf(str.substring(i, j));
            res.add(str.substring(j + 1, j + 1 + count));
            i = j + 1 + count;
        }
        return res;
    }
}
