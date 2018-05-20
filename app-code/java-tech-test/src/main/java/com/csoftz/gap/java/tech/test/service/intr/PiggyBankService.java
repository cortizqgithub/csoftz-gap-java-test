/*----------------------------------------------------------------------------*/
/* Source File:   PIGGYBANKSERVICE.JAVA                                       */
/* Description:   Service interface to handle Piggy Bank operations.          */
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
package com.csoftz.gap.java.tech.test.service.intr;

import com.csoftz.gap.java.tech.test.domain.PiggyBank;
import com.csoftz.gap.java.tech.test.domain.PiggyBankResponse;

/**
 * Service interface to handle Piggy Bank operations.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, May.20/2018
 * @since 1.8 (JDK), May.19/2018
 */
public interface PiggyBankService {
    /**
     * Configures the service and its dependencies.
     *
     * @param validCoinValues The list of valid coin values in CSV format, e.g., "50, 100, 200, 500, 1000".
     */
    void initialize(String validCoinValues);

    /**
     * Retrieves the information for a Piggy Bank instance.
     *
     * @return Reference for Piggy Bank.
     */
    PiggyBank retrieveStatus();

    /**
     * Adds a new coin to the Piggy Bank System. If the coindValue is not
     * a valid denomintation the returned status will offer a clue about it.
     *
     * @param coinValue
     * @return The Result of the operation as a PiggyBankResponse object.
     */
    PiggyBankResponse insertCoin(String coinValue);

    /**
     * Removes any coin from Piggy Bank.
     * @return The Result of the operation as a PiggyBankResponse object.
     */
    PiggyBankResponse remove();
}
