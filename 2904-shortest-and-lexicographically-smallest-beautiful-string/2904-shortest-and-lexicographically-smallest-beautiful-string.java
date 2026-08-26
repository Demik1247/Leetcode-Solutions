class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);

                if (containone(sub) == k) {
                    if (ans.equals("") ||
                        sub.length() < ans.length() ||
                        (sub.length() == ans.length() && sub.compareTo(ans) < 0)) {
                        ans = sub;
                    }
                }
            }
        }

        return ans;
    }

    private int containone(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}