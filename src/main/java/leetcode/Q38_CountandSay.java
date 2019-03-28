package leetcode;

public class Q38_CountandSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = "11";
        for (int i = 2; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            int count = 1;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j - 1] == chars[j]) {
                    count++;
                } else {
                    sb.append(count).append(chars[j-1]);
                    count = 1;
                }
            }
            sb.append(count).append(chars[chars.length-1]);
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        Q38_CountandSay q = new Q38_CountandSay();
        System.out.println(q.countAndSay(4));
    }
}
