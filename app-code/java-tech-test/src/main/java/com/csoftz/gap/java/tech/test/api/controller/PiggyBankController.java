/*----------------------------------------------------------------------------*/
/* Source File:   PIGGYBANKCONTROLLER.JAVA                                    */
/* Description:   REST Api for Piggy Bank end-points.                         */
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
package com.csoftz.gap.java.tech.test.api.controller;

import com.csoftz.gap.java.tech.test.service.intr.PiggyBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Api for Piggy Bank end-points.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, May.19/2018
 * @since 1.8 (JDK), May.19/2018
 */
@RestController
@RequestMapping("/api/v1/piggy-bank")
public class PiggyBankController {
    private static final Logger log = LoggerFactory.getLogger(PiggyBankController.class);
    private PiggyBankService piggyBankService;

    /**
     * Constructor with parameters
     *
     * @param piggyBankService Injects the service to handle Piggy Bank Operations.
     */
    public PiggyBankController(PiggyBankService piggyBankService) {
        log.debug("Executing Constructor");
        this.piggyBankService = piggyBankService;
    }
}
