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
        // 1:a3:bcc
        int i = 0;
        List<String> res = new ArrayList<>();
        if (str == "") {
            return res;
        }
        while (i < str.length()) {
            // i -> digit
            // j -> ':'
            int j = i;
            while (j < str.length() && str.charAt(j) != ':') {
                j++;
            }
            
            int length = Integer.parseInt(str.substring(i, j));
            res.add(str.substring(j + 1, j + 1 + length));
            i = j + length + 1;
        }
        return res;
    }
}
