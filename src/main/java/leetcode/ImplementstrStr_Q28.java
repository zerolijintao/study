package leetcode;

/*
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
输入: haystack = "hello", needle = "ll"
输出: 2
输入: haystack = "aaaaa", needle = "bba"
输出: -1
 */
public class ImplementstrStr_Q28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int targetOffset = 0;
        char first = target[targetOffset];
        int sourceOffset = 0;
        int sourceCount = haystack.length();
        int targetCount = needle.length();
        int max = sourceOffset + (sourceCount - targetCount);

        int fromIndex = 0;
        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s= "hello";
        ImplementstrStr_Q28 q = new ImplementstrStr_Q28();
        System.out.println(q.strStr(s,"ll"));
    }
}
