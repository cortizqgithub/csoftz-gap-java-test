/*----------------------------------------------------------------------------*/
/* Source File:   GLOBALCONSTANTS.JAVA                                        */
/* Description:   General constant definitions.                               */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.19/2018                                                 */
/* Last Modified: Dec.14/2018                                                 */
/* Version:       1.4                                                         */
/* Copyright (c), 2018 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.19/2018  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.gap.java.tech.test.common.consts;

/**
 * General constant definitions.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.4, Dec.14/2018
 * @since 1.8 (JDK), May.19/2018
 */
public class GlobalConsts {
    /*
     * General
     */
    public static final String APP_NAME = "Java Tech Test for GAP.";
    public static final String APP_VERSION = "1.0.2-RELEASE. Dec.14/2018.";

    /*
     * Coins
     */
    public static final String COIN_VALUE_FIFTY = "50";
    public static final String COIN_VALUE_ONE_HUNDRED = "100";
    public static final String COIN_VALUE_TWO_HUNDRED = "200";
    public static final String COIN_VALUE_FIVE_HUNDRED = "500";
    public static final String COIN_VALUE_ONE_THOUSAND = "1000";

    /**
     * Piggy Bank Error Codes
     */
    public static final int CODE_OK = 0;
    public static final int ERROR_CODE_COIN_INVALID_DENOMINATION = -1;
    public static final int ERROR_CODE_CANNOT_WITHDRAW_COIN = -2;

    /*
     * Piggy Bank Error Messages.
     */
    public static final String ERROR_MSG_COIN_INVALID_DENOMINATION = "Coin rejected. Valid coin denominations are: 50, 100, 200, 500 & 1000";
    public static final String ERROR_MSG_CANNOT_WITHDRAW_COIN = "No coin can be withdrawn from Piggy Bank. Not allowed.";

    /**
     * Adds a private constructor in order to be SonarLint Compliant as this class
     * will never be instantiated as it is an utility class.
     */
    private GlobalConsts() {
        throw new IllegalStateException("Utility class");
    }
}
