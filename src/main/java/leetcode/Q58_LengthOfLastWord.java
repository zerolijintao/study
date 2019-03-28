package leetcode;

public class Q58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.equals("")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int right = chars.length - 1;
        while (chars[right] == ' ') {
            right--;
            if (right < 0) {
                return 0;
            }
        }
        int count = 0;
        for (int i = right; i >= 0; i--) {
            if (chars[i] == ' ') {
                break;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Q58_LengthOfLastWord q = new Q58_LengthOfLastWord();
        System.out.println(q.lengthOfLastWord(""));
    }
}
