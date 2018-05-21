/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMESERVICETESTS.JAVA                                 */
/* Description:   Service implementation to handle Palindrome operations      */
/*                (Tests)                                                     */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.19/2018                                                 */
/* Last Modified: May.20/2018                                                 */
/* Version:       1.2                                                         */
/* Copyright (c), 2018 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.19/2018  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.gap.java.tech.test.service;

import com.csoftz.gap.java.tech.test.service.intr.PalindromeService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Service implementation to handle Palindrome operations (Tests).
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, May.20/2018
 * @since 1.8 (JDK), May.19/2018
 */
public class PalindromeServiceTests {
    /*
     * Service to test.
     */
    private static PalindromeService palindromeService;

    /**
     * Prepare helpers.
     */
    @BeforeClass
    public static void init() {
        palindromeService = new PalindromeServiceImpl();
    }

    /**
     * Checks if the Empty String is a Palindrome.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenPalindromeWhenInfoIsEmptyThenReturnsTrue() throws Exception {
        String info = "";

        Boolean isPalindrome = palindromeService.check(info);
        assertThat(isPalindrome).isTrue();
    }

    /**
     * Checks if non empty text that is known as a Palindrome text is checked as TRUE.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenPalindromeWhenPuttingAPalindromeTextThenReturnsTrue() throws Exception {
        String info = "A nut for a jar of tuna";

        Boolean isPalindrome = palindromeService.check(info);
        assertThat(isPalindrome).isTrue();
    }

    /**
     * Given a null string, it returns false.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenPalindromeWhenPuttingANullStringThenReturnsFalse() throws Exception {
        String info = null;

        Boolean isPalindrome = palindromeService.check(info);
        assertThat(isPalindrome).isFalse();
    }
}
