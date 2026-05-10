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
        // 1:a3:abc
        List<String> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < str.length()) {
            j = i;
            while (j < str.length() && str.charAt(j) != ':') {
                j++;
            }
            String number = str.substring(i, j);
            Integer cnt = Integer.valueOf(number);
            res.add(str.substring(j + 1, j  + cnt + 1));
            i = j + cnt + 1;
        }
        return res;
    }
}
