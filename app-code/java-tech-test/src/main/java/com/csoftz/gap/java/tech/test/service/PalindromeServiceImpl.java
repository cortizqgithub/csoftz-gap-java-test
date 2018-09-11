/*----------------------------------------------------------------------------*/
/* Source File:   PALINDROMESERVICEIMPL.JAVA                                  */
/* Description:   Service implementation to handle Palindrome operations.     */
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
package com.csoftz.gap.java.tech.test.service;

import com.csoftz.gap.java.tech.test.service.intr.PalindromeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service implementation to handle Palindrome operations.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.3, Sep.10/2018
 * @since 1.8 (JDK), May.19/2018
 */
@Service
public class PalindromeServiceImpl implements PalindromeService {
    private static final Logger log = LoggerFactory.getLogger(PalindromeServiceImpl.class);

    /**
     * Validates if info is a Palindrome text. A palindrome sentence is those
     * that can be spelled the same way forward an backward.
     *
     * @param info Data information to validate
     * @return True if text is palindrome.
     */
    @Override
    public Boolean check(String info) {
        log.debug("Executing check()");
        log.debug("Parameter info=[{}]", info);
        if (info == null) {
            return false;
        }
        String infoWork =
                info.toLowerCase()
                        .trim()
                        .replace(" ", "");
        String infoReversed =
                new StringBuilder(info)
                        .reverse()
                        .toString()
                        .toLowerCase()
                        .trim()
                        .replace(" ", "");

        return infoWork.equalsIgnoreCase(infoReversed);
    }
}
