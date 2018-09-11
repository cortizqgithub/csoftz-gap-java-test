/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMECONTROLLER.JAVA                                   */
/* Description:   REST Api for Palindrome end-points.                         */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.19/2018                                                 */
/* Last Modified: Sep.10/2018                                                 */
/* Version:       1.3                                                         */
/* Copyright (c), 2018 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.19/2018  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.gap.java.tech.test.api.controller;

import com.csoftz.gap.java.tech.test.service.intr.PalindromeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Api for Palindrome end-points.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.3, Sep.10/2018
 * @since 1.8 (JDK), May.19/2018
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1/palindrome")
public class PalindromeController {
    private static final Logger log = LoggerFactory.getLogger(PalindromeController.class);
    private PalindromeService palindromeService;

    /**
     * Constructor with parameters.
     *
     * @param palindromeService Inject a service to check palindrome texts.
     */
    public PalindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    /**
     * Given text in URL checks if it is a Palindrome
     *
     * @param t Text to check
     * @return True if palindrome
     */
    @GetMapping("/check")
    public Boolean checkPalindromeFor(@RequestParam String t) {
        Boolean rslt = this.palindromeService.check(t);
        String msg = String.format("t=[%s] is a palindrome=%b", t, rslt);
        log.debug(msg);
        return rslt;
    }
}
