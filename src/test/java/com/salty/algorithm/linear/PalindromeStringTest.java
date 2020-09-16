package com.salty.algorithm.linear;

import com.salty.algorithm.linear.linkedlist.PalindromeString;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.Objects;

import static com.salty.algorithm.linear.linkedlist.PalindromeString.chargeIsPalindromeStringFirst;
import static com.salty.algorithm.linear.linkedlist.PalindromeString.chargeIsPalindromeStringSecond;

public class PalindromeStringTest {

    @Test
    public  void test() {
        Assert.isTrue(chargeIsPalindromeStringFirst(_generateString("112211")));
        Assert.isTrue(chargeIsPalindromeStringFirst(_generateString("11211")));
        Assert.isTrue(chargeIsPalindromeStringSecond(_generateString("112211")));
        Assert.isTrue(chargeIsPalindromeStringSecond(_generateString("11211")));


        Assert.isTrue(!chargeIsPalindromeStringFirst(_generateString("11122211")));
        Assert.isTrue(!chargeIsPalindromeStringSecond(_generateString("112231211")));
    }

    private static PalindromeString.Node _generateString(String s) {
        Objects.requireNonNull(s);
        s = s.trim();
        PalindromeString.Node[] nodes = new PalindromeString.Node[s.length()];
        for (int i = 0; i < s.toCharArray().length; i++) {
            nodes[i] = new PalindromeString.Node(s.charAt(i), null);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        return nodes[0];
    }
}