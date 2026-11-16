class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for (int k = 1; k < n; k++) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length();) {
                int j = i;

                while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                    j++;
                }

                sb.append(j - i);
                sb.append(s.charAt(i));

                i = j;
            }

            s = sb.toString();
        }

        return s;
    }
}