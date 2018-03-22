import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Thanh Mai on 3/22/2018.
 */
public class StringUsingTest {
    @Test
    public void isPalindromeTest() {
        String text = "a b c d f e e f d cba";
        Assert.assertTrue(StringUsing.isPalindrome(text));

        String text2 = "a b c 3 d f e e f d cba";
        Assert.assertFalse(StringUsing.isPalindrome(text2));
    }

}
