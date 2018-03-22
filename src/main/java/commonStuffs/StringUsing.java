package commonStuffs;

/**
 * Created by Thanh Mai on 3/22/2018.
 */
public class StringUsing {
    public static boolean isPalindrome(String text) {
        text = text.replaceAll("\\s+", "").toLowerCase();
        int length = text.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = text.charAt(forward++);
            char backwardChar = text.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }
}
