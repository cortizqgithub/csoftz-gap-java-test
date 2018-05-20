/*----------------------------------------------------------------------------*/
/* Source File:   COINSERVICE.JAVA                                            */
/* Description:   Service interface to handle Coin operations.                */
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

/**
 * Service interface to handle Coin operations.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, May.20/2018
 * @since 1.8 (JDK), May.19/2018
 */
public interface CoinService {
    /**
     * Sets up the valid coin values.
     *
     * @param s List of valid coin values separated with comma, it is then split into
     *          individual values. Example, '50,100,200,500,100'. If for any reason a
     *          duplicate value is given or the value is not integer, it is discarded.
     */
    void init(String s);

    /**
     * Validates that given coin value is in the valid registered coinsStore.
     *
     * @param coinValue The coin value to test.
     * @return True if it is registered.
     */
    boolean validate(String coinValue);

    /**
     * Registeres a new coin value.
     *
     * @param coinValue Value to set
     * @return True if successful registration.
     */
    boolean register(String coinValue);

    /**
     * Ask service about the registered coinsStore so far.
     *
     * @return A CSV formatted values of registered coinsStore. It
     * does not put spaces for every coin value.
     */
    String retrieveRegistered();
}
