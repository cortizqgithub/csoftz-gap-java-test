/*----------------------------------------------------------------------------*/
/* Source File:   COINSERVICETESTS.JAVA                                       */
/* Description:   Service implementation to handle Coin operations            */
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

import com.csoftz.gap.java.tech.test.service.intr.CoinService;
import org.junit.Before;
import org.junit.Test;

import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.COIN_VALUE_FIFTY;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Service implementation to handle Coin operations (Tests).
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.19/2018
 * @since 1.8 (JDK), May.19/2018
 */
public class CoinServiceTests {

    /*
     * Service to test.
     */
    private static CoinService coinService;

    /**
     * Prepare helpers.
     */
    @Before
    public void init() {
        coinService = new CoinServiceImpl();
        coinService.init("50 , 100 , 200 , 500 , 1000 ");
    }

    /**
     * Checks that the 50 coin denomination is registered.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenCoinWhenItsValueIs50ThenItIsKnownReturnsTrue() throws Exception {
        String coinValue = COIN_VALUE_FIFTY;
        boolean validCoin = coinService.validate(coinValue);
        assertThat(validCoin).isEqualTo(true);
    }

    /**
     * Checks that 150 coin denomination is not registered.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenCoinWhenItsValueIs150ThenItIsUnknownReturnsFalse() throws Exception {
        String coinValue = "150";
        boolean validCoin = coinService.validate(coinValue);
        assertThat(validCoin).isEqualTo(false);
    }

    /**
     * Checks that a coin value which is not integer then it is rejected.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenCoinWhenAddsNonValidCoinValueReturnsFalse() throws Exception {
        String coinValue = "abc";
        boolean registered = coinService.register(coinValue);
        assertThat(registered).isEqualTo(false);

    }

    /**
     * Chacks a new value is registered and valid for usage.
     *  @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenCoinWhenAddsAnotherValueReturnsTrue() throws Exception {
        String coinValue = "700";
        boolean registered = coinService.register(coinValue);
        boolean isValid = coinService.validate(coinValue);
        assertThat(registered).isEqualTo(true);
        assertThat(isValid).isEqualTo(true);
    }
}
