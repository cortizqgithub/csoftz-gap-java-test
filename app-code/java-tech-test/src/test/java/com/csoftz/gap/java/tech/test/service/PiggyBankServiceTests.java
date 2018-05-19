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

import com.csoftz.gap.java.tech.test.domain.PiggyBank;
import com.csoftz.gap.java.tech.test.domain.PiggyBankStatus;
import com.csoftz.gap.java.tech.test.service.intr.PiggyBankService;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_MSG_COIN_INVALID_DENOMINATION;
import static org.assertj.core.api.Assertions.assertThat;

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
        piggyBankService = new PiggyBankServiceImpl();
    }

    /**
     * Given a Piggy Bank it examines it is returned as not null reference.
     *
     * @throws Exception Throws any failure in code execution.
     */
    @Test
    public void givenPiggyBankWhenEmptyReturnsNotNull() throws Exception {
        PiggyBank piggyBank = piggyBankService.retrieveStatus();
        assertThat(piggyBank).isNotNull();
    }

    /**
     * Given a Piggy Bank it examines that it is set to empty values.
     *
     * @throws Exception
     */
    @Test
    public void givenPiggyBankWhenEmptyReturnsNoCountNoDenomination() throws Exception {
        PiggyBank piggyBank = piggyBankService.retrieveStatus();
        assertThat(piggyBank.getSize()).isEqualTo(0);
        assertThat(piggyBank.getCoins().isEmpty()).isTrue();
    }

    /**
     * Given a Piggy Bank When a 20 coin is inserted it returns OK as a valid operation.
     *
     * @throws Exception
     */
    @Test
    public void givenPiggyBankWhenNotNullAndInsertACoindOfVal20ReturnOK() throws Exception {
        String coinValue = "20";
        PiggyBankStatus inserted = piggyBankService.insertCoin(coinValue);
        //assertThat(inserted).isNotNull();
        //assertThat(inserted.getError()).isEqualTo(0);
    }

    /**
     * Given a Piggy Bank When a 150 coin is inserted it returns not OK as an invalid operation
     * with a message indicating the cause.
     */
    @Test
    public void givenPiggyBankWhenNotNullAndInsertACoinOfValue150ReturnNotOKWithMessage() {
        String coinValue = "150";
        PiggyBankStatus inserted = piggyBankService.insertCoin(coinValue);
        //assertThat(inserted).isNotNull();
        //assertThat(inserted.getError()).isEqualTo(1);
        //assertThat(inserted.getMsg()).isEqualTo(ERROR_MSG_COIN_INVALID_DENOMINATION);
    }
}
