/*----------------------------------------------------------------------------*/
/* Source File:   COINSERVICETESTS.JAVA                                       */
/* Description:   Service implementation to handle Coin operations            */
/*                (Tests)                                                     */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.19/2018                                                 */
/* Last Modified: Sep.11/2018                                                 */
/* Version:       1.3                                                         */
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
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.COIN_VALUE_TWO_HUNDRED;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Service implementation to handle Coin operations (Tests).
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.3, Sep.11/2018
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
     * Checks that invalid coin denominations are not registered.
     * That is, if the following coin denomination setting is tried
     * "abc, 50, cc      , mm, 1000, " only "50,1000" are considered.
     *
     */
    @Test
    public void givenCoinWhenInitDiscardInvalidElements() {
        String coinDenomination = "abc, 50, cc      , mm, 50, 1000, ";
        String expectedCoinDenomination = "50,1000";
        coinService.init(coinDenomination);

        String registeredCoinDenomination = coinService.retrieveRegistered();
        assertThat(registeredCoinDenomination).isEqualTo(expectedCoinDenomination);
    }

    /**
     * Checks that the 50 coin denomination is an initial registered coin denomination.
     *
     */
    @Test
    public void givenCoinWhenItsValueIs50ThenItIsKnownReturnsTrue() {
        String coinValue = COIN_VALUE_FIFTY;
        boolean validCoin = coinService.validate(coinValue);
        assertThat(validCoin).isEqualTo(true);
    }

    /**
     * Checks that 150 coin denomination is not an initial registered coin denomination.
     *
     */
    @Test
    public void givenCoinWhenItsValueIs150ThenItIsUnknownReturnsFalse() {
        String coinValue = "150";
        boolean validCoin = coinService.validate(coinValue);
        assertThat(validCoin).isEqualTo(false);
    }

    /**
     * Checks that a coin value which is not integer then it is rejected.
     *
     */
    @Test
    public void givenCoinWhenAddsNonValidCoinValueReturnsFalse() {
        String coinValue = "abc";
        boolean registered = coinService.register(coinValue);
        assertThat(registered).isEqualTo(false);
    }

    /**
     * Checks that a coin value when it is empty cannot be registered as a valid entry.
     *
     */
    @Test
    public void givenCoinWhenAddsEmptyCoinValueReturnsFalse() {
        String coinValue = "";
        boolean registered = coinService.register(coinValue);
        assertThat(registered).isEqualTo(false);
    }

    /**
     * Try to register an existing valid coin denomination which is not allowed.
     *
     */
    @Test
    public void givenCoinWhenAddsADuplicateCoinValueReturnsFalse() {
        String coinValue = COIN_VALUE_TWO_HUNDRED;
        boolean registered = coinService.register(coinValue);
        assertThat(registered).isEqualTo(false);
    }

    /**
     * Chacks a new value is registered and valid for usage.
     *
     */
    @Test
    public void givenCoinWhenAddsAnotherValueReturnsTrue() {
        String coinValue = "700";
        boolean registered = coinService.register(coinValue);
        boolean isValid = coinService.validate(coinValue);
        assertThat(registered).isEqualTo(true);
        assertThat(isValid).isEqualTo(true);
    }

    /**
     * Checks Coin Service registered coin values.
     */
    @Test
    public void givenCoinWhenNotEmptyReturnRegisteredCoinsAsCSV() {
        String registeredCoins = coinService.retrieveRegistered();
        assertThat(registeredCoins)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("50,100,200,500,1000");
    }
}
