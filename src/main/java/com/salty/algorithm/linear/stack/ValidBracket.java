package com.salty.algorithm.linear.stack;

import com.google.common.collect.ImmutableMap;

import java.util.LinkedList;
import java.util.Map;

/**
 * @author ryan
 * @since 2020/09/09
 */
public class ValidBracket {
    private Map<Character, Character> brackets;

    public ValidBracket() {
        this.brackets = ImmutableMap.of(')', '(', '}', '{', ']', '[');
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char bracket = s.charAt(i);
            if (brackets.containsKey(bracket)) {
                if (stack.size() == 0 || brackets.get(bracket) != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(bracket);
            }

        }
        return stack.size() == 0;
    }
}
