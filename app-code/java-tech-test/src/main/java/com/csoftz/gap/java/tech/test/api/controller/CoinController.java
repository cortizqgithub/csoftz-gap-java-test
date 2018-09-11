/*----------------------------------------------------------------------------*/
/* Source File:   COINCONTROLLER.JAVA                                         */
/* Description:   REST Api for Coin end-points.                               */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          May.19/2018                                                 */
/* Last Modified: Sep.10/2018                                                 */
/* Version:       1.3                                                         */
/* Copyright (c), 2018 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 May.19/2018  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.gap.java.tech.test.api.controller;

import com.csoftz.gap.java.tech.test.service.intr.CoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * REST Api for Coin end-points.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.3, Sep.10/2018
 * @since 1.8 (JDK), May.19/2018
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1/coin")
public class CoinController {
    private static final Logger log = LoggerFactory.getLogger(CoinController.class);
    private CoinService coinService;

    /**
     * Constructor with parameters
     *
     * @param coinService Inject the Coin Service.
     */
    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    /**
     * Retrieves a list of registered coin values.
     * GET: /api/v1/coin/list
     *
     * @return List of registered coin values.
     */
    @GetMapping("/list")
    public List<String> listCoinValues() {
        log.debug("Executing listCoinValues()");

        String registeredCoinValues = coinService.retrieveRegistered();
        String[] registeredCoinValuesItems = registeredCoinValues.split(",");

        return Arrays.stream(registeredCoinValuesItems).collect(Collectors.toList());
    }
}
