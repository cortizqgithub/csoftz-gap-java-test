/*----------------------------------------------------------------------------*/
/* Source File:   COINSERVICEIMPL.JAVA                                        */
/* Description:   Service implementation to handle Coin operations.           */
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

import com.csoftz.gap.java.tech.test.service.intr.CoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * Service implementation to handle Coin operations.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, May.20/2018
 * @since 1.8 (JDK), May.19/2018
 */
@Service
public class CoinServiceImpl implements CoinService {
    private static final Logger log = LoggerFactory.getLogger(CoinServiceImpl.class);
    private List<String> coinsList;

    /**
     * Sets up the valid coin values.
     *
     * @param s List of valid coin values separated with comma, it is then split into
     *          individual values. Example, '50,100,200,500,100'. If for any reason a
     *          duplicate value is given or the value is not integer, it is discarded.
     */
    @Override
    public void init(String s) {
        log.debug("Executing init()");
        log.debug("Parameter data=[{}]", s);
        String[] values = s.split(",");
        coinsList = Arrays.stream(values).map(e -> e.trim()).collect(Collectors.toList());
    }

    /**
     * Validates that given coin value is in the valid registered coinsStore.
     *
     * @param coinValue The coin value to test.
     * @return True if it is registered.
     */
    @Override
    public boolean validate(String coinValue) {
        log.debug("Executing validate()");
        log.debug("Parameter info=[{}]", coinValue);

        boolean rslt = coinsList.contains(coinValue);
        log.debug("Rslt=[{}]", rslt);

        return rslt;
    }

    /**
     * Registeres a new coin value.
     *
     * @param coinValue Value to set
     * @return True if successful registration.
     */
    @Override
    public boolean register(String coinValue) {
        log.debug("Executing register()");
        log.debug("Parameter info=[{}]", coinValue);
        boolean isValidNum = true;

        try {
            Integer.valueOf(coinValue);
        } catch (NumberFormatException e) {
            isValidNum = false;
        }
        if (isValidNum) {
            boolean exist = this.validate(coinValue);
            if (!exist) {
                coinsList.add(coinValue);
                log.debug("Rslt=[{}]", true);
                return true;
            }
            log.debug("Rslt=[{}]", false);
            return false;
        }
        log.debug("Rslt=[{}]", false);
        return false;
    }

    /**
     * Ask service about the registered coinsStore so far.
     *
     * @return A CSV formatted values of registered coinsStore. It
     * does not put spaces for every coin value.
     */
    @Override
    public String retrieveRegistered() {
        log.debug("Executing retrieveRegistered()");
        String rslt = coinsList.stream()
            .collect(joining(","));
        log.debug("Registered coin values=[{}]", rslt);
        return rslt;
    }
}
