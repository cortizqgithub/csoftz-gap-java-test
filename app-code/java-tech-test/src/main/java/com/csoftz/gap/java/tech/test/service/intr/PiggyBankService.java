/*----------------------------------------------------------------------------*/
/* Source File:   PIGGYBANKSERVICE.JAVA                                       */
/* Description:   Service interface to handle Piggy Bank operations.          */
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
package com.csoftz.gap.java.tech.test.service.intr;

import com.csoftz.gap.java.tech.test.domain.PiggyBank;
import com.csoftz.gap.java.tech.test.domain.PiggyBankStatus;

/**
 * Service interface to handle Piggy Bank operations.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.19/2018
 * @since 1.8 (JDK), May.19/2018
 */
public interface PiggyBankService {
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
     * @return The Result of the operation as a PiggyBankStatus object.
     */
    PiggyBankStatus insertCoin(String coinValue);
}
