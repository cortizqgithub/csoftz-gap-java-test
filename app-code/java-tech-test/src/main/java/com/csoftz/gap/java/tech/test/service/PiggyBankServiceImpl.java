/*----------------------------------------------------------------------------*/
/* Source File:   PIGGYBANKSERVICEIMPL.JAVA                                   */
/* Description:   Service implementation to handle Piggy Bank operations.     */
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
package com.csoftz.gap.java.tech.test.service;

import com.csoftz.gap.java.tech.test.domain.PiggyBank;
import com.csoftz.gap.java.tech.test.domain.PiggyBankResponse;
import com.csoftz.gap.java.tech.test.service.intr.CoinService;
import com.csoftz.gap.java.tech.test.service.intr.PiggyBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.CODE_OK;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_CODE_CANNOT_WITHDRAW_COIN;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_CODE_COIN_INVALID_DENOMINATION;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_MSG_CANNOT_WITHDRAW_COIN;
import static com.csoftz.gap.java.tech.test.common.consts.GlobalConsts.ERROR_MSG_COIN_INVALID_DENOMINATION;

/**
 * Service implementation to handle Piggy Bank operations.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, May.20/2018
 * @since 1.8 (JDK), May.19/2018
 */
@Service
public class PiggyBankServiceImpl implements PiggyBankService {
    private static final Logger log = LoggerFactory.getLogger(PiggyBankServiceImpl.class);
    private PiggyBank piggyBank;
    private CoinService coinService;

    /**
     * Constructor with parameters
     *
     * @param coinService Injecs coin service to help in knowing valid coin values.
     */
    public PiggyBankServiceImpl(CoinService coinService) {
        this.coinService = coinService;
        this.piggyBank = new PiggyBank();
    }

    /**
     * Configures the service and its dependencies.
     *
     * @param validCoinValues The list of valid coin values in CSV format, e.g., "50, 100, 200, 500, 1000".
     */
    public void initialize(String validCoinValues) {
        log.debug("Executing initialize()");
        log.debug("Using coin denominations:[{}]", validCoinValues);
        this.coinService.init(validCoinValues);

        String registeredCoins = this.coinService.retrieveRegistered();
        this.piggyBank.setSize(0);
        Map<String, Integer> coinStore = this.piggyBank.getCoinsStore();
        String[] coins = registeredCoins.split(",");
        Arrays.stream(coins).forEach(c -> coinStore.put(c.trim(), 0));
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
                .msg(ERROR_MSG_COIN_INVALID_DENOMINATION)
                .build();
        } else {
            Integer selValue = piggyBank.getCoinsStore().get(coinValue);
            selValue += 1;
            piggyBank.getCoinsStore().put(coinValue, selValue);
            piggyBank.setSize(piggyBank.getSize() + 1);
            piggyBankResponse = PiggyBankResponse.builder()
                .error(CODE_OK)
                .msg("")
                .build();
        }

        return piggyBankResponse;
    }

    /**
     * Removes any coin from Piggy Bank.
     *
     * @return The Result of the operation as a PiggyBankResponse object.
     */
    @Override
    public PiggyBankResponse remove() {
        log.debug("Executing remove()");
        log.debug("As the specification dictates it is always forbidden. Maybe in the future this will be allowed.");
        return PiggyBankResponse.builder()
            .error(ERROR_CODE_CANNOT_WITHDRAW_COIN)
            .msg(ERROR_MSG_CANNOT_WITHDRAW_COIN)
            .build();
    }
}
