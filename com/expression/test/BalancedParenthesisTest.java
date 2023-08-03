package com.expression.test;

import org.junit.jupiter.api.Test;
import com.expression.BalancedParenthesis;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedParenthesisTest {

    @Test
    public void testBalancedParenthesis() {
        // Test a balanced string
        assertTrue(BalancedParenthesis.isBalanced(""));
        assertTrue(BalancedParenthesis.isBalanced("()"));
        assertTrue(BalancedParenthesis.isBalanced("((()))"));
        assertTrue(BalancedParenthesis.isBalanced("()()()"));

        // Test an unbalanced string
        assertFalse(BalancedParenthesis.isBalanced("("));
        assertFalse(BalancedParenthesis.isBalanced(")"));
        assertFalse(BalancedParenthesis.isBalanced("(()"));
        assertFalse(BalancedParenthesis.isBalanced("())"));
        assertFalse(BalancedParenthesis.isBalanced("()("));
        assertFalse(BalancedParenthesis.isBalanced(")("));
        assertFalse(BalancedParenthesis.isBalanced("())("));
    }

    @Test
    public void testBalancedWithOtherCharacters() {
        // Test a balanced string with other characters
        assertTrue(BalancedParenthesis.isBalanced("a(b)c[d]e{f}"));
        assertTrue(BalancedParenthesis.isBalanced("(a{b[c]d}e)"));
        assertTrue(BalancedParenthesis.isBalanced("[a(b{c})d]"));

        // Test an unbalanced string with other characters
        assertFalse(BalancedParenthesis.isBalanced("a(b[c)d]"));
        assertFalse(BalancedParenthesis.isBalanced("(a{b}c[d}e)"));
    }
}
