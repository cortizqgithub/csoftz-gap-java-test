/*----------------------------------------------------------------------------*/
/* Source File:   PIGGYBANKSERVICEIMPL.JAVA                                   */
/* Description:   Service implementation to handle Piggy Bank operations.     */
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
import com.csoftz.gap.java.tech.test.domain.PiggyBankResponse;
import com.csoftz.gap.java.tech.test.service.intr.CoinService;
import com.csoftz.gap.java.tech.test.service.intr.PiggyBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_CODE_COIN_INVALID_DENOMINATION;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.CODE_OK;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_MSG_COIN_INVALID_DENOMINATION;

/**
 * Service implementation to handle Piggy Bank operations.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.19/2018
 * @since 1.8 (JDK), May.19/2018
 */
@Service
public class PiggyBankServiceImpl implements PiggyBankService {
    private static final Logger log = LoggerFactory.getLogger(PiggyBankServiceImpl.class);
    private PiggyBank piggyBank;
    private CoinService coinService;

    /**
     * Constructor with parameters
     * @param coinService Injecs coin service to help in knowing valid coin values.
     */
    public PiggyBankServiceImpl(CoinService coinService) {
        this.coinService = coinService;
        this.piggyBank = new PiggyBank();
    }

    /**
     * Retrieves the information for a Piggy Bank instance.
     *
     * @return Reference for Piggy Bank.
     */
    @Override
    public PiggyBank retrieveStatus() {
        log.debug("Executing retrieveStatus");
        return piggyBank;
    }

    /**
     * Adds a new coin to the Piggy Bank System. If the coindValue is not
     * a valid denomintation the returned status will offer a clue about it.
     *
     * @param coinValue
     * @return The Result of the operation as a PiggyBankResponse object.
     */
    @Override
    public PiggyBankResponse insertCoin(String coinValue) {
        log.debug("Executing insertCoin()");
        log.debug("Parameter coinValue=[{}]", coinValue);

        PiggyBankResponse piggyBankResponse = null;
        boolean isValid = coinService.validate(coinValue);
        log.debug("given coinValue is valid=[{}]", isValid);

        if (!isValid) {
            piggyBankResponse = PiggyBankResponse.builder()
                .error(ERROR_CODE_COIN_INVALID_DENOMINATION)
                .msg(ERROR_MSG_COIN_INVALID_DENOMINATION).build();
        } else {
            piggyBankResponse = PiggyBankResponse.builder()
                .error(CODE_OK)
                .msg("").build();
        }

        return piggyBankResponse;
    }
}
