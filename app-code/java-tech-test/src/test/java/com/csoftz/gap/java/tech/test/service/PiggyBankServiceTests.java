/*----------------------------------------------------------------------------*/
/* Source File:   PIGGYBANKSERVICETESTS.JAVA                                  */
/* Description:   Service implementation to handle Piggy Bank operations      */
/*                (Tests)                                                     */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.19/2018                                                 */
/* Last Modified: May.19/2018                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2018 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.19/2018  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.gap.java.tech.test.service;

import com.csoftz.gap.java.tech.test.service.intr.PiggyBankService;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;

/**
 * Service implementation to handle Piggy Bank operations (Tests).
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.19/2018
 * @since 1.8 (JDK), May.19/2018
 */
public class PiggyBankServiceTests {

    /*
     * Service to test.
     */
    private static PiggyBankService piggyBankService;

    /**
     * Prepare helpers.
     */
    @BeforeClass
    public static void init() {
        piggyBankService = mock(PiggyBankService.class);
    }

    /**
     * Prepare data for each test.
     */
    @Before
    public void setup() {
        reset(piggyBankService);
    }
}
