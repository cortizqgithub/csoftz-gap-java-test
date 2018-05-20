/*----------------------------------------------------------------------------*/
/* Source File:   PIGGYBANK.JAVA                                              */
/* Description:   Defines the Piggy Bank Information Status Object.           */
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
package com.csoftz.gap.java.tech.test.domain;

import lombok.Data;

import java.util.Map;
import java.util.TreeMap;

/**
 * Defines the Piggy Bank Information Status Object.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.2, May.20/2018
 * @since 1.8 (JDK), May.19/2018
 */
@Data
public class PiggyBank {
    private int size;
    private Map<String, Integer> coinsStore;

    /**
     * Default constructor;
     */
    public PiggyBank() {
        this.coinsStore = new TreeMap<>();
    }
}
