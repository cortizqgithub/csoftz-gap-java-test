/*----------------------------------------------------------------------------*/
/* Source File:   PIGGYBANKSERVICETESTS.JAVA                                  */
/* Description:   Service implementation to handle Piggy Bank operations      */
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

import com.csoftz.gap.java.tech.test.domain.PiggyBank;
import com.csoftz.gap.java.tech.test.domain.PiggyBankResponse;
import com.csoftz.gap.java.tech.test.service.intr.CoinService;
import com.csoftz.gap.java.tech.test.service.intr.PiggyBankService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.CODE_OK;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.COIN_VALUE_FIFTY;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_CODE_CANNOT_WITHDRAW_COIN;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_CODE_COIN_INVALID_DENOMINATION;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_MSG_CANNOT_WITHDRAW_COIN;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_MSG_COIN_INVALID_DENOMINATION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

/**
 * Service implementation to handle Piggy Bank operations (Tests).
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.3, Sep.11/2018
 * @since 1.8 (JDK), May.19/2018
 */
public class PiggyBankServiceTests {

    /*
     * Service to test.
     */
    private static PiggyBankService piggyBankService;

    /*
     * Helper services
     */
    private static CoinService coinService;

    /**
     * Prepare helpers.
     */
    @BeforeClass
    public static void init() {
        coinService = mock(CoinService.class);
        piggyBankService = new PiggyBankServiceImpl(coinService);
    }

    /**
     * Prepare data for each test.
     */
    @Before
    public void setup() {
        String validCoinValues = "50,100,200,500,1000";
        reset(coinService);
        when(coinService.retrieveRegistered()).thenReturn(validCoinValues);
        piggyBankService.initialize(validCoinValues);
    }

    /**
     * Given a Piggy Bank it examines it is returned as not null reference.
     *
     */
    @Test
    public void givenPiggyBankWhenEmptyReturnsNotNull() {
        PiggyBank piggyBank = piggyBankService.retrieveStatus();
        assertThat(piggyBank).isNotNull();
    }

    /**
     * Given a Piggy Bank it examines that it is set to empty values.
     *
     */
    @Test
    public void givenPiggyBankWhenNotEmptyReturnsNonEmptyStatus() {
        PiggyBank piggyBank = piggyBankService.retrieveStatus();
        assertThat(piggyBank.getSize()).isEqualTo(0);
        assertThat(piggyBank.getCoinsStore().isEmpty()).isFalse();
        assertThat(piggyBank.getCoinsStore().size()).isEqualTo(5);
    }

    /**
     * Checks if Piggy Bank can handle registered Coin denominations.
     */
    @Test
    public void givenPiggyBankWhenNotEmptyCheckItHasValidCoinEntries() {
        PiggyBank piggyBank = piggyBankService.retrieveStatus();
        String keys = piggyBank.getCoinsStore().keySet().toString();
        assertThat(keys).isEqualTo("[100, 1000, 200, 50, 500]");
    }

    /**
     * Given a Piggy Bank When a 50 coin is inserted it returns OK as a valid operation.
     *
     */
    @Test
    public void givenPiggyBankWhenNotNullAndInsertACoindOfVal50ReturnOK() {
        String coinValue = COIN_VALUE_FIFTY;
        when(coinService.validate(coinValue)).thenReturn(true);
        PiggyBankResponse inserted = piggyBankService.insertCoin(coinValue);
        assertThat(inserted).isNotNull();
        assertThat(inserted.getError()).isEqualTo(CODE_OK);
        assertThat(inserted.getMsg()).isEmpty();
    }

    /**
     * Given a Piggy Bank When a 150 coin is inserted it returns not OK as an invalid operation
     * with a message indicating the cause.
     *
     */
    @Test
    public void givenPiggyBankWhenNotNullAndInsertACoinOfValue150ReturnNotOKWithMessage() {
        String coinValue = "150";
        when(coinService.validate(coinValue)).thenReturn(false);
        PiggyBankResponse inserted = piggyBankService.insertCoin(coinValue);
        assertThat(inserted).isNotNull();
        assertThat(inserted.getError()).isEqualTo(ERROR_CODE_COIN_INVALID_DENOMINATION);
        assertThat(inserted.getMsg()).isEqualTo(ERROR_MSG_COIN_INVALID_DENOMINATION);
    }

    /**
     * Given a Piggy Bank when one tries to remove any coin it responds as a forbidden action.
     */
    @Test
    public void givenPigghBankWhenNotNullAndRemoveACoinReturnsInvalidOperation() {
        PiggyBankResponse removed = piggyBankService.remove();
        assertThat(removed).isNotNull();
        assertThat(removed.getError()).isEqualTo(ERROR_CODE_CANNOT_WITHDRAW_COIN);
        assertThat(removed.getMsg()).isEqualTo(ERROR_MSG_CANNOT_WITHDRAW_COIN);

    }

}
