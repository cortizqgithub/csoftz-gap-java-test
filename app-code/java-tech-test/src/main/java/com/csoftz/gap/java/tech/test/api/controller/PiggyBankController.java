/*----------------------------------------------------------------------------*/
/* Source File:   PIGGYBANKCONTROLLER.JAVA                                    */
/* Description:   REST Api for Piggy Bank end-points.                         */
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
package com.csoftz.gap.java.tech.test.api.controller;

import com.csoftz.gap.java.tech.test.domain.PiggyBank;
import com.csoftz.gap.java.tech.test.domain.PiggyBankResponse;
import com.csoftz.gap.java.tech.test.service.intr.PiggyBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * REST Api for Piggy Bank end-points.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, May.20/2018
 * @since 1.8 (JDK), May.19/2018
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1/piggy-bank")
public class PiggyBankController {
    private static final Logger log = LoggerFactory.getLogger(PiggyBankController.class);
    private PiggyBankService piggyBankService;

    @Value("${piggy.bank.valid.coin.values}")
    private String validCoinValues;

    /**
     * Constructor with parameters
     *
     * @param piggyBankService Injects the service to handle Piggy Bank Operations.
     */
    public PiggyBankController(PiggyBankService piggyBankService) {
        log.debug("Executing Constructor");
        this.piggyBankService = piggyBankService;
    }

    /**
     * Configure service internal properties accordingly. In fact it loads all
     * configured schemas into a hashmap so it is always available.
     *
     * @throws Exception
     * @PostConstruct means that this is called after the bean has been set-up.
     * Use this method to check that the bean has been set-up
     * correctly.
     */
    @PostConstruct
    public void postConstruct() throws Exception {
        log.debug("Executing postConstruct()");
        this.piggyBankService.initialize(validCoinValues);
    }

    /**
     * Explores the current status for Piggy Bank.
     * GET: /api/v1/piggy-bank/status
     *
     * @return
     */
    @GetMapping("/status")
    public PiggyBank watchPiggyBankStatus() {
        return this.piggyBankService.retrieveStatus();
    }

    /**
     * Get the total amount of coins saved in the Piggy Bank.
     * GET: /api/v1/piggy-bank/size
     *
     * @return
     */
    @GetMapping("/size")
    public Integer getPiggyBankTotalCoinsStored() {
        return this.piggyBankService.retrieveStatus().getSize();
    }

    /**
     * Get the saved coins grouped by coin denomination.
     * GET: /api/v1/piggy-bank/saved/coins
     *
     * @return
     */
    @GetMapping("/saved/coins")
    public Map<String, Integer> getPiggyBankSavedCoins() {
        return this.piggyBankService.retrieveStatus().getCoinsStore();
    }

    /**
     * Attemps to insert a coin into Piggy Bank.
     *
     * @param coin A value representing the coin value
     * @return Error/Message indicating failure or success operation done.
     */
    @GetMapping("/insert/{coin}")
    public PiggyBankResponse insertCoin(@PathVariable String coin) {
        return this.piggyBankService.insertCoin(coin);
    }
}
